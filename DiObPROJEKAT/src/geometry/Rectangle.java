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
		new Line(selected, fillColor, topLeftPoint, new Point(topLeftPoint.getX()+side, topLeftPoint.getY()));
		new Line(selected, fillColor, topLeftPoint, new Point(topLeftPoint.getX(), topLeftPoint.getY()+height));
		new Line(selected, fillColor, new Point(topLeftPoint.getX()+side, topLeftPoint.getY()), diagonal().getEndPoint());
		new Line(selected, fillColor, new Point(topLeftPoint.getX(), topLeftPoint.getY()+height), diagonal().getEndPoint());
		
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

/*	public String toString(){
		return "Top left point: "+ "("+topLeftPoint.getX()+","+topLeftPoint.getY()+") "+
				", Side: "+ Integer.toString(side) + ", Height: "+ Integer.toString(height) 
				+ ", "+ lineColorToString()+ ", " + fillColorToString();
	}
	
	public String txtToString(){
		return topLeftPoint.getX()+","+topLeftPoint.getY()+","
				 +Integer.toString(side) + ","+ Integer.toString(height) 
				+ ","+ lineColor.getRGB()+ "," + fillColor.getRGB();
	}*/

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}