package ctrl;

import gui.DrawingFrame;
import gui.View;
import model.Model;

public class Controller {

	private Model model;
	private View view;
	private DrawingFrame frame;

	public Controller(){
		
	}
	
	public void drawShapes(int x, int y){
		if(frame.getTglbtnSelection().isSelected()){
		}
		
		else if(frame.getTglbtnPoint().isSelected()){
		}
		
		else if(frame.getTglbtnLine().isSelected()){
		}
		
		else if(frame.getTglbtnCircle().isSelected()){
		}
		
		else if(frame.getTglbtnSquare().isSelected()){
		}
		
		else if(frame.getTglbtnRectangle().isSelected()){
		}
		
		else if(frame.getTglbtnHexagon().isSelected()){
		}
		
		else if(frame.getTglbtnSmile().isSelected()){
		}
	
	}
	
	
	//public void doCommand(Command c){
		
	//}
	
	public void undo(){
		
	}
	
	
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
		if(view != null){
			this.view.setModel(model);
		}
	}
	public View getView() {
		return view;
	}
	public void setView(View view) {
		this.view = view;
		view.setController(this);
	}
	
	
	public DrawingFrame getFrame() {
		return frame;
	}

	public void setFrame(DrawingFrame frame) {
		this.frame = frame;
	}
	
}
