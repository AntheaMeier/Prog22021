package aufgabenProg2.aufgabe9;

import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

import javax.swing.*;

public class Taschenrechner extends JFrame implements ActionListener
{
	JTextField textfeld;

	public Taschenrechner() 
	{
		super("Taschenrechner");
		this.setLocation(500,250);
		this.setSize(200,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = init();
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
	}
	
	private JPanel init() 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel oben = new JPanel();
    	oben.setLayout(new FlowLayout());
    	this.textfeld = new JTextField(8); // Textfeldbreite
    	textfeld.setHorizontalAlignment(JTextField.RIGHT);  // Textfeld-Ausrichtung
    	textfeld.setFont(new Font("Verdana", Font.PLAIN, 24));  // Schriftart
    	textfeld.setEditable(false); //über die Laptoptastatur nicht mehr beschreibbar
    	oben.add(textfeld);         // Textfeld platzieren
    
    	JPanel unten = new JPanel();
    	unten.setLayout(new GridLayout(6,3,10,10));  //6 Zeilen, 3 Spalten und je 10px Abstand
    	JButton bZiffern[] = new JButton[9];
    	for(int i=0; i<9; i++) 
    	{
    		bZiffern[i] = new JButton(i+1+""); // weshalb +"" ??
    		bZiffern[i].addActionListener(this);   // hört jeden Buttonklick ab
    		unten.add(bZiffern[i]);
    	}
    	
    	JButton bKauf = new JButton("(");
    	bKauf.addActionListener(this);
    	unten.add(bKauf);
    	
    	JButton bNull = new JButton("0");
    	bNull.addActionListener(this);
    	unten.add(bNull);
    	
    	JButton bZu = new JButton(")");
    	bZu.addActionListener(this);
    	unten.add(bZu);
    	
    	JButton bMal = new JButton("*");
    	bMal.addActionListener(this);
    	unten.add(bMal);
    	
    	JButton bBruch = new JButton("/");
    	bBruch.addActionListener(this);
    	unten.add(bBruch);
    	
    	JButton bPlus = new JButton("+");
    	bPlus.addActionListener(this);
    	unten.add(bPlus);
    	
    	JButton bMinus = new JButton("-");
    	bMinus.addActionListener(this);
    	unten.add(bMinus);
    	
    	JButton bPunkt = new JButton(".");
    	bPunkt.addActionListener(this);
    	unten.add(bPunkt);
    	
    	JButton bGleich = new JButton("=");
    	bGleich.addActionListener(this);
    	unten.add(bGleich);
    	
    	JPanel ganzUnten = new JPanel();
    	
    	JButton bC = new JButton("C");
    	bC.addActionListener(this);
    	ganzUnten.add(bC);
    	
    	JButton bCE = new JButton("CE");
    	bC.addActionListener(this);
    	ganzUnten.add(bCE);
    	
    	panel.add(oben,BorderLayout.NORTH);
    	panel.add(unten,BorderLayout.CENTER);
    	panel.add(ganzUnten,BorderLayout.SOUTH);
		
		return panel;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		Object quelle = e.getSource();
		if(quelle instanceof JButton) 
		{
			JButton button = (JButton) quelle;
			if(button.getActionCommand().equals("=")) 
			{
				String postfix = infixToPostfix(textfeld.getText());
				textfeld.setText(evaluate(postfix));
			}
			else if(button.getActionCommand().equals("C")) 
			{
				textfeld.setText("");
			}
			else if(button.getActionCommand().equals("CE")) 
			{
				String s = textfeld.getText();
				s = s.substring(0, s.length() - 1);
				textfeld.setText(s);
			}
			else 
			{
				textfeld.setText(textfeld.getText() + command);
			}
		}
		
	}
	
    private String evaluate(String postfix) 
    {
    	//create a stack
        Stack<Integer> stack = new Stack<>();
          
        // Scan all characters one by one
        for(int i=0;i<postfix.length();i++)
        {
            char c = postfix.charAt(i);
              
            // If the scanned character is a number, push it to the stack.
            if(Character.isDigit(c)) 
            {
            	stack.push(c - '0');
            } 
              
            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                  
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                      
                    case '-':
                    stack.push(val2- val1);
                    break;
                      
                    case '/':
                    stack.push(val2/val1);
                    break;
                      
                    case '*':
                    stack.push(val2*val1);
              }
            }
        }
        return stack.pop()+""; 

	}

	//Die folgende methode knvertiert einen infix Ausdruck in einen postfix Ausdruck.
 	//https://java2blog.com/infix-to-postfix-java/
 	//https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/?ref=lbp	
	static String infixToPostfix(String txt) 
	{
		String postfix = new String("");
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<txt.length(); ++i)
        {
            char c = txt.charAt(i);
             
            // Ist das eingescannte Zeichen c ein Operand, addiere es zur Ausgabe hinzu
            if (Character.isLetterOrDigit(c)) 
            {
            	postfix += c;
            }
                
              
            // Ist das eingescannte Zeichen c eine offene Klammer, lege es auf den Stapel
            else if (c == '(') 
            {
            	stack.push(c);
            }
                
         // Ist das eingescannte Zeichen c eine schließende Klammer, pop es aus dem Stapel bis eine öffnende Klammer erscheint
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(') 
                {
                	postfix += stack.pop();
                    stack.pop();
                }       
            }
            else //falls es ein Operator ist
            {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek()))
                {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty())
        {
            postfix += stack.pop();
        }
        return postfix;

	}

	private static int precedence(char character) 
	{
		switch (character)
        {
		     case '+':
             case '-':
             return 1;
      
             case '*':
             case '/':
             return 2;
 
        }
        return -1;
	}

	//einfache Rechenmethode
	public static String calculate(String expression) 
	{
		char[] arr = expression.toCharArray();
		String operand1 = "";
	    String operand2 = "";
	    String operator = "";
	    double result = 0;

	    for (int i = 0; i < arr.length; i++) 
	    {
	    	if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') 
	        {
	    		if(operator.isEmpty())
	    		{
	    			operand1 += arr[i];
		        }
	    		else
	    		{
	    			operand2 += arr[i];
		        }
	        } 
	    	if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') 
	        {
	           operator += arr[i];
	        }
	    }
	     
	    if (operator.equals("+")) 
	    {
	    	result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
	    }
	    else if (operator.equals("-")) 
	    {
	    	result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
	    }
	    else if (operator.equals("/")) 
	    {
	    	result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
	    }
	    else
	    {
	    	result = (Double.parseDouble(operand1) * Double.parseDouble(operand2)); 
	    }         
	    return ""+result;
	}   

	
	public static void main(String[] args) 
	{
		new Taschenrechner();

	}

}
