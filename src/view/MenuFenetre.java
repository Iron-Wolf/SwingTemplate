package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import data.DataConf;
import data.Model;
import org.h2.store.fs.FileUtils;

public class MenuFenetre extends JMenuBar implements ActionListener {

    private JMenuItem itemSupprimerTout, itemQuitter,
            itemParametres,
            itemAbout;

    private JFrame frame;
    private Model model;

    public MenuFenetre(JFrame f, Model model) {
        frame = f; // windows to which the menu is attached
        this.model = model; // container on which the menu bar acts

        // menu Fichier
        JMenu menuFichier = new JMenu(" Fichier ");

        itemSupprimerTout = new JMenuItem(" Supprimer (tout) ");
        itemSupprimerTout.addActionListener(this);
        menuFichier.add(itemSupprimerTout);
        menuFichier.addSeparator();

        itemQuitter = new JMenuItem(" Quitter ");
        itemQuitter.addActionListener(this);
        menuFichier.add(itemQuitter);

        // menu Editer
        JMenu menuEditer = new JMenu(" Editer ");
        itemParametres = new JMenuItem(" Paramètres ");
        itemParametres.addActionListener(this);
        menuEditer.add(itemParametres);

        // menu Aide
        JMenu menuAide = new JMenu(" Aide ");
        itemAbout = new JMenuItem(" A propos ");
        itemAbout.addActionListener(this);
        menuAide.add(itemAbout);

        // add to menu bar
        this.add(menuFichier);
        this.add(menuEditer);
        this.add(menuAide);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemSupprimerTout) {
            // delete all the files and the folder
            FileUtils.deleteRecursive(DataConf.repConf, true);

            if (checkFile()) {
                // there is some file left
                System.out.println("Une erreur est survenue");
            } else {
                // all files are deleted
                itemSupprimerTout.setEnabled(false);
            }
        }

        if (e.getSource() == itemQuitter) {
            // send the trigger to the windows
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }

        if (e.getSource() == itemParametres) {
            Color couleur = JColorChooser.showDialog
                    (frame, "couleur du fond", Color.WHITE);
            model.setColor(couleur);
        }
    }


    /**
     * Check if files still exists
     *
     * @return true if files are still here
     */
    private boolean checkFile() {
        return (new File(DataConf.fichierConf).exists()
                || new File(DataConf.fichierParam).exists()
                || new File(DataConf.repConf).exists());
    }
}
