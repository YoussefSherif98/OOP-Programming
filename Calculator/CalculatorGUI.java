package eg.edu.alexu.csd.oop.calculator.cs75;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI {

	private Calculator calc = new MyCalculator();
	
	boolean cont = false;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
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
	public CalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Rockwell", Font.BOLD, 17));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(45, 11, 249, 40);
		frame.getContentPane().add(label);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'1');
			}
		});
		btn1.setBounds(10, 62, 55, 35);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'2');

			}
		});
		btn2.setBounds(75, 62, 55, 35);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'3');

			}
		});
		btn3.setBounds(140, 62, 55, 35);
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'4');

			}
		});
		btn4.setBounds(10, 106, 55, 35);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'5');

			}
		});
		btn5.setBounds(75, 106, 55, 35);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'6');

			}
		});
		btn6.setBounds(140, 106, 55, 35);
		frame.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'7');
			}
		});
		btn7.setBounds(10, 147, 55, 35);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'8');
			}
		});
		btn8.setBounds(75, 147, 55, 35);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'9');
			}
		});
		btn9.setBounds(140, 147, 55, 35);
		frame.getContentPane().add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'0');
			}
		});
		btn0.setBounds(10, 191, 55, 35);
		frame.getContentPane().add(btn0);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				cont=false;
				label.setText(label.getText()+'+');
			}
		});
		btnAdd.setBounds(205, 62, 55, 35);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				cont=false;
				label.setText(label.getText()+'-');
			}
		});
		btnSub.setBounds(205, 106, 55, 35);
		frame.getContentPane().add(btnSub);
		
		JButton btnMult = new JButton("*");
		btnMult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				cont=false;
				label.setText(label.getText()+'*');
			}
		});
		btnMult.setBounds(205, 147, 55, 35);
		frame.getContentPane().add(btnMult);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				cont=false;
				label.setText(label.getText()+'/');
			}
		});
		btnDiv.setBounds(205, 191, 55, 35);
		frame.getContentPane().add(btnDiv);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label.getText()=="ERROR")
				{
					label.setText("");
				}
				if(cont)
				{
					label.setText("");
					cont = false;
				}
				label.setText(label.getText()+'.');
			}
		});
		btnDot.setBounds(75, 191, 55, 35);
		frame.getContentPane().add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = label.getText();
				
				if(s!="")
				{
					calc.input(s);
					String result = calc.getResult();
					if (result == null)
					{
						label.setText("ERROR");
						s="";
					}
					else
					{
						label.setText(result);
					}
					
					cont = true;
				}
				
			}
		});
		btnEqual.setFont(new Font("Times New Roman", Font.BOLD, 55));
		btnEqual.setBounds(10, 235, 249, 42);
		frame.getContentPane().add(btnEqual);
		
		JButton btnAC = new JButton("AC");
		btnAC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				label.setText("");
				cont = false;
			}
		});
		
		btnAC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAC.setBounds(140, 191, 55, 35);
		frame.getContentPane().add(btnAC);
		
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = calc.next();
				if(s!=null)
					label.setText(s);
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(299, 111, 80, 40);
		frame.getContentPane().add(btnNext);
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String s = calc.prev();
				if(s!=null)
					label.setText(s);
			}
		});
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrev.setBounds(299, 60, 80, 40);
		frame.getContentPane().add(btnPrev);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					calc.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(299, 189, 80, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					calc.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLoad.setBounds(299, 237, 80, 40);
		frame.getContentPane().add(btnLoad);
	}
}
