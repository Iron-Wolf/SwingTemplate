package option;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import data.Model;

public class ParamFenetre {

    public static void saveParam(File fichier, Model model) throws Exception {
        Properties p = new Properties();

        p.setProperty("couleur", "" + model.getColor().getRGB());

        // write to file
        BufferedWriter br = new BufferedWriter(new FileWriter(fichier));
        p.store(br, "Properties of the application");

        // close buffer
        br.close();
    }


    public static void restoreParam(File fichier, Model model) throws Exception {
        Properties p = new Properties();

        // read the file
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        p.load(br);

        model.setColor(new Color(Integer.parseInt(p.getProperty("couleur"))));

        // close buffer
        br.close();
    }

}
