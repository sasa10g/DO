package geometry;

import java.awt.Color;
import java.awt.Graphics;

import ris.Hexagon;

public class HexagonAdapter extends SurfaceShape{
	private Hexagon hexagon;
	

	public HexagonAdapter(){
		
	}
	
	public HexagonAdapter(boolean selected, Color lineColor, Color fillColor, Point p, int radius){
		hexagon = new Hexagon(p.getX(), p.getY(), radius);
		hexagon.setBorderColor(lineColor);
		hexagon.setAreaColor(fillColor);
		hexagon.setSelected(selected);
	}
	
	
	@Override
	public double getArea() { //povrsina, nije potrebno
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}
	
	
	public int getX() {
		return hexagon.getX();
	}
	
	public void setX(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public int getY() {
		return hexagon.getX();
	}
	
	public void setY(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
}
