package cmd;

import geometry.Shape;
import model.Model;

public class AddCommand implements Command {

	private Model model;
	private Shape shape;
	
	public AddCommand(Model model, Shape shape){
		this.model = model;
		this.shape = shape;
	}
	
	public AddCommand(){
		//konstruktor
	}
	
	
	@Override
	public void execute() {
		model.AddShape(shape);
		
	}

	@Override
	public void unExecute() {
		model.RemoveShape(shape);
		
	}

}
