package model;

import java.util.ArrayList;

import geometry.Shape;

public class Model {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public Model(){}
	
	public void AddShape(Shape shape){
		shapes.add(shape);
	}
	
	public void RemoveShape(Shape shape){
		shapes.remove(shape);
	}
	

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	

}
