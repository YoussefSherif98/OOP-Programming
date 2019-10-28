package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public abstract class Shapes implements Shape {
    private Point p = new Point();
    public Map<String,Double> map ;
    private Color ExColor = Color.BLACK;
    private Color InColor = Color.WHITE;
   
	@Override
	public void setPosition(Point position) {
		this.p = position;

	}

	@Override
	public Point getPosition() {
		
		return p;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		this.map = properties;
	}

	@Override
	public Map<String, Double> getProperties() {
		
		return map;
	}

	@Override
	public void setColor(Color color) {
		this.ExColor = color;

	}

	@Override
	public Color getColor() {
		return ExColor;
		}
	

	@Override
	public void setFillColor(Color color) {
	this.InColor = color ;

	}

	@Override
	public Color getFillColor() {
		
		return InColor;
	}

	@Override
	public abstract void draw(Graphics canvas);
	
	@Override
	public abstract Object clone() throws CloneNotSupportedException; // create a deep clone of the shape

}