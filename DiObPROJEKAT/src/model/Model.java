package model;

import java.util.ArrayList;

import geometry.Shape;

public class Model {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Shape> selectedShapes = new ArrayList<Shape>(); 
	private int id = 0;
	
	public ArrayList<Shape> getSelectedShapes() {
		return selectedShapes;
	}

	
	// START SELEKCIJA


	public void setSelectedShapes(ArrayList<Shape> selectedShapes) {
		this.selectedShapes = selectedShapes;
	}
	
	
	public void addShapeToSelection(Shape shape){
		shape.setSelected(true);
		this.selectedShapes.add(shape);
	}
	
	public void removeShapeFromSelection(Shape shape){
		shape.setSelected(false);
		this.selectedShapes.remove(shape);
	}
	
	public void addListShapeToSelection(ArrayList<Shape> shapes){
		for(Shape shape: shapes){
			shape.setSelected(true);
			this.selectedShapes.add(shape);
		}
	}
	
	public void removeListShapeToSelection(ArrayList<Shape> shapes){
		for(Shape shape: shapes){
			shape.setSelected(false);
			this.selectedShapes.remove(shape);
		}
	}
	
	// END SELEKCIJA
	
	public void addShapeIndexOf(Shape shape){
		shapes.add(shape.getIndex(), shape);
		
	}
	
	public void addListShapeIndexOf(ArrayList<Shape> shapes){
		for(Shape shape: shapes){
			addShapeIndexOf(shape);
		}
		
	}
	
	public void settingId(Shape shape){
		if(shapes != null){
			for(Shape s: shapes){
				if(shape.getId() == s.getId() && !shape.equals(s)){
					shape.setId(id++);
					settingId(shape);
				}
			}
		}
		shape.setIndexed(true);	
	}
	
	
	public void addShape(Shape shape){
		shapes.add(shape);
		shape.setIndex(shapes.indexOf(shape));
		if(!shape.isIndexed()){
			settingId(shape);
		}
	}

	public Model(){}
	
	public void AddShape(Shape shape){
		shapes.add(shape);
	}
	
	public void RemoveShape(Shape shape){
		shapes.remove(shape);
	}
	
	public void removeShape(Shape shape){
		shapes.remove(shape);
	}
	

	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
}
