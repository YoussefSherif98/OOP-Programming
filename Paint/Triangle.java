package eg.edu.alexu.csd.oop.draw;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends Shapes {
	public Triangle(Point P1, Point P2)
	{
		
		Map<String,Double> temp = new HashMap<String,Double>();
		
		Double x1=P1.getX(), x2=P2.getX(), y1=P1.getY(), y2=P2.getY();
		temp.put("x1", x1);
		temp.put("y1", y1);
		temp.put("x2", x2);
		temp.put("y2", y2);
		temp.put("x3", x2);
		temp.put("y3", y1);
		
		setProperties(temp);
	}
	public Triangle() {
		super();
	}
	@Override
	public void draw(Graphics canvas) {
		
		double x1 = this.getProperties().get("x1");
		double x2 = this.getProperties().get("x2");
		double x3 = this.getProperties().get("x3");
		double y1 = this.getProperties().get("y1");
		double y2 = this.getProperties().get("y2");
		double y3 = this.getProperties().get("y3");
		
		int[] Xs = {(int) x1,(int) x2,(int) x3};
		int[] Ys = {(int) y1, (int) y2, (int) y3};
		
		Polygon p = new Polygon(Xs,Ys,3);
		
		canvas.setColor(this.getFillColor());
		canvas.fillPolygon(p);
		
		canvas.setColor(this.getColor());
		canvas.drawPolygon(p);

	}
	@Override
	public boolean contain(Point p) {
		double x1 = this.getProperties().get("x1");
		double x2 = this.getProperties().get("x2");
		double x3 = this.getProperties().get("x3");
		double y1 = this.getProperties().get("y1");
		double y2 = this.getProperties().get("y2");
		double y3 = this.getProperties().get("y3");
		
		double x = p.getX();
		double y = p.getY();

		double x1x = x-x1;
	    double y1y = y-y1;

	    boolean p1p = (x2-x1)*y1y-(y2-y1)*x1x > 0;

	    if((x3-x1)*y1y-(y3-y1)*y1y > 0 == p1p) return false;

	    if((x3-x2)*(y-y2)-(y3-y2)*(x-x2) > 0 != p1p) return false;

	    return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Shape s = new Triangle();
		s.setColor(this.getColor());
		s.setFillColor(this.getFillColor());
		s.setPosition(this.getPosition());
		s.setProperties(this.getProperties());
		return s;
	}
	@Override
	public Shape move(Point p) throws CloneNotSupportedException {
		double x1 = this.getProperties().get("x1");
		double x2 = this.getProperties().get("x2");
		double x3 = this.getProperties().get("x3");
		double y1 = this.getProperties().get("y1");
		double y2 = this.getProperties().get("y2");
		double y3 = this.getProperties().get("y3");
		
		double distX1 = x3-x1;
		double distY1 = y3-y1;
		double distX2 = x3-x2;
		double distY2 = y3-y2;
		
		Map<String,Double> newProperties = new HashMap<String,Double>();
		newProperties.put("x3", p.getX());
		newProperties.put("y3", p.getY());
		
		double newX3 = p.getX();
		double newY3 = p.getY();
		
		newProperties.put("x2", newX3-distX2);
		newProperties.put("y2", newY3-distY2);
		newProperties.put("x1", newX3-distX1);
		newProperties.put("y1", newY3-distY1);
		
		Shape newShape = (Shape)this.clone();
		newShape.setProperties(newProperties);
		return newShape;
	}
	@Override
	public Shape resize(Map<String, Double> newProperties) throws CloneNotSupportedException {
		
		double x1 = this.getProperties().get("x1");
		double x2 = this.getProperties().get("x2");
		double x3 = this.getProperties().get("x3");
		double y1 = this.getProperties().get("y1");
		double y2 = this.getProperties().get("y2");
		double y3 = this.getProperties().get("y3");
		
		double xLength = newProperties.get("xLength");
		double yLength = newProperties.get("yLength");
		
		if(x2>=x1 && y2>=y1)
		{
			x1 = x3 - xLength;
			y2 = y3 + yLength;
		}
		else if(x2>=x1 && y1>=y2)
		{
			x1 = x3 - xLength;
			y2 = y3 - yLength;
		}
		else if(x1>=x2 && y1>=y2)
		{
			x1 = x3 + xLength;
			y2 = y3 - yLength;
		}
		else
		{
			x1 = x3 + xLength;
			y2 = y3 + yLength;
		}
		
		newProperties.clear();
		
		newProperties.put("x1", x1);
		newProperties.put("x2", x2);
		newProperties.put("x3", x3);
		newProperties.put("y1", y1);
		newProperties.put("y2", y2);
		newProperties.put("y3", y3);

		Shape newShape = (Shape)this.clone();
		newShape.setProperties(newProperties);
		return newShape;
	}

	

}