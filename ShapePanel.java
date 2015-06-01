package lab8;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * A panel that demonstrates drawing and interaction with fillable shapes.
 * This class extends the standard class javax.swing.JPanel, and overrides
 * the method paintComponent defined by that base class to draw all of the 
 * shapes.
 * @author Dave Hale, Colorado School of Mines
 */
public class ShapePanel extends JPanel {

  public static void main(String[] args) {
    new ShapePanel();
  }

  public ShapePanel() {

    // Add some shapes to this panel. Keep these three shapes, 
    // but add more shapes to this panel if you like.
    shapeList.add(new Circle(50,50,25,Color.RED));
    shapeList.add(new Circle(300,300,100,Color.BLUE));
    shapeList.add(new Triangle(50,50,200,400,300,100,Color.GREEN));
    shapeList.add(new Triangle(400,50,500,50,400,150,Color.MAGENTA));
    // For interacting with our shapes.
    addMouseListener(new ShapeHandler());

    // The window frame that contains this panel.
    JFrame frame = new JFrame();
    frame.add(this);
    frame.setSize(600,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Overrides the method paintComponent in the base class.
  // That base-class implementation does something important. 
  // What is that?
  // To be sure you understand this, temporarily comment out the 
  // statement below that calls the base-class implementation.
  // Then put the statement back (uncomment it) and annotate this
  // method with comments that explain what each statement does.
  public void paintComponent(Graphics g) { // create new method to override method in base class to draw shapes
    super.paintComponent(g); // Why? calls method from base class JPanel, need it to repaint
    for (FillableShape shape:shapeList) // for each shape in shapeList of type FillableShape
      shape.draw(g); // draws shape using method from base class
  }

  ///////////////////////////////////////////////////////////////////////////
  // private

  // A class inside a class! This is called an "inner class".
  // This class extends the standard class java.awt.MouseAdapter, and 
  // overrides the method mouseClicked to interact with the shapes 
  // contained in a private list in its *outer* class ShapePanel.
  private class ShapeHandler extends MouseAdapter {

    // Overrides the method mouseClicked in the base class.
    // What does that implementation do? Why do we not call it here?
    // Annotate each line below with comments that explain what each 
    // line does. Ensure that our grader can understand your comments.
    public void mouseClicked(MouseEvent e) {
      // super.mouseClicked(e); // Why not? don't have to override base class if using standard components, don't want to reset every time
      int x = e.getX(); // get x coordinate of mouse click
      int y = e.getY(); // get y coordinate of mouse click
      for (FillableShape shape:shapeList) { // for each shape in shapeList of type FillableShape
        if (shape.contains(x,y)) { // if mouse click coordinates are inside one of the shapes
          System.out.println("shape = "+shape.getClass().getName()); // print the name of the clicked shape
          System.out.println("area = "+shape.getArea()); // print the area of the shape
          System.out.println("perimeter = "+shape.getPerimeter()); // print the perimeter of the shape
          shape.setFilled(!shape.isFilled()); // change whether the shape is filled or unfilled
        }
      }
      repaint(); // redraw the entire panel with all the shapes
    }
  }

  // A list of fillable shapes. Better than some fixed-size array,
  // because an ArrayList will grow as necessary when we add shapes.
  private ArrayList<FillableShape> shapeList = 
    new ArrayList<FillableShape>();
}
