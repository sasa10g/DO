package cmd;

import java.util.ArrayList;

import geometry.Shape;
import model.Model;

public class CmdDelete implements Command {
	
	private Model model;
	private ArrayList<Shape> shapesForDelete;
	
	public CmdDelete() {
	}
	
	public CmdDelete(Model model){
		this.model = model;
		shapesForDelete = new ArrayList<>(model.getSelectedShapes());
	}

	@Override
	public void execute() {
		model.getShapes().removeAll(shapesForDelete);
	}

	@Override
	public void unExecute() {
		model.getShapes().addAll(shapesForDelete);
	}
}
