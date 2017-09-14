package app;

import ctrl.Controller;
import gui.DrawingFrame;
import gui.View;
import model.Model;

public class DrawingAplication {

	public static void main(String[] args) {
		DrawingFrame frame = new DrawingFrame();
		
		View view = frame.getPnlDrawing();
		
		Model model = new Model();
		
		Controller controller = new Controller();
		controller.setView(view);
		controller.setFrame(frame);
		frame.setController(controller); //controller zbog metode
		
		controller.setModel(model);
		frame.setVisible(true);	
	}
}
