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
	
	public void setSelected(boolean selected){
		hexagon.setSelected(selected);
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

	@Override
	public void selected(Graphics g) { //hexakog ima svoju metodu za slekeciju
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveFor(int x, int y) {
		hexagon.setX(hexagon.getX()+x);
		hexagon.setY(hexagon.getY()+y);
		
	}

	@Override
	public void moveOn(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);
		
	}
	
}
