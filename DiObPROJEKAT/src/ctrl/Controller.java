package ctrl;

import java.awt.Color;
import java.util.ArrayList;

import cmd.AddCommand;
import cmd.Command;
import composite.Mouth;
import composite.SmileyShape;
import dialog.DlgCircle;
import dialog.DlgHexagon;
import dialog.DlgRectangle;
import dialog.DlgSquare;
import geometry.Circle;
import geometry.HexagonAdapter;
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
			Point p = new Point(false, frame.getLineColor(), x, y);
			AddCommand aCmd = new AddCommand(model, p);
			doCommand(aCmd);
		}
		
		else if(frame.getTglbtnLine().isSelected()){
			if (startPoint == null) {
				startPoint = new Point(x, y);
			}
			else{
				Point p = new Point(x, y);
				Line l = new Line(false, frame.getLineColor(), startPoint, p);
				AddCommand aCmd = new AddCommand(model, l);
				doCommand(aCmd);
				startPoint = null;
			}
		}
		
		else if(frame.getTglbtnCircle().isSelected()){
			DlgCircle dlgCircle = new DlgCircle(); //dialog
			dlgCircle.setVisible(true);
			if(dlgCircle.getRadius() != null){
				Point p = new Point(false, frame.getLineColor(), x, y);
				int radius = Integer.parseInt(dlgCircle.getRadius().toString());
				
				Circle c = new Circle(false, frame.getLineColor(), frame.getFillColor(), p, radius);
				AddCommand aCmd = new AddCommand(model, c);
				doCommand(aCmd);
			}
		}
		
		else if(frame.getTglbtnSquare().isSelected()){
			DlgSquare dlgSquare = new DlgSquare(); //dialog
			dlgSquare.setVisible(true);
			if(dlgSquare.getSide() != null){
				Point p = new Point(false, frame.getLineColor(), x, y);
				int height = Integer.parseInt(dlgSquare.getSide().toString());
				
				Square s = new Square(false, frame.getLineColor(), frame.getFillColor(), p, height);
				AddCommand aCmd = new AddCommand(model, s);
				doCommand(aCmd);
			}
		}
		
		else if(frame.getTglbtnRectangle().isSelected()){
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setVisible(true);
			
			if(dlgRectangle.getSide()!= null || dlgRectangle.getHeightr()!= null){
				Point p = new Point(false, frame.getLineColor(), x, y);
				int side = Integer.parseInt(dlgRectangle.getSide());
				int heightr = Integer.parseInt(dlgRectangle.getHeightr());
				Rectangle r = new Rectangle(false, frame.getLineColor(), frame.getFillColor(), p, side, heightr);
				AddCommand aCmd = new AddCommand(model, r);
				doCommand(aCmd);
			
			}
		}
		
		else if(frame.getTglbtnHexagon().isSelected()){
			DlgHexagon dlgHexagon = new DlgHexagon(); //dialog
			dlgHexagon.setVisible(true);
			if(dlgHexagon.getRadius() != null){
				Point p = new Point(false, frame.getLineColor(), x, y);
				int radius = Integer.parseInt(dlgHexagon.getRadius().toString());
				
				HexagonAdapter h = new HexagonAdapter(false, frame.getLineColor(), frame.getFillColor(), p, radius);
				AddCommand aCmd = new AddCommand(model, h);
				doCommand(aCmd);
			}
		}
		else if(frame.getTglbtnSmile().isSelected()){
			DlgCircle dlgSmiley = new DlgCircle();//create dialog for input radius
			dlgSmiley.setVisible(true);// dialog must be visible
			if(dlgSmiley.getRadius() != null){// radius must not be null
				Point center = new Point(x, y);// initializing point
				int radius = Integer.parseInt(dlgSmiley.getRadius().toString());// get radius from dialog
				Circle head = new Circle(false, frame.getLineColor(), frame.getFillColor(), center, radius);// initializing head

				SmileyShape smiley = new SmileyShape();// initializing smiley

				initializigSmiley(smiley, head);


				AddCommand aCmd = new AddCommand(model, smiley);// initializing command
				doCommand(aCmd);

			}
		}
	}
	
	
	public void initializigSmiley(SmileyShape smiley, Circle head){
		smiley.add(head);
		int leftEyeX = ((Circle) smiley.getChildren().get(0)).getCenter().getX()
				-((Circle) smiley.getChildren().get(0)).getRadius()/2;
		// setting left eye X coordinates
		int leftEyeY = ((Circle) smiley.getChildren().get(0)).getCenter().getY()
				- ((Circle) smiley.getChildren().get(0)).getRadius()/2;
		// setting left eye Y coordinates
		Point leftEye = new Point(false, frame.getLineColor(),leftEyeX, leftEyeY); // initializing left eye

		int rightEyeX = ((Circle) smiley.getChildren().get(0)).getCenter().getX()
				+((Circle) smiley.getChildren().get(0)).getRadius()/2;
		// setting right eye X coordinates
		int rightEyeY = ((Circle) smiley.getChildren().get(0)).getCenter().getY()
				- ((Circle) smiley.getChildren().get(0)).getRadius()/2;
		// setting right eye Y coordinates

		Point rightEye = new Point(false, frame.getLineColor(),rightEyeX, rightEyeY); // initializing right eye

		double p = 0.7;

		int p1X = (int)(head.getCenter().getX() - head.getRadius() * p);// 
		int p1Y = head.getCenter().getY();

		int p2X = (int)(head.getCenter().getX()- head.getRadius() / 2);
		int p2Y = (int)(head.getCenter().getY() + head.getRadius() / 2);

		int p3X = (int)(head.getCenter().getX()- head.getRadius() / 2) + head.getRadius();
		int p3Y = (int)(head.getCenter().getY() + head.getRadius() / 2);

		int p4X = (int)(head.getCenter().getX() + head.getRadius() * p);
		int p4Y =  head.getCenter().getY();

		Point startP1 = new Point(p1X, p1Y);
		Point endP1StartP2 = new Point(p2X, p2Y);
		Point endP2StartP3 = new Point(p3X, p3Y);
		Point endP3 = new Point(p4X, p4Y);

		Line leftLine = new Line(false, frame.getLineColor(), startP1, endP1StartP2);// initializing left line of mouth
		Line middleLine = new Line(false, frame.getLineColor(),endP1StartP2, endP2StartP3);// initializing middle line of mouth
		Line rightLine = new Line(false, frame.getLineColor(),endP2StartP3, endP3);// initializing right line of mouth
		Mouth mouth = new Mouth(head);// initalizing mouth
		mouth.add(leftLine);
		mouth.add(middleLine);
		mouth.add(rightLine);

		smiley.add(leftEye);
		smiley.add(rightEye);
		smiley.add(mouth);

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
