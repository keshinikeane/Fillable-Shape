package lab8;

import java.awt.Graphics;
import java.awt.Color;
import static java.lang.Math.*;

public class Triangle extends java.awt.Polygon implements FillableShape {
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
		super(new int[]{x1,x2,x3}, new int[]{y1,y2,y3}, 3);
		this.color = color;
	}
	
	// don't need contains because this method is already in the super class
	// returns true if point (x,y) is inside the shape
	//public boolean contains(int x, int y) {
	//	return false;
	//}
	
	// draws this shape in the specified graphics context
	public void draw(Graphics g) {
		g.setColor(color);
		if (isFilled()) {
			g.fillPolygon(this);
		} else {
			g.drawPolygon(this);
		}
	}

	// returns the area of this shape
	public double getArea() {
		return abs((xpoints[0]*(ypoints[1]-ypoints[2])+xpoints[1]*(ypoints[2]-ypoints[0])+
				xpoints[2]*(ypoints[0]-ypoints[1]))/2.0);
	}

	// returns the length of the perimeter of this shape
	public double getPerimeter() {
		return sqrt(pow(xpoints[1]-xpoints[0],2)+pow(ypoints[1]-ypoints[0],2))+sqrt(pow(xpoints[2]-xpoints[1],2)+
				pow(ypoints[2]-ypoints[1],2))+sqrt(pow(xpoints[0]-xpoints[2],2)+pow(ypoints[0]-ypoints[2],2));
	}

	// returns true, if this shape is filled; false, otherwise.
	public boolean isFilled() {
		return filled;
	}

	// sets the state of this shape to filled or not filled.
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	private Color color;
	private boolean filled;
}
