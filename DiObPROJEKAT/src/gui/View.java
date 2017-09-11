package gui;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import ctrl.Controller;
import geometry.Shape;
import model.Model;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JPanel {

	private Controller controller;
	private Model model;
	private boolean ctrlPressed;
	
	public View(){
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int m = e.getModifiers();
				controller.keyPressed(e.getX(), e.getY(), m);
				controller.drawShapes(e.getX(), e.getY());
			}
		});
	}

	
	public void paint(Graphics g){
		super.paint(g);
		if(model != null){ //problem sa pokretanjem gui
		Iterator<Shape> it = model.getShapes().iterator();
		while(it.hasNext()){
			it.next().draw(g);
		}
	}
}
	
	
	

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}


	public boolean isCtrlPressed() {
		return ctrlPressed;
	}


	public void setCtrlPressed(boolean ctrlPressed) {
		this.ctrlPressed = ctrlPressed;
	}
}
