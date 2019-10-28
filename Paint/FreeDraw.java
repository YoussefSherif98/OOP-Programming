package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class FreeDraw extends Shapes {

	FreeDraw(int size,Point p){
		Map<String , Double> temp = new HashMap<>();
		  temp.put("Diameter", (double)size);
		  setProperties(temp);
		  setPosition(p);
	}
	public void draw(Graphics canvas) {
		canvas.setColor(super.getColor());
		canvas.fillOval((int)super.getPosition().getX(), (int)super.getPosition().getY(), (int)Math.round(super.getProperties().get("Diameter")),(int)Math.round(super.getProperties().get("Diameter")));


	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}