package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Model;

public class Conteneur extends JPanel implements ActionListener {

    // application parameters
    private Color color;
    private String paramA;
    private String paramB;

    // graphical objects
    private JLabel j = new JLabel();
    private JButton b;


    public Conteneur(Model m) {
        this.setLayout(new BorderLayout());

        j.setText("Hello");
        j.setForeground(m.getColor());

        this.add(j, BorderLayout.CENTER);

        b = new JButton("test");
        b.addActionListener(this);
        this.add(b, BorderLayout.NORTH);
    }


    public void setCouleur(Color c) {
        color = c;
    }

    public void setParamA(String texte) {
        paramA = texte;
    }

    public void setParamB(String texte) {
        paramB = texte;
    }

    public Color getCouleur() {
        return color;
    }

    public String getParamA() {
        return paramA;
    }

    public String getParamB() {
        return paramB;
    }


    public void updateUI() {
        // JPanel : revalidate();
    }

    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == b) {
            System.out.println("bouton ok");
        }
    }
}
