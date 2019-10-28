package eg.edu.alexu.csd.oop.draw;

import java.util.Map;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
public class Ellipse extends Shapes {

	Ellipse(Point p1, Point p2){
		double x,y; 
		x = Math.abs(p1.getX() - p2.getX());
		y = Math.abs(p1.getY() - p2.getY());
		
		
		 Map<String , Double> temp = new HashMap<>();
		 temp.put("EllipseMajor", x);
		 temp.put("EllipseMinor", y);
		 setProperties(temp);
		 
		 int minX = (int)Math.min(p1.getX(), p2.getX());
		 int minY = (int)Math.min(p1.getY(), p2.getY());	
		 Point p = new Point(minX,minY);
		 setPosition(p);
	}
	@Override
	public void draw(Graphics canvas) {
		int x = (int)this.getPosition().getX();
		int y = (int)this.getPosition().getY();
		double width = this.getProperties().get("EllipseMajor");
		double length = this.getProperties().get("EllipseMinor");
		
		canvas.setColor(this.getColor());
		canvas.drawOval(x , y ,(int)width,(int)length);

		canvas.setColor(this.getFillColor());
		canvas.fillOval(x+1 , y+1,(int)width-1,(int)length-1);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}