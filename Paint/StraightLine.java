package eg.edu.alexu.csd.oop.draw;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
public class StraightLine extends Shapes {
	   StraightLine(Point p1, Point p2){
		   
	    	Map<String, Double> temp = new HashMap<>();
	    	temp.put("X1", p1.getX());
	    	temp.put("X2", p2.getX());
	    	temp.put("Y1", p1.getY());
	    	temp.put("Y2", p2.getY());
	    	double length = getLength(p1.getX(),p1.getY(),p2.getX(),p2.getY());
	    	temp.put("length", length);
	    	setProperties(temp);
	    	setPosition(p1);
	    }
	  
	public StraightLine() {
			super();
		}
		@Override
		public void draw(Graphics canvas) {
			
			canvas.setColor(this.getColor());
			canvas.drawLine((int)Math.round(this.getProperties().get("X1")),(int)Math.round(this.getProperties().get("Y1")),(int)Math.round(this.getProperties().get("X2")),(int)Math.round(this.getProperties().get("Y2")));
			
		}
		@Override
		public boolean contain(Point p) {
			double x1 = this.getProperties().get("X1");
			double y1 = this.getProperties().get("Y1");
			double x2 = this.getProperties().get("X2");
			double y2 = this.getProperties().get("Y2");
			
			double x = p.getX();
			double y = p.getY();
			
			double dist1 = Math.sqrt( Math.pow(x-x1, 2) + Math.pow(y-y1, 2) );
			double dist2 = Math.sqrt( Math.pow(x-x2, 2) + Math.pow(y-y2, 2) );
			double dist = Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) );
			
			return (Math.abs(dist1+dist2-dist) <= 0.2 );
			

		}
		public Object clone() throws CloneNotSupportedException {
			Shape s = new StraightLine();
			s.setColor(this.getColor());
			s.setFillColor(this.getFillColor());
			s.setPosition(this.getPosition());
			s.setProperties(this.getProperties());
			return s;
		}
		@Override
		public Shape move(Point p) throws CloneNotSupportedException {
			Point center = getCenter();
			double distX = center.getX()-p.getX();
			double distY = center.getY()-p.getY();
			
			double x1 = this.getProperties().get("X1");
			double y1 = this.getProperties().get("Y1");
			double x2 = this.getProperties().get("X2");
			double y2 = this.getProperties().get("Y2");
			
			Map<String,Double> newProperties = new HashMap<String,Double>();
			newProperties.put("X1", x1-distX);
			newProperties.put("Y1", y1-distY);
			newProperties.put("X2", x2-distX);
			newProperties.put("Y2", y2-distY);
			newProperties.put("length", this.getProperties().get("length"));
			
			Shape newShape = (Shape)this.clone();
			newShape.setProperties(newProperties);
			return newShape;
			
		}
		
		private Point getCenter()
		{
			double x1 = this.getProperties().get("X1");
			double x2 = this.getProperties().get("X2");
			double y1 = this.getProperties().get("Y1");
			double y2 = this.getProperties().get("Y2");
			
			int newX = (int)(x1+x2)/2;
			int newY = (int)(y1+y2)/2;
			Point Center = new Point(newX,newY);
			return Center;

			
		}
		@Override
		public Shape resize(Map<String, Double> newProperties) throws CloneNotSupportedException {
			double newLength = newProperties.get("length");
			
			double x1 = this.getProperties().get("X1");
			double x2 = this.getProperties().get("X2");
			double y1 = this.getProperties().get("Y1");
			double y2 = this.getProperties().get("Y2");
				
			double theta = Math.atan((Math.abs(y2-y1))/(Math.abs(x2-x1)));
		
			if(x2>=x1 && y2>=y1)
			{
				x2= x1 + newLength*Math.cos(theta);
				y2= y1 + newLength*Math.sin(theta);
			}
			else if(x2>=x1 && y1>=y2)
			{
				x2 = x1 + newLength*Math.cos(theta);
				y2 = y1 - newLength*Math.sin(theta);
			}
			else if(x1>=x2 && y1>=y2)
			{
				x1 = x2 + newLength*Math.cos(theta);
				y1 = y2 + newLength*Math.sin(theta);
			}
			else
			{
				x1 = x2 + newLength*Math.cos(theta);
				y1 = y2 - newLength*Math.sin(theta);
			}
			newProperties.put("X1", x1);
			newProperties.put("Y1", y1);
			newProperties.put("X2", x2);
			newProperties.put("Y2", y2);
			
			Shape newShape = (Shape) this.clone();
			newShape.setProperties(newProperties);
			return newShape;
			
		}
		
		 private double getLength(double x1,double y1,double x2, double y2) 
		 { 
			
			return Math.sqrt((Math.pow(x2-x1, 2))+Math.pow(y2-y1, 2));
			
		}
		

	}