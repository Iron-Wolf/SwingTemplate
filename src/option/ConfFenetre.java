package option;

import java.awt.Frame;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

public class ConfFenetre {

    /**
     * Save the position and the size of the windows
     * in a file
     *
     * @param f
     * @param file
     * @throws Exception
     */
    public static void storeOptions(Frame f, File file) throws Exception {
        Properties p = new Properties();

        // save the data
        if (f.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
            // the windows is not maximized
            int x = f.getX();
            int y = f.getY();
            int w = f.getWidth();
            int h = f.getHeight();

            p.setProperty("x", "" + x);
            p.setProperty("y", "" + y);
            p.setProperty("w", "" + w);
            p.setProperty("h", "" + h);
        } else {
            // the windows is maximized
            // we save the data from the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            p.load(br);

            int x = Integer.parseInt(p.getProperty("x"));
            int y = Integer.parseInt(p.getProperty("y"));
            int w = Integer.parseInt(p.getProperty("w"));
            int h = Integer.parseInt(p.getProperty("h"));

            p.setProperty("x", "" + x);
            p.setProperty("y", "" + y);
            p.setProperty("w", "" + w);
            p.setProperty("h", "" + h);
        }

        // value of the windows (maximized or not)
        p.setProperty("extState", String.valueOf(f.getExtendedState()));

        // write to file
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        p.store(br, "Properties of the user frame");

        // close buffer
        br.close();
    }


    /**
     * Restore parameters from file
     *
     * @param f
     * @param file
     * @throws IOException
     */
    public static void restoreOptions(Frame f, File file) throws IOException {
        Properties p = new Properties();

        // read file
        BufferedReader br = new BufferedReader(new FileReader(file));
        p.load(br);

        int extState = Integer.parseInt(p.getProperty("extState"));

        int x = Integer.parseInt(p.getProperty("x"));
        int y = Integer.parseInt(p.getProperty("y"));
        int w = Integer.parseInt(p.getProperty("w"));
        int h = Integer.parseInt(p.getProperty("h"));

        Rectangle r = new Rectangle(x, y, w, h);
        f.setBounds(r);
        f.setExtendedState(extState);

        // close buffer
        br.close();
    }

}