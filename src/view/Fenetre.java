package view;

import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import option.ConfFenetre;
import option.EventFenetre;
import option.ParamFenetre;
import data.DataConf;
import data.DataVue;
import data.Model;

public class Fenetre extends JFrame implements Observer {

    private Container content = getContentPane();
    private Conteneur conteneur;
    private File paramFile;
    private Model model;

    public Fenetre(Model model) {
        super(DataVue.windowsTitle);

        this.model = model;
        model.addObserver(this);

        // directory creation
        (new File(DataConf.repConf)).mkdirs();

        File fichierConf = new File(DataConf.fichierConf);
        if (fichierConf.exists()) {
            // config in the file
            try {
                ConfFenetre.restoreOptions(this, fichierConf);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            // default configuration
            // the file is created as soon as the windows is moved or resized
            this.setSize(400, 200);
            this.setLocationByPlatform(true);
        }


        paramFile = new File(DataConf.fichierParam);
        if (paramFile.exists()) {
            // retrieve parameters
            try {
                ParamFenetre.restoreParam(paramFile, model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // default parameters
            System.out.println("blanc : " + Color.WHITE);
            model.setColor(Color.WHITE);

            try {
                ParamFenetre.saveParam(paramFile, model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        conteneur = new Conteneur(this.model);
        this.setJMenuBar(new MenuFenetre(this, this.model));

        content.add(conteneur);
        this.addWindowListener(new EventFenetre(this, fichierConf));
        this.addComponentListener(new EventFenetre(this, fichierConf));

        this.setVisible(true);
    }


    public void update(Observable arg0, Object arg1) {
        try {
            ParamFenetre.saveParam(paramFile, model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            conteneur.removeAll();
        } catch (Exception e) {
        }
        conteneur = new Conteneur(model);
        content.add(conteneur);
        //noinspection Since15
        content.revalidate();
    }

}
