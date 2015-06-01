package lab8;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.*;

public class Circle implements FillableShape {
	
	public Circle(int xpos, int ypos, int r, Color color) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.r = r;
		this.color = color;
	}
	
	// returns true if point (x,y) is inside the shape
	public boolean contains(int x, int y) {
		int centerx = xpos + r;
		int centery = ypos + r;
		return ((x-centerx)*(x-centerx)+(y-centery)*(y-centery) < r*r);		
	}
	
	// draws this shape in the specified graphics context
	public void draw(Graphics g) {
		g.setColor(color);
		if (isFilled()) {
			g.fillOval(xpos, ypos, 2*r, 2*r);
		} else {
			g.drawOval(xpos, ypos, 2*r, 2*r);
		}
	}
	
	// returns the area of this shape
	public double getArea() {
		return PI*r*r;
	}
	
	// returns the length of the perimeter of this shape
	public double getPerimeter() {
		return 2*PI*r;
	}
	
	// returns true, if this shape is filled; false, otherwise.
	public boolean isFilled() {
		return filled;
	}
	
	// sets the state of this shape to filled or not filled.
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	private int xpos, ypos, r;
	private Color color;
	private boolean filled;
}
