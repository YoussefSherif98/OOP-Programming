package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class PaintApp implements DrawingEngine {
	Shape shapArr[] = new Shapes[20000]; 
	int Capacity = 0 ;
	JPanel panel;
	public void SetMyPanel(JPanel p) {
		this.panel = p ;
	}
	@Override
	public void refresh(Graphics canvas) {

		
	    for (int i=0 ; i<Capacity ; i++) {
	    	shapArr[i].draw(canvas);

	    }

	}

	@Override
	public void addShape(Shape shape) {
		if (Capacity != -1) {
			shapArr[Capacity++] = shape;
		}

	}

	@Override
	public void removeShape(Shape shape) {
		
		Shape s;
		for(int i=0;i<Capacity;i++)
		{
			s = shapArr[i];
			if(s == shape)
			{
				for(int j=i;j<Capacity-1;j++)
				{
					shapArr[j] = shapArr[j+1];
				}
				shapArr[Capacity-1] = null;
				Capacity--;
			}
		}
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub

	}

	@Override
	public Shape[] getShapes() {
		return shapArr;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub

	}

}