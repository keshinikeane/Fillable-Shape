package lab8;

import java.awt.Graphics;

public interface FillableShape {
	public boolean contains(int x, int y);
	public void draw(Graphics g);
	public double getArea();
	public double getPerimeter();
	public boolean isFilled();
	public void setFilled(boolean filled);
}
