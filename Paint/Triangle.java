package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;
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
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
