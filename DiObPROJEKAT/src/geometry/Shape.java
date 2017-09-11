package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Shape {
	
	protected boolean selected;
	protected Color lineColor = Color.BLACK;
	protected int movedOnX;
	protected int movedOnY;
	private boolean indexed;
	private int index;
	private int id;
	private ArrayList<Color> changedLineColorList = new ArrayList<Color>();
	
	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovedOnX() {
		return movedOnX;
	}

	public ArrayList<Color> getChangedLineColorList() {
		return changedLineColorList;
	}

	public void setChangedLineColorList(ArrayList<Color> changedLineColorList) {
		this.changedLineColorList = changedLineColorList;
	}

	public void setMovedOnX(int movedOnX) {
		this.movedOnX = movedOnX;
	}

	public int getMovedOnY() {
		return movedOnY;
	}

	public void setMovedOnY(int movedOnY) {
		this.movedOnY = movedOnY;
	}

	public Shape(){
		
	}
	
	public Shape(boolean selected, Color lineColor){
		this.selected = selected;
		this.lineColor = lineColor;
	}
	
	public String lineColorToString(){
		return  "Line Color >> " + "Red: "+ lineColor.getRed() + " Blue: " + lineColor.getBlue()
		+ " Green: "+ lineColor.getGreen();
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean contains(int x, int y);
	
	public abstract void selected(Graphics g);
	
	public abstract void moveFor(int x, int y);
	
	public abstract void moveOn(int x, int y);
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
}
