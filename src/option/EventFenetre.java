package option;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;

public class EventFenetre implements WindowListener, ComponentListener {
    private JFrame chF;
    private File chFile;

    public EventFenetre(JFrame f, File fichier) {
        chF = f;
        chFile = fichier;
    }


    public void windowActivated(WindowEvent arg0) {
    }

    public void windowClosed(WindowEvent arg0) {
    }

    public void windowClosing(WindowEvent arg0) {
        // when the windows is closed
        // we save his parameters and close
        try {
            ConfFenetre.storeOptions(chF, chFile);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        System.exit(0);
    }

    public void windowDeactivated(WindowEvent arg0) {
    }

    public void windowDeiconified(WindowEvent arg0) {
    }

    public void windowIconified(WindowEvent arg0) {
    }

    public void windowOpened(WindowEvent arg0) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
        try {
            ConfFenetre.storeOptions(chF, chFile);
        } catch (Exception e1) {
            //e1.printStackTrace();
        }
    }

    public void componentResized(ComponentEvent e) {
        try {
            ConfFenetre.storeOptions(chF, chFile);
        } catch (Exception e1) {
            //e1.printStackTrace();
        }
    }

    public void componentShown(ComponentEvent e) {
    }
}
