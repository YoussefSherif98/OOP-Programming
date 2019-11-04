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
	
	FreeDraw(){
		super();
		}
	
	public void draw(Graphics canvas) {
		canvas.setColor(super.getColor());
		canvas.fillOval((int)super.getPosition().getX(), (int)super.getPosition().getY(), (int)Math.round(super.getProperties().get("Diameter")),(int)Math.round(super.getProperties().get("Diameter")));


	}
	@Override
	public boolean contain(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Shape s = new FreeDraw();
		s.setColor(this.getColor());
		s.setFillColor(this.getFillColor());
		s.setPosition(this.getPosition());
		s.setProperties(this.getProperties());
		return s;
	}
	@Override
	public Shape move(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape resize(Map<String, Double> newProperties) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}