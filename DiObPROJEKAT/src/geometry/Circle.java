package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {

	private int radius;
	private Point center;
	
	public Circle(){}
	
	public Circle(boolean selected, Color lineColor, Color fillColor, Point center, int radius){
		super(selected, lineColor, fillColor);
		this.center = center;
		this.radius = radius;
				
	}
		
	@Override
	public double getArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		g.setColor(lineColor);
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		if(selected){
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-radius-3, center.getY()-3, 5, 5);
			g.drawRect(center.getX()+radius-3, center.getY()-3, 5, 5);
			g.drawRect(center.getX(), center.getY()-radius-2, 5, 5);
			g.drawRect(center.getX(), center.getY()+radius+3, 5, 5);
		}

	}

	@Override
	public boolean contains(int x, int y) {		
		if(center.distance(new Point(x,y)) < this.radius){
			return true;
		}
		else
			return false;
	}

		
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
