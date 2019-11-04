package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

public class PaintApp implements DrawingEngine {
	
	private ArrayList<Shape> ShapeArr = new ArrayList<Shape>();
    JPanel panel;
    
    private JFileChooser fc = new JFileChooser();
    private FileFilter filter = new FileNameExtensionFilter(null,"XML","JSON");
	File file ;
    
	public Stack<MyStackNode> undoStack = new Stack<MyStackNode>();
	public Stack<MyStackNode> redoStack = new Stack<MyStackNode>();
	
	public Shape dragShape = null;
	
	boolean flag = true;
	
	public void SetMyPanel(JPanel p) {
		this.panel = p ;
	}
	public int ArrSize() {
		return ShapeArr.size();
	}
	
	@Override
	public void refresh(Graphics canvas) {

		
	    for (int i=0 ; i<ShapeArr.size() ; i++) {
	    	ShapeArr.get(i).draw(canvas);
	    }
	   

	}

	@Override
	public void addShape(Shape shape) {
		ShapeArr.add(shape);

		MyStackNode node = new MyStackNode(0,shape,null);
		undoStack.push(node);
		if (flag)
		{
	    	 redoStack.clear();
		}
	}

	@Override
	public void removeShape(Shape shape) {
		
		for(int i=0;i<ShapeArr.size();i++)
		{
			Shape s = ShapeArr.get(i);
			if(shape.equals(s))
			{
				ShapeArr.remove(i);
			}
		}
		MyStackNode node = new MyStackNode(1,shape,null);
		undoStack.push(node);
		
		if(flag)
		{
	    	 redoStack.clear();
		}
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
	     if (oldShape.equals(newShape)) {
	    	 ;
	     } 
	     else {
	    	 Shape s = oldShape;
	    	 for (int i=0 ; i<ShapeArr.size() ; i++ ) {
	    		 if (s.equals(ShapeArr.get(i))) {
	    			 ShapeArr.set(i, newShape) ;
	    			 break;
	    		 }
	    	 }
	    	 
	     }
	     MyStackNode node = new MyStackNode(2,oldShape,newShape);
	     undoStack.push(node);
	     if (flag)
	     {
	    	 redoStack.clear();
	     }
	}

	@Override
	public Shape[] getShapes() {
		int y = ShapeArr.size();
		Shape s[] = new Shapes[y] ;
		for (int i=0 ; i<y ; i++ ) {
			s[i] = ShapeArr.get(i) ;
		}
		return s;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		
		List<Class<? extends Shape>> SupportedShapes = new ArrayList<Class<? extends Shape>>() ;
		SupportedShapes.add(Circle.class);
		SupportedShapes.add(Ellipse.class);
		SupportedShapes.add(Rectangle.class);
		SupportedShapes.add(Square.class);
		SupportedShapes.add(StraightLine.class);
		SupportedShapes.add(Triangle.class);
		
		return SupportedShapes;
	}

	@Override
	public void undo() {
		
		if(!undoStack.isEmpty())
		{	
			flag = false;
			MyStackNode node = undoStack.pop();
			MyStackNode reversedNode = reverse(node);
			flag = true;
			redoStack.push(reversedNode);
		}
	}

	@Override
	public void redo() {
		if(!redoStack.isEmpty())
		{
			flag = false;
			MyStackNode node = redoStack.pop();
			MyStackNode reversedNode = reverse(node);
			flag = true;
			undoStack.push(reversedNode);
		}
	}

