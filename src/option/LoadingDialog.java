package option;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class LoadingDialog extends JFrame {

    private JProgressBar progressbar;
    private int progress = 0;

    public LoadingDialog(String texte) {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // disposition manager
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());

        // label with some text
        JLabel t = new JLabel();
        t.setText(texte);
        pane.add(t, BorderLayout.NORTH);

        // bar properties
        progressbar = new JProgressBar(0, 100);
        progressbar.setValue(0);
        progressbar.setStringPainted(true);
        pane.add(progressbar, BorderLayout.SOUTH);

        setContentPane(pane);

        this.pack();
        this.setLocationRelativeTo(null); // must be after the pack()
        this.setVisible(true);
    }


    @Deprecated
    public void loop() {
        int position = 0;
        while (position <= 100) {
            progressbar.setValue(position);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            position += 5;
        }
    }


    public void loopStep() {
        if (progress <= 100) {
            progress += 25;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            progressbar.setValue(progress);
        }
    }

}