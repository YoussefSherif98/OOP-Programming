package eg.edu.alexu.csd.oop.draw;

public class MyStackNode {
	
	// 0 -> add ; 1 -> remove ; 2 -> update
	int operation;
	Shape shape1;
	Shape shape2;
	
	public MyStackNode(int operation, Shape shape1, Shape shape2) {
		super();
		this.operation = operation;
		this.shape1 = shape1;
		this.shape2 = shape2;
	}
	
	public MyStackNode() {;}
	
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public Shape getShape1() {
		return shape1;
	}
	public void setShape1(Shape shape1) {
		this.shape1 = shape1;
	}
	public Shape getShape2() {
		return shape2;
	}
	public void setShape2(Shape shape2) {
		this.shape2 = shape2;
	}
	
	
	

}
