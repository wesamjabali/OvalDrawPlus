//OvalDrawPlus
//Authored by: Wesam Jabali
//My favorite color is Yellow

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

abstract class Shape extends JPanel {
    private int posX;
    private int posY;
    private int height;
    private int width;
    protected Color myColor;

    //setters
    public final void setHeight(int hi) {height = hi;}
    public final void setWidth(int wi) {width = wi;}
    public final void setPosX(int xIn) {posX = xIn;}
    public final void setPosY(int yIn) {posY = yIn;}
    public final void setColor(int red, int green, int blue) {
        this.myColor = new Color(red,green,blue);
    }

    //getters
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public String getColor() {return String.format("(%d, %d, %d)", myColor.getRed(), myColor.getGreen(), myColor.getBlue());}

    //Constructors
    public Shape() {this(0, 0, 0, 0);}
    public Shape(int hIn, int wIn) {this(hIn, wIn, 0, 0);}
    public Shape(int hIn, int wIn, int xIn, int yIn) {
        setHeight(hIn);
        setWidth(wIn);
        setPosX(xIn);
        setPosY(yIn);
    }

    abstract public double calcArea();
    abstract public double calcPerimteter();
    abstract public void paintComponent(Graphics g);

    public String toString() {
        return String.format("posX = %d, position = %d, height = %d, width = %d", posX, posY, height, width);
    }
}

class Rectangle extends Shape {
    public Rectangle(){super(0, 0, 0, 0);}
    public Rectangle(int hIn, int wIn) {super(hIn, wIn, 0, 0);}
    public Rectangle(int hIn, int wIn, int xIn, int yIn) {super(hIn, wIn, xIn, yIn);}
    
    public double calcArea() {return (getHeight()*getWidth());}
    public double calcPerimteter() {return (getWidth() * 2) + (getHeight() * 2);}

    public void paintComponent(Graphics g) {        //For drawing to Panel
        g.setColor(myColor);
        g.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
    }
}


class Circle extends Shape {
    private int radius;
    public final int getRadius(){return radius;}
    public final void setRadius(int radIn){
        radius = radIn;
        setHeight(radIn * 2);
        setWidth(radIn * 2);
    }

    Circle() {this(0);}

    Circle(int radIn) { 
    setRadius(radIn);
    }

    Circle(int radIn, int xIn, int yIn) {
        setRadius(radIn);
        setPosX(xIn);
        setPosY(yIn);
    }

    public String toString() {
        String superToString = super.toString();
        return String.format("%s, radius = %d ", superToString, radius);
    }

    public double calcArea() {
        return Math.PI * radius * radius;
    }

    public double calcPerimteter() {
        return (Math.PI*2)*radius;
    }
    public void paintComponent(Graphics g) {
        g.setColor(myColor);
        g.fillOval(getPosX(), getPosY(), getWidth(), getHeight());
    }
}

class MainFrame extends JFrame {
    MainFrame() {
        setBounds(300,300,300,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wesam's OvalDrawPlus");
    }

    public void displayShape(Shape myShape)
    {
        Container contentPane = getContentPane();
        contentPane.add(myShape);
    }
}

public class OvalDrawPlus { 
    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.setVisible(true);

        Circle myCircle = new Circle(100,0,0);
        myCircle.setColor(255, 255, 0);                         //Yellow
        Rectangle myRectangle = new Rectangle(200, 200, 0, 0);
        myRectangle.setColor(30, 0, 255);                       //Set the color per individual shape

        myFrame.displayShape(myCircle);                         //These put the panes/shapes onto the Frame
        myFrame.displayShape(myRectangle);

        ArrayList<Shape> shapeList = new ArrayList<Shape>();    //Original Program still works
        shapeList.add(myCircle);                                
        shapeList.add(myRectangle);
        
        for(Shape s: shapeList) {                               //This displays info about the drawn shapes
            System.out.println(s);
            System.out.format("Area = %.1f\n", s.calcArea());
            System.out.format("Perimeter = %1f\n", s.calcPerimteter());
            System.out.format("Color: %s\n", s.getColor());
            myFrame.displayShape(s);
        }
    }
}
