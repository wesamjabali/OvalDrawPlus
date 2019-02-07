import javax.swing.JFrame;

class OvalFrame extends JFrame {
    OvalFrame() {
        setTitle("OvalDraw");
        setBounds(200,200,300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

public class OvalDraw {
    public static void main(String[] args) {
        System.out.println("OvalDraw Starting...");
        OvalFrame myFrame = new OvalFrame();

        myFrame.setVisible(true);
    }
}
