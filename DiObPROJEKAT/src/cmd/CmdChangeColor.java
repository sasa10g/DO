package cmd;

import java.util.ArrayList;

import dialog.DlgChangeColor;
import geometry.Shape;
import geometry.SurfaceShape;
import model.Model;

public class CmdChangeColor implements Command{

	private Model model;
	private ArrayList<Shape> shapesForChangeColor;
	private DlgChangeColor dialog;
	private String command = "";
	
	
	public CmdChangeColor(){
		
	}
	
	public CmdChangeColor(Model model){
		this.model = model;
		this.shapesForChangeColor = new ArrayList<Shape>(model.getSelectedShapes());
		this.dialog = new DlgChangeColor();
		for(Shape shape: shapesForChangeColor){
			if(shape instanceof SurfaceShape){
				dialog.getBtnFillColor().setEnabled(true);
				break;
			}
		}
		dialog.setVisible(true);// setting visible dialog
	}
	
	


	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
for(Shape shape: shapesForChangeColor){
			
			if(dialog.getLineColor() == null){
				dialog.setLineColor(shape.getLineColor());
				
			}
			
			if(dialog.getLineColor() != shape.getLineColor()){
				
				shape.getChangedLineColorList().add(shape.getLineColor());			
				shape.setLineColor(dialog.getLineColor());
				shape.setSelected(false);
			}
			else{
				
				shape.getChangedLineColorList().add(shape.getLineColor());
			}
			
			
			
			if(shape instanceof SurfaceShape){
				if(dialog.getFillColor() == null){
					dialog.setFillColor(((SurfaceShape) shape).getFillColor());
				}				
				
				if(dialog.getFillColor() != ((SurfaceShape) shape).getFillColor()){
					((SurfaceShape) shape).getChangeFillColorList().add(((SurfaceShape) shape).getFillColor());
					((SurfaceShape) shape).setFillColor(dialog.getFillColor());
				}
				else{
					((SurfaceShape) shape).getChangeFillColorList().add(((SurfaceShape) shape).getFillColor());
				}
				
				
				
			}
		
		}
		model.getSelectedShapes().clear();
	}


	@Override
	public void unExecute() {
		for(Shape shape: shapesForChangeColor){
			shape.setLineColor(shape.getChangedLineColorList().get(shape.getChangedLineColorList().size()-1));
			shape.getChangedLineColorList().remove(shape.getChangedLineColorList().size()-1);
			
			
			if(shape instanceof SurfaceShape){
				((SurfaceShape) shape).setFillColor(((SurfaceShape) shape).getChangeFillColorList()
						.get(((SurfaceShape) shape).getChangeFillColorList().size()-1));
				((SurfaceShape) shape).getChangeFillColorList().remove(((SurfaceShape) shape).getChangeFillColorList().size()-1);
				
			}
			
		}
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public ArrayList<Shape> getShapesForChangeColor() {
		return shapesForChangeColor;
	}

	public void setShapesForChangeColor(ArrayList<Shape> shapesForChangeColor) {
		this.shapesForChangeColor = shapesForChangeColor;
	}

	public DlgChangeColor getDialog() {
		return dialog;
	}

	public void setDialog(DlgChangeColor dialog) {
		this.dialog = dialog;
	}
	
	
}
