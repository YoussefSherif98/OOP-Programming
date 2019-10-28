package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import java.util.HashMap;
public class Circle extends Shapes {
    
  Circle(Point p1, Point p2){
	  Map<String , Double> temp = new HashMap<>();
	  double diameter,x,y;
	  x = Math.abs(p1.getX() - p2.getX());
	  y = Math.abs(p1.getY() - p2.getY());
	  
	  
	  diameter = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	  temp.put("Diameter", diameter);
	  setProperties(temp);
	  
	  int minX = (int)Math.min(p1.getX(), p2.getX());
	  int minY = (int)Math.min(p1.getY(), p2.getY());
	  Point p = new Point(minX+(int)(x/2)-(int)diameter/2 , minY + (int)(y/2) - (int)diameter/2);
	  
	  setPosition(p);
  }
    @Override
    	public void draw(Graphics canvas) {
    		canvas.setColor(this.getColor());
    		canvas.drawOval((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)Math.round(this.getProperties().get("Diameter")),(int)Math.round(this.getProperties().get("Diameter")));
 
    		canvas.setColor(this.getFillColor());
    		canvas.fillOval((int)this.getPosition().getX()+1, (int)this.getPosition().getY()+1, (int)Math.round(this.getProperties().get("Diameter"))-1,(int)Math.round(this.getProperties().get("Diameter"))-1);
    
    }
    
    public Object clone() throws CloneNotSupportedException {
    	// TODO Auto-generated method stub
    	return null;
    }
    
  
   

}