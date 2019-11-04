package eg.edu.alexu.csd.oop.draw;


import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends Shapes {

	public Rectangle(Point P1, Point P2)
	{
		
		Map<String,Double> temp = new HashMap<String,Double>();
		Double l1,l2;
		l1 = Math.abs(P1.getX()-P2.getX());
		l2 = Math.abs(P1.getY()-P2.getY());
		temp.put("length", l1);
		temp.put("width", l2);
		
		setProperties(temp);
		
		int x,y;
		x = Math.min((int)P1.getX(),(int) P2.getX());
		y = Math.min((int)P1.getY(),(int) P2.getY());
		
		Point p = new Point(x,y);
		setPosition(p);
		
	}
	public Rectangle() {
		super();
	}

	@Override
	public void draw(Graphics canvas) {
		
		double length = this.getProperties().get("width");
		double width = this.getProperties().get("length");
		double x = this.getPosition().getX();
		double y = this.getPosition().getY();
		
		canvas.setColor(this.getFillColor());
		canvas.fillRect((int) x, (int) y,(int) width,(int) length);
		
		canvas.setColor(this.getColor());
		canvas.drawRect((int)x,(int) y,(int) width,(int) length);
		
	}
	public boolean contain (Point p) {
		double x1 = this.getPosition().getX();
		double y1 = this.getPosition().getY();
		double length = this.getProperties().get("length");
		double width = this.getProperties().get("width");
		
		double x = p.getX();
		double y = p.getY();
		
		if(x>=x1 && x<=(x1+length) && y>=y1 && y<=(y1+width))
			return true;
		return false;
	} 
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Shape s = new Rectangle();
		s.setColor(this.getColor());
		s.setFillColor(this.getFillColor());
		s.setPosition(this.getPosition());
		s.setProperties(this.getProperties());
		return s;
	}
	@Override
	public Shape move(Point p) throws CloneNotSupportedException {
		double halfLength = this.getProperties().get("length")/2;
		double halfWidth = this.getProperties().get("width")/2;
		Point newPosition = new Point((int)(p.getX()-halfLength) ,(int) (p.getY()-halfWidth) );
		
		Shape newShape = (Shape)this.clone();
		newShape.setPosition(newPosition);
		return newShape;
	}
	@Override
	public Shape resize(Map<String, Double> newProperties) throws CloneNotSupportedException {
		Shape newShape = (Shape)this.clone();
		newShape.setProperties(newProperties);
		return newShape;
	}

	

}