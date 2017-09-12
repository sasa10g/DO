package strategy;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import geometry.Shape;
import model.Model;
import serialization.ShapeSerialization;

public class SerStrategy implements Strategy{

	private JFileChooser fileChooser;
	private File file;
	private Model model;
		
	public SerStrategy() {
		
	}
	
	public SerStrategy(Model model, JFileChooser fileChooser){
		this.model = model;
		this.fileChooser = fileChooser;
	}
	
	@Override
	public void save() {
		
		
		file=new File(fileChooser.getSelectedFile().toString());
		if(file.getAbsolutePath().toString().endsWith(".ser")) {  

		} else
			file=new File(fileChooser.getSelectedFile().toString()+".ser"); 

		if(file.exists()) {
			file.delete();
		}
					
		ShapeSerialization shapeSer = new ShapeSerialization();
		shapeSer.serialize(model.getShapes(), file.toString());
			
				
	}

	@Override
	public void load() {
		//deserializacija, cita sve oblike i dodaje ih
		model.getShapes().clear();
		ShapeSerialization shapeDeser = new ShapeSerialization();
		ArrayList<Shape> desserializedShapes = model.getShapes();
		
		shapeDeser.deserialilize(model.getShapes(), fileChooser.getSelectedFile().toString());
		desserializedShapes = shapeDeser.deserialilize(model.getShapes(), fileChooser.getSelectedFile().toString());
		
		for(Shape s: desserializedShapes){
			model.addShape(s);
		}
		
	      
		
	}

}
