package ctrl;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import cmd.AddCommand;
import cmd.CmdChangeColor;
import cmd.CmdDelete;
import cmd.CmdMode;
import cmd.CmdZbackward;
import cmd.CmdZforward;
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
import geometry.Shape;
import geometry.Square;
import gui.DrawingFrame;
import gui.View;
import model.Model;
import strategy.ContextStrategy;
import strategy.SerStrategy;

public class Controller {

	private Model model;
	private View view;
	private DrawingFrame frame;
	
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter serFilter = new FileNameExtensionFilter("Serializable file", "ser");
	private int onClick;
	
	private Point startPoint, endPoint;
	
	public Controller(){
		fileChooser.addChoosableFileFilter((javax.swing.filechooser.FileFilter) serFilter);
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	private ArrayList<Command> commandsList = new ArrayList(); //lista komandi redoslijedom
	private ArrayList<Command> undoCommands = new ArrayList(); //lista unduo komandi
	

	
	
	public void drawShapes(int x, int y){
		
		if(frame.getTglbtnSelection().isSelected()){
			
			for(Shape shape: model.getShapes()){
				if(shape.contains(x, y) ){// if clicked on shape area
					if(!view.isCtrlPressed()){//if ctrl is pressed

						selectedShape(shape);// adding to selected shapes list

					}
					else{
						if(shape.isSelected()){// if ctrl is pressed and shape is selected

							model.removeShapeFromSelection(shape);// removing from selected shapes list
						}
						else{// if ctrl is pressed and shape is not selected

							model.addShapeToSelection(shape);// adding to  selectd shapes list
						}
					}

				}

				else if(!view.isCtrlPressed()){// if not clicked on shape area and ctrl is not pressed

					model.removeShapeFromSelection(shape);// removing from selected shapes list
				}				
			}
			view.repaint();
			
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
	
	public void keyPressed(int x, int y, int modifiers){// check if ctrl key is pressed

		if((modifiers & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK){
			view.setCtrlPressed(true);
		}
		else
			view.setCtrlPressed(false);

	}
	
	
	public Shape selectedShape(Shape shape){// allows selection only one shape
		ArrayList<Shape> localShapes = new ArrayList<>();
		for(Shape s: model.getSelectedShapes()){
			if(s.isSelected()){
				localShapes.add(s);
			}
			
		}
		model.removeListShapeToSelection(localShapes);
		model.addShapeToSelection(shape);
		return shape;
	}
	
	public void delete() {
		int delete = JOptionPane.showConfirmDialog(null,  "Are you sure?", "Delete",
				JOptionPane.YES_NO_OPTION); //shows confirm dialog
		if (delete == JOptionPane.YES_OPTION){
			CmdDelete cmdDelete = new CmdDelete(model);
			doCommand(cmdDelete);
			
		}
	}
	
	
	public void moveShape(){// enables shapes modification

		CmdMode cmdMove = new CmdMode(model);// initializing command
		if(cmdMove.getDialog().isSuccess()){//if all input is valid: do command
			doCommand(cmdMove);
			view.repaint();
		}		

	}
	
	
	public void changeShapeColor(){	// enables shapes to change color
		CmdChangeColor cmdChangeColor = new CmdChangeColor(model);// initializing command					
		if(cmdChangeColor.getDialog().isSucssess()){// if all input is valid
			doCommand(cmdChangeColor);

		}

	}
	
	
	public void zBackward(){// moving shape backward z axis
		CmdZbackward cmdZbackward = new CmdZbackward(model);// initializing command			
		doCommand(cmdZbackward);
	}

	public void zForward(){ // moving shape forward x axis
		CmdZforward cmdZbackward = new CmdZforward(model);// initalizing command
		doCommand(cmdZbackward);
	}
	
	
	public void enableBtnsZord(){

		if(model.getSelectedShapes().size() == 1 && model.getShapes().size() > 1){
			//if only one shape is selected and if there are at least two shapes drown


			if(model.getShapes().get(0).isSelected()){// if first drawned shape is selected
				frame.getBtnZforward().setEnabled(false);// disable button z-forward
			}
			else{
				frame.getBtnZforward().setEnabled(true);// enable button z-forward
			}
			if(model.getShapes().get(model.getShapes().size()-1).isSelected()){
				//if last drawned shape is selected
				frame.getBtnZbackward().setEnabled(false);// disable button z-backward
			}
			else{
				frame.getBtnZbackward().setEnabled(true);// enable button z-backward
			}

		}
		else{
			frame.getBtnZforward().setEnabled(false);// disable z-forward button
			frame.getBtnZbackward().setEnabled(false);// disable z-backward button
		}
	}
	
	
	
	public void save(){// save drawing

		ContextStrategy context = new ContextStrategy();// initializing strategy

		fileChooser.setAcceptAllFileFilterUsed(false);// can't save as all file
		onClick=fileChooser.showSaveDialog(frame.getPnlDrawing());// show dialog
		if(onClick==JFileChooser.APPROVE_OPTION) {// if clicked save
			if(fileChooser.getFileFilter().equals(serFilter)){

				context.setStrategy(new SerStrategy(model, fileChooser));
				context.saveContext();// save as serialization
			}
		}
	}

	public void load(){// open file

		ContextStrategy context = new ContextStrategy();
		fileChooser.setFileFilter(fileChooser.getAcceptAllFileFilter());
		// show all types of file

		onClick=fileChooser.showOpenDialog(frame.getPnlDrawing());// open file dialog
		if(onClick==JFileChooser.APPROVE_OPTION) {// if clicekd yes

			if(fileChooser.getSelectedFile()!= null){// if file is selecred
				if(fileChooser.getSelectedFile().getAbsolutePath().toString().endsWith(".ser")) {  
					//if type of file is serialization
					
					context.setStrategy(new SerStrategy(model, fileChooser));
					context.LoadContext();// open serializable file


				}
				
				
			}
		}


	}
	
	
	public void enableModificationBtns(){// enables buttons
		if(model.getSelectedShapes().size() > 0){// if there are selected shapes
			frame.getBtnMode().setEnabled(true);// enable modification button
			frame.getBtnChangeColor().setEnabled(true);// enable button for change color
			frame.getBtnDelete().setEnabled(true);// enable delete button
			frame.getBtnLineColor().setEnabled(false);
			frame.getBtnFillColor().setEnabled(false);
		}
		else{
			frame.getBtnMode().setEnabled(false);// disable modification button
			frame.getBtnChangeColor().setEnabled(false);// disable button for change color
			frame.getBtnDelete().setEnabled(false);// disable delete button
			frame.getBtnLineColor().setEnabled(true);
			frame.getBtnFillColor().setEnabled(true);
		}

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