	@Override
	public void save(String path) {
		if (path == "Error") {
			return;
		}
		Stack<Character> Type = new Stack<Character>();
		for (int i=0 ; i< path.length() ; i++ ) {
			Type.push(path.charAt(i));
		}
		StringBuilder S = new StringBuilder();
		for (int i=0 ; i<5 ; i++) {
		S.append(Type.pop());
		}
		
		if ((S.charAt(0) == 'l' || S.charAt(0) == 'L') && (S.charAt(1) == 'm' || S.charAt(1) == 'M') && (S.charAt(2) == 'x' || S.charAt(2) == 'X') && (S.charAt(3) == '.' )) {
			try {
			    FileOutputStream fos = new FileOutputStream(new File(path));
				XMLEncoder encoder = new XMLEncoder (fos);
				encoder.writeObject(this.ShapeArr);
				encoder.close();
				fos.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null,"Failed to save");
			}
		}
		else if ((S.charAt(0) == 'n' || S.charAt(0) == 'N') && (S.charAt(1) == 'o' || S.charAt(1) == 'O') && (S.charAt(2) == 's' || S.charAt(2) == 'S') && (S.charAt(3) == 'j' || S.charAt(3) == 'J') && (S.charAt(4) == '.' )) {
			try
	        {
	            PrintWriter printer = new PrintWriter(path);
	            printer.println('{');
	            boolean FirstOne=true;
	            for(Shape shape:ShapeArr)
	            {
	                if(!FirstOne)
	                    printer.println(',');
	                FirstOne=false;
	                printer.print("  \"");
	                printer.print(shape.getClass());
	                printer.print("\"");
	                printer.println(": {");
	                if(shape.getPosition()!=null)
	                {
	                    printer.print("      \"point X\":");
	                    printer.print(shape.getPosition().x);
	                    printer.println(",");
	                    printer.print("      \"point Y\":");
	                    printer.print(shape.getPosition().y);
	                    printer.println(",");
	                }
	                if(shape.getColor()!=null)
	                {
	                    printer.print("      \"Color\":");
	                    printer.print("\"");
	                    printer.print(shape.getColor());
	                    printer.print("\"");
	                    printer.println(",");
	                }
	                if(shape.getFillColor()!=null)
	                {
	                    printer.print("      \"Fill color\":");
	                    printer.print("\":");
	                    printer.print(shape.getFillColor());
	                    printer.print("\"");
	                    printer.println(",");
	                }
	                Map<String,Double> map=shape.getProperties();
	                if(map!=null)
	                {
	                    printer.println("        \" Properties\":{");
	                    Iterator mapIterator = map.entrySet().iterator();
	                    int x=0;
	                    while (mapIterator.hasNext()) {
	                        x++;
	                        Map.Entry mapElement = (Map.Entry)mapIterator.next();
	                        printer.print("          \"");
	                        printer.print(mapElement.getKey() );
	                        printer.print("\":");
	                        printer.print(mapElement.getValue());
	                        if(x==map.size())
	                            printer.println("}");
	                        else
	                            printer.println(',');
	                    }
	                }
	                printer.print("    }");
	            }
	            printer.println("}");
	            printer.close();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null,"Failed to save");
	        }
			
		}else {
			JOptionPane.showMessageDialog(null,"Wrong file type!! Only .xml & .JSON allowed");
		}
	}

	@Override
	public void load(String path) {
		if (path == "Error") {
			return;
		}
		Stack<Character> Type = new Stack<Character>();
		for (int i=0 ; i< path.length() ; i++ ) {
			Type.push(path.charAt(i));
		}
		StringBuilder S = new StringBuilder();
		for (int i=0 ; i<5 ; i++) {
		S.append(Type.pop());
		}
		
		if ((S.charAt(0) == 'l' || S.charAt(0) == 'L') && (S.charAt(1) == 'm' || S.charAt(1) == 'M') && (S.charAt(2) == 'x' || S.charAt(2) == 'X') && (S.charAt(3) == '.' )) {
			try {
			    FileInputStream fos = new FileInputStream(new File(path));
				XMLDecoder decoder = new XMLDecoder (fos);
				this.ShapeArr = (ArrayList<Shape>)decoder.readObject();
				decoder.close();
				fos.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		else if ((S.charAt(0) == 'n' || S.charAt(0) == 'N') && (S.charAt(1) == 'o' || S.charAt(1) == 'O') && (S.charAt(2) == 's' || S.charAt(2) == 'S') && (S.charAt(3) == 'j' || S.charAt(3) == 'J') && (S.charAt(4) == '.' )) {
			 Scanner readCodes;
			 this.ShapeArr.clear();
			try {
		        readCodes = new Scanner(new File(path));
		        } catch (IOException e) {
		        	JOptionPane.showMessageDialog(null,"No data to load");
		            throw new RuntimeException();
		        }
		        readCodes.nextLine();
		        while(readCodes.hasNextLine())
		        {
		            String current = readCodes.nextLine();
		            Shape CurrentShape= null;
		            for(Class<? extends Shape> shapeClass : this.getSupportedShapes())
		            {
		                if(current.contains(shapeClass.toString()))
		                {
		                    try
		                    {
		                        CurrentShape=shapeClass.newInstance();
		                        break;
		                    }catch (Exception e)
		                    {
		                        e.printStackTrace();
		                    }
		                }
		            }
		            current=readCodes.nextLine();
		            int x,y;
		            if(current.contains("X"))
		            {
		                x=Integer.parseInt(current.substring(current.indexOf(":")+1,current.length()-1));
		                current=readCodes.nextLine();
		                y=Integer.parseInt(current.substring(current.indexOf(":")+1,current.length()-1));
		                CurrentShape.setPosition(new Point(x,y));
		                current=readCodes.nextLine();
		            }
		            if(current.contains("Color")&&!current.contains("Fill"))
		            {
		                int r,g,b;
		                r=Integer.parseInt(current.substring(current.indexOf("r=")+2, current.indexOf("g=")-1));
		                g=Integer.parseInt(current.substring(current.indexOf("g=")+2, current.indexOf("b=")-1));
		                b=Integer.parseInt(current.substring(current.indexOf("b=")+2, current.indexOf("]")));
		                CurrentShape.setColor(new Color(r,g,b));
		                current=readCodes.nextLine();
		            }
		            if(current.contains("Color")&&current.contains("Fill"))
		            {
		                int r,g,b;
		                r=Integer.parseInt(current.substring(current.indexOf("r=")+2, current.indexOf("g=")-1));
		                g=Integer.parseInt(current.substring(current.indexOf("g=")+2, current.indexOf("b=")-1));
		                b=Integer.parseInt(current.substring(current.indexOf("b=")+2, current.indexOf("]")));
		                CurrentShape.setFillColor(new Color(r,g,b));
		                current=readCodes.nextLine();
		            }
		            if(current.contains("Properties"))
		            {
		                Map<String,Double>mp=new HashMap<>();
		                while(true)
		                {
		                    current=readCodes.nextLine();
		                    String key=current.substring(current.indexOf("\"")+1,current.indexOf(":")-1);
		                    double value=Double.parseDouble(current.substring(current.indexOf(":")+1,current.length()-1));
		                    mp.put(key,value);
		                    if(current.contains("}"))
		                        break;
		                }
		                CurrentShape.setProperties(mp);
		            }
		            ShapeArr.add(CurrentShape);
		            if(readCodes.hasNextLine())
		                readCodes.nextLine();
		        }
		       
				
		}else {
			JOptionPane.showMessageDialog(null,"Wrong file type!! Only .xml & .JSON allowed");
		}
	}

	public String ChooseFileToSave() {
		fc.setFileFilter(filter);
		int response = fc.showSaveDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {	
			file = fc.getSelectedFile();
			System.out.println(fc.getSelectedFile().toString());
			return fc.getSelectedFile().getAbsolutePath().toString();
		}
		else {
			JOptionPane.showMessageDialog(null,"No file was chosen");
			return "Error"; 
		}
	}
	
	public String ChooseFileToLoad() {
		fc.setFileFilter(filter);
		int response = fc.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {	
			file = fc.getSelectedFile();
			System.out.println(fc.getSelectedFile().toString());
			return fc.getSelectedFile().getAbsolutePath().toString();
		}
		else {
			JOptionPane.showMessageDialog(null,"No file was chosen");
			return "Error"; 
		}
	}
	
	public Shape GetSelectedShape(Point p) {
		
		Shape[] MyShapes = this.getShapes();
		
		for (int i=MyShapes.length-1; i>=0; i--) {
			Shape s = MyShapes[i];
			if (s.contain(p)) {
				return s;
			}
			
		}
		return null;
	}
	
	private MyStackNode reverse(MyStackNode node)
	{
		int operation = node.getOperation();
		MyStackNode newNode = new MyStackNode();
		switch (operation) {
		case 0: //Reversing add operation
			removeShape(node.getShape1());
			newNode.setOperation(1);
			newNode.setShape1(node.getShape1());
			break;
		case 1: //Reversing remove operation
			addShape(node.getShape1());
			newNode.setOperation(0);
			newNode.setShape1(node.getShape1());
			break;
		case 2: //Reversing update operation
			
			updateShape(node.getShape2(), node.getShape1());
			newNode.setOperation(2);
			newNode.setShape1(node.getShape2());
			newNode.setShape2(node.getShape1());
			break;
			
		}
		undoStack.pop();
		return newNode;
	}
	
}