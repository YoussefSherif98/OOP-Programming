package eg.edu.alexu.csd.oop.draw;


import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Square extends Shapes {

	public Square(Point P1, Point P2) {
		Map<String,Double> temp = new HashMap<String,Double>();
		Double l1,l2;
		l1 = Math.abs(P1.getX()-P2.getX());
		l2 = Math.abs(P1.getY()-P2.getY());
		
		temp.put("sideLength", Math.min(l1, l2));
		setProperties(temp);
		
		int x,y;
		if(P1.getX()<P2.getX())
			x = (int)P1.getX();
		else
			x = (int)(P1.getX() - this.getProperties().get("sideLength"));
		if(P1.getY()<P2.getY())
			y = (int)P1.getY();
		else
			y = (int)(P1.getY()- this.getProperties().get("sideLength"));
		
		Point p = new Point(x,y);
		setPosition(p);
		
	}
	public Square() {
		super();
	}
	@Override
	public void draw(Graphics canvas) {
		
		double sideLength = this.getProperties().get("sideLength");
		
		canvas.setColor(this.getFillColor());
		canvas.fillRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int) sideLength, (int) sideLength);
		
		canvas.setColor(this.getColor());
		canvas.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int) sideLength, (int) sideLength);
		
	}
	public boolean contain (Point p) {
		if ((p.getX() >= this.getPosition().getX()) && (p.getY() >= this.getPosition().getY()) && (p.getX() <= (this.getPosition().getX() + this.getProperties().get("sideLength"))) && (p.getY() <= (this.getPosition().getY() + this.getProperties().get("sideLength")))) {
		 return true;	
		}
		else return false;
	} 

	@Override
	public Object clone() throws CloneNotSupportedException {
		Shape s = new Square();
		s.setColor(this.getColor());
		s.setFillColor(this.getFillColor());
		s.setPosition(this.getPosition());
		s.setProperties(this.getProperties());
		return s;
	}
	@Override
	public Shape move(Point p) throws CloneNotSupportedException {
		double halfSideLength = this.getProperties().get("sideLength")/2;
		Point newPosition = new Point((int)(p.getX()-halfSideLength) , (int)(p.getY()-halfSideLength) );
		
		Shape newShape = (Shape)this.clone();
		newShape.setPosition(newPosition);
		return newShape;
		
	}
	@Override
	public Shape resize(Map<String, Double> newProperties) throws CloneNotSupportedException {
		Shape newShape = (Shape) this.clone();
		newShape.setProperties(newProperties);
		return newShape;
	}

	
}