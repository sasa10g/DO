package ctrl;

import java.awt.Color;
import java.util.ArrayList;

import cmd.AddCommand;
import cmd.Command;
import dialog.DlgCircle;
import dialog.DlgRectangle;
import dialog.DlgSquare;
import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Square;
import gui.DrawingFrame;
import gui.View;
import model.Model;

public class Controller {

	private Model model;
	private View view;
	private DrawingFrame frame;
	
	private Point startPoint = null;
	
	
	private ArrayList<Command> commandsList = new ArrayList(); //lista komandi redoslijedom
	private ArrayList<Command> undoCommands = new ArrayList(); //lista unduo komandi
	

	public Controller(){
		
	}
	
	public void drawShapes(int x, int y){
		if(frame.getTglbtnSelection().isSelected()){
		}
		
		else if(frame.getTglbtnPoint().isSelected()){
			Point p = new Point(false, Color.BLACK, x, y);
			AddCommand aCmd = new AddCommand(model, p);
			doCommand(aCmd);
		}
		
		else if(frame.getTglbtnLine().isSelected()){
			if (startPoint == null) {
				startPoint = new Point(x, y);
			}
			else{
				Point p = new Point(x, y);
				Line l = new Line(false, Color.BLACK, startPoint, p);
				AddCommand aCmd = new AddCommand(model, l);
				doCommand(aCmd);
				startPoint = null;
			}
		}
		
		else if(frame.getTglbtnCircle().isSelected()){
			DlgCircle dlgCircle = new DlgCircle(); //dialog
			dlgCircle.setVisible(true);
			if(dlgCircle.getRadius() != null){
				Point p = new Point(false, Color.BLACK, x, y);
				int radius = Integer.parseInt(dlgCircle.getRadius().toString());
				
				Circle c = new Circle(false, Color.BLACK, Color.WHITE, p, radius);
				AddCommand aCmd = new AddCommand(model, c);
				doCommand(aCmd);
			}
		}
		
		else if(frame.getTglbtnSquare().isSelected()){
			DlgSquare dlgSquare = new DlgSquare(); //dialog
			dlgSquare.setVisible(true);
			if(dlgSquare.getSide() != null){
				Point p = new Point(false, Color.BLACK, x, y);
				int height = Integer.parseInt(dlgSquare.getSide().toString());
				
				Square s = new Square(false, Color.BLACK, Color.WHITE, p, height);
				AddCommand aCmd = new AddCommand(model, s);
				doCommand(aCmd);
			}
		}
		
		else if(frame.getTglbtnRectangle().isSelected()){
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setVisible(true);
			
			if(dlgRectangle.getSide()!= null || dlgRectangle.getHeightr()!= null){
				Point p = new Point(false, Color.BLACK, x, y);
				int side = Integer.parseInt(dlgRectangle.getSide());
				int heightr = Integer.parseInt(dlgRectangle.getHeightr());
				Rectangle r = new Rectangle(false, Color.BLACK, Color.WHITE, p, side, heightr);
				AddCommand aCmd = new AddCommand(model, r);
				doCommand(aCmd);
			
			}
		}
	
	}
	
	
	public void doCommand(Command c){
		commandsList.add(c);
		c.execute();
		view.repaint();
	}
	
	public void undo(){
		Command c = commandsList.get(commandsList.size()-1);
		commandsList.remove(c);
		undoCommands.add(c);
		c.unExecute();
		view.repaint(); //ispis poslije izvrsavanja medota
	}
	
	public void redo(){
		Command c = undoCommands.get(undoCommands.size()-1);
		undoCommands.remove(c);
		commandsList.add(c);
		c.execute();
		view.repaint();
	}
	
	
	
	// START GETTERS & SETTERS
	
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
	
	// END GETTERS & SETTERS
	
}
