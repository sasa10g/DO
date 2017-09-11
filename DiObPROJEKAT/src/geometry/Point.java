package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	
	public Point() {}
	
		
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(boolean selectded, Color lineColor,int x, int y) {
		super(selectded, lineColor);
		this.x = x;
		this.y = y;
	}


	@Override
	public void draw(Graphics g) {
		g.setColor(lineColor);
		g.drawLine(x, y-1, x, y+1);
		g.drawLine(x-1, y, x+1, y);
		if (selected) {
			selected(g);
		}

	}

	@Override
	public boolean contains(int x, int y) {
		int dx = this.x-x;
		int dy = this.y-y;
		if(Math.abs(dx)< 3 && Math.abs(dy)< 3)
			return true;
		else
			return false;
	}
	
	public Point middlePoint(Point p){
		double dx = Math.abs(x+p.x)/2;
		double dy = Math.abs(y+p.y)/2;
		return new Point((int)dx, (int)dy); 
	}
	
	public void selected(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect(x-2, y-2, 4, 4);
	}

	public double distance(Point p) {
		int dx = x-p.x;
		int dy = y-p.y;
		return Math.sqrt(dx * dx + dy * dy);
		
	}
	
	@Override
	public void moveOn(int x, int y) {
		movedOnX = this.x;
		movedOnY = this.y;
		
		this.x = x;
		this.y = y;

	}
	
	@Override
	public void moveFor(int x, int y) {	
			this.x +=x;
			this.y +=y;
			
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
