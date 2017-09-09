package app;

import java.awt.Color;


import ctrl.Controller;
import geometry.Circle;
import geometry.Point;
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
		
		controller.setModel(model);
		
		frame.setVisible(true);
		

	}

}
