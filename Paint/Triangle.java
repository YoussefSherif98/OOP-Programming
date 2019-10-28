package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends Shapes{
	
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
	
	@Override
	public void draw(Graphics canvas) {
		
		canvas.setColor(this.getColor());
		double x1 = this.getProperties().get("x1");
		double x2 = this.getProperties().get("x2");
		double x3 = this.getProperties().get("x3");
		double y1 = this.getProperties().get("y1");
		double y2 = this.getProperties().get("y2");
		double y3 = this.getProperties().get("y3");
		
		int[] Xs = {(int) x1,(int) x2,(int) x3};
		int[] Ys = {(int) y1, (int) y2, (int) y3};
		
		Polygon p = new Polygon(Xs,Ys,3);
		canvas.drawPolygon(p);
		
		canvas.setColor(this.getFillColor());
		canvas.fillPolygon(p);

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
