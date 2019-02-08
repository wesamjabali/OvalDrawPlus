//Author: Wesam Jabali
//OvalDrawPlus
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;
import java.awt.Component;

class Oval extends JPanel {
    Oval() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.fillRect(0, 100, 100, 100);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        //Color rectColor = new Color(0,255,0);
        //g.fillRect(0,0,panelWidth, panelHeight);

        Color myColor = new Color(255,0,0);
        g.setColor(myColor);

        g.fillOval(0, 0, panelWidth, panelHeight);
    }
}

class OvalFrame extends JFrame {
    OvalFrame() {
        setBounds(300, 300, 300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OvalDraw");

        Oval myOval = new Oval();
        Container contentPane = getContentPane();
        contentPane.add(myOval);
    }
}

public class OvalDrawPlus {
        public static void main(String[] args) {
        System.out.println("See new window.");
        OvalFrame myFrame = new OvalFrame();
        myFrame.setVisible(true);

    }
}
