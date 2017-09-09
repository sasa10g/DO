package geometry;

import java.awt.Color;

public abstract class SurfaceShape extends Shape {

	protected Color fillColor = Color.CYAN;
	
	

	public SurfaceShape(){}
	
	public SurfaceShape(boolean selected, Color lineColor, Color fillColor){
		super(selected, lineColor);
		this.fillColor = fillColor;
	}
	
	public abstract double getArea();
	
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

}
