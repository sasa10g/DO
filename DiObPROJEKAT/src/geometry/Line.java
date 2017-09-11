package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	public Line(){
		
	}
	
	public Line(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(boolean selected, Color lineColor, Point startPoint, Point endPoint){
		super(selected, lineColor);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.getEndPoint().getY());
		
		if (selected) {
			selected(g);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		Point point = new Point(x,y);
		if (size() + 3 > startPoint.distance(point) + endPoint.distance(point))
			return true;
		else
			return false;
	}
	
	public Point middlePoint(){
		return new Point((startPoint.getX() + endPoint.getX()) / 2,
				(startPoint.getY() + endPoint.getY()) / 2);
	}
	
	public void selected(Graphics g){
		g.setColor(Color.BLUE);
		startPoint.selected(g);
		endPoint.selected(g);
		middlePoint().selected(g);
		
	}
	
	@Override
	public void moveOn(int x, int y) {
		// TODO Auto-generated method stub
		int moveX = endPoint.getX()-(startPoint.getX()-x);
		int moveY = endPoint.getY()-(startPoint.getY()-y);
		if(x > 0 && y > 0 && moveX > 0 && moveY > 0){
			
			movedOnX = this.startPoint.getX();
			movedOnY = this.startPoint.getY();
			
			endPoint.moveOn(moveX, moveY);
			startPoint.moveOn(x, y);
		}
		else
		JOptionPane.showMessageDialog(null, "Invalid function", "Error",
				JOptionPane.ERROR_MESSAGE);
		
		
	}

	@Override
	public void moveFor(int x, int y) {
		// TODO Auto-generated method stub
		
			startPoint.moveFor(x, y);
			endPoint.moveFor(x, y);

	}
	
	
	public double size(){
		return startPoint.distance(endPoint);
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
