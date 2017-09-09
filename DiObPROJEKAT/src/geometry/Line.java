package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	public Line(){}
	
	public Line(boolean selected, Color lineColor, Point startPoint, Point endPoint){
		super(selected, lineColor);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.getEndPoint().getY());

	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
