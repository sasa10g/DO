package geometry;

import java.awt.Color;
import java.util.ArrayList;

public abstract class SurfaceShape extends Shape {

	protected Color fillColor = Color.WHITE;
	private ArrayList<Color> changeFillColorList = new ArrayList<Color>();
	

	public ArrayList<Color> getChangeFillColorList() {
		return changeFillColorList;
	}

	public void setChangeFillColorList(ArrayList<Color> changeFillColorList) {
		this.changeFillColorList = changeFillColorList;
	}

	public SurfaceShape(){}
	
	public SurfaceShape(boolean selected, Color lineColor, Color fillColor){
		super(selected, lineColor);
		this.fillColor = fillColor;
	}
	
	public abstract double getArea();
	
	public String fillColorToString(){
		return  "Fill Color >> " + "Red: "+ fillColor.getRed() + " Blue: " + fillColor.getBlue()
		+ " Green: "+ fillColor.getGreen();
	}
	
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

}
