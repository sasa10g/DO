package composite;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Shape;

public class Mouth extends Shape implements Component {

	ArrayList<Shape> children = new ArrayList<Shape>();
	private Circle head;
	private Line leftLine;
	private Line middleLine;
	private Line rightLine;
	private Point startP1, endP1StartP2, endP2StartP3, endP3;
	private int p1X, p1Y, p2X, p2Y, p3X, p3Y, p4X, p4Y;
	private double p = 0.7;
	
	public Mouth() {
		
	}
	public Mouth(ArrayList<Shape> children){
		this.children = children;
		
	}


	public Mouth(Circle head){
		this.head = head;
		p1X = (int)(head.getCenter().getX() - head.getRadius() * p);
		p1Y = head.getCenter().getY();
		
		p2X = (int)(head.getCenter().getX()- head.getRadius() / 2);
		p2Y = (int)(head.getCenter().getY() + head.getRadius() / 2);
		
		p3X = (int)(head.getCenter().getX()- head.getRadius() / 2) + head.getRadius();
		p3Y = (int)(head.getCenter().getY() + head.getRadius() / 2);
		
		p4X = (int)(head.getCenter().getX() + head.getRadius() * p);
		p4Y =  head.getCenter().getY();
		
		startP1 = new Point(p1X, p1Y);
		endP1StartP2 = new Point(p2X, p2Y+6);
		//usta
		endP2StartP3 = new Point(p3X, p3Y+6);
		endP3 = new Point(p4X, p4Y);
		
		leftLine = new Line(startP1, endP1StartP2);
		middleLine = new Line(endP1StartP2, endP2StartP3);
		rightLine = new Line(endP2StartP3, endP3);
		children.add(leftLine);
		children.add(middleLine);
		children.add(rightLine);
		
		
	}

	
	@Override
	public void add(Shape s) {
		children.add(s);

	}

	@Override
	public void remove(Shape s) {
		children.remove(s);

	}

	@Override
	public void draw(Graphics g) {
		for(Shape shape: children){
			shape.draw(g);
		}
	}
	
	public void setLineColor(Color color){
		for(Shape shape :children)
			shape.setLineColor(head.getLineColor());
	}

	@Override
	public boolean contains(int x, int y) {
		
		return false;
	}

/*
	@Override
	public void moveOn(int x, int y) {
		leftLine.moveOn( (int)(head.getCenter().getX() - head.getRadius()* p), head.getCenter().getY());
		middleLine.moveOn((int)(head.getCenter().getX()- head.getRadius() / 2), 
				(int)(head.getCenter().getY() + head.getRadius() / 2));
		rightLine.moveOn((int)(head.getCenter().getX()- head.getRadius() / 2)+ head.getRadius(), 
				(int)(head.getCenter().getY() + head.getRadius() / 2));
		
	}

	@Override
	public void moveFor(int x, int y) {
		leftLine.moveFor(x, y);
		middleLine.getEndPoint().moveFor(x, y);
		rightLine.getEndPoint().moveFor(x, y);
		
	}
	
*/
	public ArrayList<Shape> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Shape> children) {
		this.children = children;
	}
	public Circle getHead() {
		return head;
	}
	public void setHead(Circle head) {
		this.head = head;
	}
	@Override
	public void selected(Graphics g) {
		for (Shape shape:children){
			shape.selected(g);
		}
		
	}

}
