package eg.edu.alexu.csd.oop.calculator.cs75;

import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.lang.*;

public class MyCalculator implements Calculator {

	String[] strs = new String[5];
	int currentInd = -1;
	int temp = -1;
	
	private Formatter x;
	private Scanner input;
	
	public void input(String s) {

		
		if(currentInd<4)
		{
			currentInd++;
			temp=currentInd;
			strs[currentInd] = s;
		}
		else
		{
			for(int i=0;i<strs.length-1;i++)
			{
				strs[i]=strs[i+1];
			}
			strs[currentInd] = s;
		}
	}

	public String getResult() {
		
		String formula = strs[temp];
		
		if(!regexChecker(formula))
			return null;
		
		formula = simplify(formula);
		int index = operandIndex(formula);
		
		double num1,num2,result=0;
		
		char operand = formula.charAt(index);

		num1 = Double.parseDouble(formula.substring(0, index));
		num2 = Double.parseDouble(formula.substring(index+1, formula.length()));

		switch (operand)
		{
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			if(num2==0)
				return null;
			result = num1 / num2;
			break;
		}
		
		return Double.toString(result);
	}

	
	public String current() {
		if(temp>=0)
			return strs[temp];
		return null;
	}

	public String prev() {
		if(temp-1>=0)
			return strs[--temp];
		return null;
	}

	
	public String next() {
		if(temp+1<5 &&strs[temp+1]!=null)
			return strs[++temp];
		return null;
	}

	
	public void save() throws IOException{
		String s = new String();
		s = Integer.toString(currentInd) + "\n" + Integer.toString(temp);
		for(int i=0; i<5 &&strs[i]!=null ;i++)
			s = s + "\n" + strs[i];
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
		writer.append(s);
		writer.close();

	}

	
	public void load() throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt",true));
		writer.close();
		
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		String s = reader.readLine();
		if(s==null)
			return;
		currentInd = Integer.valueOf(s);
		temp = Integer.valueOf(reader.readLine());
		
		s=reader.readLine();
		for(int i=0;i<5 && s!=null ; i++)
		{
			strs[i] = s;
			s = reader.readLine();
		}
		
		reader.close();
	}
	
	private boolean regexChecker(String s) {
		
		String patternString = "([+-])*(\\d)*(\\.)?(\\d)+[*/+-]([+-])*(\\d)*(\\.)?(\\d)+";
		
		Pattern pattern;
	    Matcher matcher;
	    
	    pattern = Pattern.compile(patternString);
	    matcher = pattern.matcher(s);
	    
		return matcher.matches();
	}

	private int operandIndex(String s)
	{
		
		int index = -1;
		
		String patternString = "[*/+-]";
		
		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile(patternString);
		matcher = pattern.matcher(s);
		
		while (matcher.find())
		{
			if(matcher.start()!=0)
			{
				index = matcher.start();
				break;
			}
		}
		
		return index;
	}

	private String simplify(String s) {
		
		s = s.replace("++", "+");
		s = s.replace("--", "+");
		s = s.replace("+-", "-");
		s = s.replace("-+","-");
		
		return s;
	}

	private void openFile() {
		try {
			x = new Formatter("data.txt");
		}
		catch (Exception e) {
			;
		}
		
	}

	private void closeFile()
	{
		x.close();
	}
}
