package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Square {

	private int height;
	
	public Rectangle(){}
	
	public Rectangle(boolean selected, Color lineColor, Color fillColor,
			Point topLeftPoint, int side, int height){
		super(selected, lineColor, fillColor, topLeftPoint, side);
		this.height = height;
	}
	
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);		
		new Line(selected, fillColor, topLeftPoint, new Point(topLeftPoint.getX()+side, topLeftPoint.getY())).selected(g);
		new Line(selected, fillColor, topLeftPoint, new Point(topLeftPoint.getX(), topLeftPoint.getY()+height)).selected(g);
		new Line(selected, fillColor, new Point(topLeftPoint.getX()+side, topLeftPoint.getY()), diagonal().getEndPoint()).selected(g);
		new Line(selected, fillColor, new Point(topLeftPoint.getX(), topLeftPoint.getY()+height), diagonal().getEndPoint()).selected(g);
	}
	
	
	public void draw(Graphics g){
		g.setColor(fillColor);
		g.fillRect(topLeftPoint.getX(), topLeftPoint.getY(), side, height);
		g.setColor(lineColor);
		g.drawRect(topLeftPoint.getX(), topLeftPoint.getY(), side, height);
		if(selected)
			selected(g);
	}
	
	public double getArea(){
		return side*height;
	}
	
	public boolean contains(int x, int y){
		if(x <= topLeftPoint.getX()+side && x > topLeftPoint.getX() &&
				y <= topLeftPoint.getY()+height && y > topLeftPoint.getY())
			return true;
		else
			return false;
	}
	
	public Line diagonal(){
		return new Line(selected, fillColor, topLeftPoint, 
				new Point(topLeftPoint.getX()+side, topLeftPoint.getY()+height));
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}