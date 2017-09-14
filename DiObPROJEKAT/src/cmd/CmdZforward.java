package cmd;

import java.util.ArrayList;

import geometry.Shape;
import model.Model;

public class CmdZforward implements Command {

	private Model model;
	private ArrayList<Shape> shapesForZOrder;
	
	public CmdZforward(){
	}
	
	public CmdZforward(Model model) {
		this.model = model;
		shapesForZOrder =  new ArrayList<Shape>(model.getSelectedShapes());
	}

	
	@Override
	public void execute() {
		if(model.getShapes().size() > 1){
			model.getShapes().removeAll(shapesForZOrder);
			for(Shape shape: shapesForZOrder){
				if(shape.getIndex() > 0){
					
					shape.setIndex(shape.getIndex()-1);
				}
			}
			model.addListShapeIndexOf(shapesForZOrder);
		}
	}

	@Override
	public void unExecute() {
		model.getShapes().removeAll(shapesForZOrder);
		for(Shape shape: shapesForZOrder){
			shape.setIndex(shape.getIndex()+1);
		}
		model.addListShapeIndexOf(shapesForZOrder);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public ArrayList<Shape> getShapesForZOrder() {
		return shapesForZOrder;
	}

	public void setShapesForZOrder(ArrayList<Shape> shapesForZOrder) {
		this.shapesForZOrder = shapesForZOrder;
	}
}
