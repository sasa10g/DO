package cmd;

import java.util.ArrayList;

import dialog.DlgMove;
import geometry.Shape;
import model.Model;

public class CmdMode implements Command{
	
	private Model model;
	private ArrayList<Shape> shapesForModification;
	private DlgMove dialog;
	
	public CmdMode(){
		
	}
	
	public CmdMode(Model model){
		this.model = model;
		shapesForModification = new ArrayList<>(model.getSelectedShapes());
		this.dialog = new DlgMove();
		//this.dialog.setShapes(shapesForModification);
		this.dialog.setVisible(true);
	}

	@Override
	public void execute() {
		if (dialog.getRdbtnMoveFor().isSelected()) {
			for (Shape shape:shapesForModification) {
				shape.moveFor(Integer.parseInt(dialog.getxMod()), Integer.parseInt(dialog.getyMod()));
			}
		}
		else{
			for (Shape shape:shapesForModification) {
				shape.moveOn(Integer.parseInt(dialog.getxMod()), Integer.parseInt(dialog.getyMod()));
			}
		}
		
	}

	@Override
	public void unExecute() {
		if (dialog.getRdbtnMoveFor().isSelected()) {
			for (Shape shape:shapesForModification) {
				shape.moveFor(-Integer.parseInt(dialog.getxMod()), -Integer.parseInt(dialog.getyMod()));
			}
		}else{
			for (Shape shape:shapesForModification) {
				shape.moveOn(shape.getMovedOnX(), shape.getMovedOnY());
			}
		}
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public ArrayList<Shape> getShapesForModification() {
		return shapesForModification;
	}

	public void setShapesForModification(ArrayList<Shape> shapesForModification) {
		this.shapesForModification = shapesForModification;
	}

	public DlgMove getDialog() {
		return dialog;
	}

	public void setDialog(DlgMove dialog) {
		this.dialog = dialog;
	}
	
	
	
	
	
}
