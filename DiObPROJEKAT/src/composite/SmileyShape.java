package composite;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import geometry.Circle;
import geometry.Point;
import geometry.Shape;
import geometry.SurfaceShape;

public class SmileyShape extends SurfaceShape implements Component {

	private ArrayList<Shape> children = new ArrayList<Shape>();
	private Circle head;
	private Point leftEye;
	private Point rightEye;
	private Mouth mouth;
	
	
	public SmileyShape() {
		
	}
	
	public SmileyShape(ArrayList<Shape> children){		
		this.children = children;
			
	}
	
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
			if(selected){
				selected(g);
			}
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		if(children.get(0).contains(x, y)){
			return true;
		}
		return false;
	}
	
	
	public void selected(Graphics g) {
		for(Shape selectedShape: children){
			selectedShape.selected(g);
		}
		
	}

	
	public String toString(){
		return head.toString();
	}


	@Override
	public void moveOn(int x, int y) {
		
		movedOnX = head.getCenter().getX();
		movedOnY = head.getCenter().getY();
		head.moveOn(x, y);
		leftEye.moveOn(head.getCenter().getX()-head.getRadius()/2, head.getCenter().getY() - head.getRadius()/2);
		rightEye.moveOn(head.getCenter().getX()+head.getRadius()/2,head.getCenter().getY() - head.getRadius()/2);
		mouth.moveOn(x, y);
	
	}


	@Override
	public void moveFor(int x, int y) {
		for(Shape shape: children){
			
				shape.moveFor(x, y);
			
		}
		
	}


	public ArrayList<Shape> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Shape> children) {
		this.children = children;
	}

	public Point getLeftEye() {
		return leftEye;
	}

	public void setLeftEye(Point leftEye) {
		this.leftEye = leftEye;
	}

	public Point getRightEye() {
		return rightEye;
	}

	public void setRightEye(Point rightEye) {
		this.rightEye = rightEye;
	}

	public Mouth getMouth() {
		return mouth;
	}

	public void setMouth(Mouth mouth) {
		this.mouth = mouth;
	}

	public Circle getHead() {
		return head;
	}

	public void setHead(Circle head) {
		this.head = head;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Color getLineColor(){
		return head.getLineColor();
	}
	
	public void setLineColor(Color lineColor){
		for(Shape shape: children){
			shape.setLineColor(lineColor);
		}
	}
	
	public Color getFillColor(){
		return head.getFillColor();
	}
	
	public void setFillColor(Color fillColor){
		head.setFillColor(fillColor);
	
	}


}
