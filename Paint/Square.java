package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Square extends Shapes{
	
	public Square(Point P1, Point P2) {
		Map<String,Double> temp = new HashMap<String,Double>();
		Double l1,l2;
		l1 = Math.abs(P1.getX()-P2.getX());
		l2 = Math.abs(P1.getY()-P2.getY());
		
		temp.put("sideLength", Math.min(l1, l2));
		setProperties(temp);
		
		int x,y;
		x = Math.min((int)P1.getX(),(int) P2.getX());
		y = Math.min((int)P1.getY(),(int) P2.getY());
		
		Point p = new Point(x,y);
		setPosition(p);
		
	}
	
	@Override
	public void draw(Graphics canvas) {
		canvas.setColor(this.getColor());
		double sideLength = this.getProperties().get("sideLength");
		canvas.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int) sideLength, (int) sideLength);
		
		canvas.setColor(this.getFillColor());
		canvas.fillRect((int)this.getPosition().getX()+1, (int)this.getPosition().getY()+1, (int) sideLength-1, (int) sideLength-1);

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
