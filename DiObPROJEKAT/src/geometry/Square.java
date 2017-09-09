package geometry;

import java.awt.Color;
import java.awt.Graphics;


public class Square extends SurfaceShape{

	protected Point topLeftPoint;
	protected int side;
	
	public Square(){}
	
	public Square(boolean selected, Color lineColor, Color fillColor, 
			Point topLeftPoint, int side){
		super(selected, lineColor, fillColor);
		this.topLeftPoint = topLeftPoint;
		this.side = side;
		
		
	}

	public double getArea() {
		return side * side;
	}

	
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.setColor(Color.BLUE);
		new Line(selected, fillColor, topLeftPoint, new Point(topLeftPoint.getX()+side, topLeftPoint.getY()));
		new Line(selected, fillColor, topLeftPoint, new Point(topLeftPoint.getX(), topLeftPoint.getY()+side));
		new Line(selected, fillColor, new Point(topLeftPoint.getX()+side, topLeftPoint.getY()), diagonal().getEndPoint());
		new Line(selected, fillColor, new Point(topLeftPoint.getX(), topLeftPoint.getY()+side), diagonal().getEndPoint());
		
		
	}
	
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillRect(topLeftPoint.getX(), topLeftPoint.getY(), side, side);
		g.setColor(lineColor);
		g.drawRect(topLeftPoint.getX(), topLeftPoint.getY(), side, side);
		if(selected)
			selected(g);

	}

	public boolean contains(int x, int y) {
		if(x <= topLeftPoint.getX()+side && x > topLeftPoint.getX() &&
				y <= topLeftPoint.getY()+side && y > topLeftPoint.getY())
		return true;
		else
			return false;
	}
	
	public Line diagonal(){
		return new Line(selected, fillColor, topLeftPoint, 
				new Point(topLeftPoint.getX()+side, topLeftPoint.getY()+side));
	}
	
	/*public String toString(){
		return "Top left point: "+ "("+topLeftPoint.getX()+","+topLeftPoint.getY()+") "+
				", Side: "+ Integer.toString(side)+ ", "+ lineColorToString() + ", " + fillColorToString();
	}*/

	public Point getTopLeftPoint() {
		return topLeftPoint;
	}

	public void setTopLeftPoint(Point topLeftPoint) {
		this.topLeftPoint = topLeftPoint;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	/*@Override
	public void moveOn(int x, int y) {
		// TODO Auto-generated method stub
		if(x > 0 && y > 0){
			movedOnX = this.topLeftPoint.getX();
			movedOnY = this.topLeftPoint.getY();
			
			topLeftPoint.moveOn(x, y);
		}
		else
			JOptionPane.showMessageDialog(null, "Invalid function", "Error",
					JOptionPane.ERROR_MESSAGE);

	}
*/
/*	@Override
	public void moveFor(int x, int y) {
		
			topLeftPoint.moveFor(x, y);
	
	}
*/
/*	@Override
	public String txtToString() {
		
		return topLeftPoint.getX()+","+topLeftPoint.getY()+","
				 +Integer.toString(side) +","+ lineColor.getRGB()+ "," + fillColor.getRGB();
	}*/

	

}