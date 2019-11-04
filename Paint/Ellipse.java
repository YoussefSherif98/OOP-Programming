package eg.edu.alexu.csd.oop.draw;

import java.util.Map;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
public class Ellipse extends Shapes {

	Ellipse(Point p1, Point p2 ){
		
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
	public Ellipse() {
		super();
	}
	@Override
	public void draw(Graphics canvas) {
		int x = (int)this.getPosition().getX();
		int y = (int)this.getPosition().getY();
		double width = this.getProperties().get("EllipseMajor");
		double length = this.getProperties().get("EllipseMinor");
		
		canvas.setColor(this.getFillColor());
		canvas.fillOval(x , y,(int)width,(int)length);
		
		canvas.setColor(this.getColor());
		canvas.drawOval(x , y ,(int)width,(int)length);
		
	}
	@Override
	public boolean contain(Point p) {
		
		Point center = this.getCenter();
		double h =  center.getX();
		double k =  center.getY();
		
		double x = p.getX();
		double y = p.getY();
		
		double rx = this.getProperties().get("EllipseMajor")/2;
		double ry = this.getProperties().get("EllipseMinor")/2;
		
		double value = Math.pow((x-h)/rx, 2) + Math.pow((y-k)/ry, 2);
		
		if(value<=1)
			return true;
		return false;
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Shape s = new Ellipse();
		s.setColor(this.getColor());
		s.setFillColor(this.getFillColor());
		s.setPosition(this.getPosition());
		s.setProperties(this.getProperties());
		return s;
	}
	
	private Point getCenter()
	{
		int minX = (int) this.getPosition().getX();
		int minY = (int) this.getPosition().getY();
		
		double major = this.getProperties().get("EllipseMajor");
		double minor = this.getProperties().get("EllipseMinor");
		
		Point Center = new Point(minX +(int)major/2, minY + (int)minor/2);
		
		return Center;
	}
	@Override
	public Shape move(Point p) throws CloneNotSupportedException {
		
		double radX = this.getProperties().get("EllipseMajor")/2;
		double radY = this.getProperties().get("EllipseMinor")/2;
		
		Point newPosition = new Point((int)(p.getX()-radX) , (int)(p.getY()-radY) );
		Shape newShape = (Shape)this.clone();
		newShape.setPosition(newPosition);
		
		return newShape;
		
	}
	@Override
	public Shape resize(Map<String, Double> newProperties) throws CloneNotSupportedException {
		Shape newShape = (Shape) this.clone();
		newShape.setProperties(newProperties);
		
		double radX = newShape.getProperties().get("EllipseMajor")/2;
		double radY = newShape.getProperties().get("EllipseMinor")/2;
		
		Point Center = getCenter();
		double x = Center.getX();
		double y = Center.getY();
		
		Point newPosition = new Point((int)(x-radX),(int)(y-radY));
		
		newShape.setPosition(newPosition);
		
		return newShape;
	}

}