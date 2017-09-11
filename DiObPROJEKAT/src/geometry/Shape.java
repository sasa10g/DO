package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	protected boolean selected;
	protected Color lineColor = Color.BLACK;
	
	public Shape(){}
	
	public Shape(boolean selected, Color lineColor){
		this.selected = selected;
		this.lineColor = lineColor;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean contains(int x, int y);
	
	public abstract void selected(Graphics g);
	
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
