package eg.edu.alexu.csd.oop.draw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PaintAppGUI {

	private JFrame frame;
	
	Point p1 = new Point();
	Point p2 = new Point();
	
	PaintApp drawer = new PaintApp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintAppGUI window = new PaintAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaintAppGUI() {
		initialize();
	}
	Map<String,Integer> m = new HashMap<>();
	private void setM() {
		m.put("FreeDraw", 0);
		m.put("Circle", 1);
		m.put("Triangle", 2);
		m.put("Rectangle", 3);
		m.put("Ellipse", 4);
		m.put("Square", 5);
		m.put("Line", 6);
		
	}
	Graphics g;
	Color BrushColor = (Color.BLACK);
	Color FillColor = (Color.BLACK);
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setResizable(false);
		frame.setBounds(100, 100, 851, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		drawer.SetMyPanel(panel);
		
		JComboBox<String> MyShapes = new JComboBox<String>();
		MyShapes.setModel(new DefaultComboBoxModel<String>(new String[] {"Free Draw", "Circle", "Triangle", "Rectangle", "Ellipse", "Square", "Line"}));
		MyShapes.setBounds(680, 34, 133, 26);
		frame.getContentPane().add(MyShapes);
		
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
					p1.x = e.getX();
					p1.y = e.getY();
					
					super.mousePressed(e);
				}
			@Override
			public void mouseReleased(MouseEvent e) {
				
					p2.x = e.getX();
					p2.y = e.getY();
					
					Graphics canvas = panel.getGraphics();
					setM();
					
					int shapeIndex = m.get((String)MyShapes.getSelectedItem());
					
					Shape s = getShape(shapeIndex,p1,p2);
					s.setColor(BrushColor);
					s.setFillColor(FillColor);
					drawer.addShape(s);
					drawer.refresh(canvas);
										
					super.mouseReleased(e);
				}
			}
			
		);
		panel.setBounds(12, 74, 821, 528);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JSlider BrushSize = new JSlider();
		BrushSize.setMinimum(5);
		BrushSize.setMaximum(30);
		BrushSize.createStandardLabels(5,5);
		BrushSize.setMajorTickSpacing(5);
		BrushSize.setPaintTrack(true);
		BrushSize.setBounds(220, 34, 200, 26);
		frame.getContentPane().add(BrushSize);
		
		JLabel lblBrushSize = new JLabel("Brush Size");
		lblBrushSize.setFont(new Font("Neo Tech Alt Medium", Font.BOLD, 17));
		lblBrushSize.setForeground(new Color(255, 255, 255));
		lblBrushSize.setBounds(220, 13, 156, 16);
		frame.getContentPane().add(lblBrushSize);
		
		JLabel lblShapes = new JLabel("Shapes");
		lblShapes.setForeground(new Color(255, 255, 255));
		lblShapes.setFont(new Font("Neo Tech Alt Medium", Font.BOLD, 18));
		lblShapes.setBounds(680, 5, 87, 24);
		frame.getContentPane().add(lblShapes);
		
		JButton SaveBtn = new JButton("");
		SaveBtn.setIcon(new ImageIcon("img/save.png"));
		SaveBtn.setBounds(12, 13, 50, 50);
		frame.getContentPane().add(SaveBtn);
		
		JButton LoadBtn = new JButton("");
		LoadBtn.setIcon(new ImageIcon("img/getmoney.png"));
		LoadBtn.setBounds(74, 13, 50, 50);
		frame.getContentPane().add(LoadBtn);
		
		JButton UndoBtn = new JButton("");
		UndoBtn.setIcon(new ImageIcon("img/undo.png"));
		UndoBtn.setBounds(136, 13, 30, 50);
		frame.getContentPane().add(UndoBtn);
		
		JButton RedoBtn = new JButton("");
		RedoBtn.setIcon(new ImageIcon("img/redo.png"));
		RedoBtn.setBounds(178, 13, 30, 50);
		frame.getContentPane().add(RedoBtn);
		
		JButton BrushBtn = new JButton("");
		BrushBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrushColor = JColorChooser.showDialog(null, "Pick the brush color", BrushColor);
				if (BrushColor == null ) {
					BrushColor = (Color.black);
				}
				
			}
		});
		BrushBtn.setBounds(432, 13, 50, 50);
		frame.getContentPane().add(BrushBtn);
		BrushBtn.setIcon(new ImageIcon("img/paintbrush.png"));
		BrushBtn.setBackground(BrushColor);
		
		JButton EraseBtn = new JButton("");
		EraseBtn.setBounds(494, 13, 50, 50);
		frame.getContentPane().add(EraseBtn);
		EraseBtn.setBackground(SystemColor.menu);
		EraseBtn.setIcon(new ImageIcon("img/eraser.png"));
		
		JButton ColorsBtn = new JButton("");
		ColorsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FillColor = JColorChooser.showDialog(null, "Pick the fill color", FillColor);
				if (FillColor == null ) {
					FillColor = (Color.black);
				}
				
			}
		});
		ColorsBtn.setBounds(556, 13, 50, 50);
		frame.getContentPane().add(ColorsBtn);
		ColorsBtn.setIcon(new ImageIcon("img/paintcan.png"));
		ColorsBtn.setBackground(FillColor);
		
		JButton FillBtn = new JButton("");
		FillBtn.setBounds(618, 13, 50, 50);
		frame.getContentPane().add(FillBtn);
		FillBtn.setBackground(new Color(210, 105, 30));
		FillBtn.setIcon(new ImageIcon("img/eyedropper.png"));
	}
	
	private Shape getShape (int x,Point p1,Point p2)
	{
		Shape s;
		switch (x)
		{
		case 1:
			s = new Circle(p1,p2);
			break;
		case 2:
			s = new Triangle(p1,p2);
			break;
		case 3:
			s = new Rectangle(p1,p2);
			break;
		case 4:
			s = new Ellipse(p1,p2);
			break;
		case 5:
			s = new Square(p1,p2);
			break;
		case 6:
			s = new StraightLine(p1,p2);
			break;
			default:
				s = new StraightLine(p1,p2);
			
		}
		
		return s;
		
	}
}