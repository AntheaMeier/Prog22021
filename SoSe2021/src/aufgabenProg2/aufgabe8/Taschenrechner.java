package aufgabenProg2.aufgabe8;

import java.awt.*;

import javax.swing.*;

public class Taschenrechner extends JFrame
{

	public Taschenrechner() 
	{
		super("Taschenrechner");
		JPanel mainPanel = init();
		this.add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,200);
		setSize(250,350);
		setVisible(true);
	}
	
	private JPanel init() 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel oben = new JPanel();
    	oben.setLayout(new FlowLayout());
    	JTextField textfeld = new JTextField(8); // Textfeldbreite
    	textfeld.setHorizontalAlignment(JTextField.RIGHT);  // Textfeld-Ausrichtung
    	textfeld.setFont(new Font("Verdana", Font.PLAIN, 24));  // Schriftart
    	oben.add(textfeld);                   // Textfeld platzieren
    
    	JPanel unten = new JPanel();
    	unten.setLayout(new GridLayout(6,3,10,10));  //6 Zeilen, 3 Spalten und je 10px Abstand
    	JButton bZiffern[] = new JButton[9];
    	for(int i=0; i<9; i++) 
    	{
    		bZiffern[i] = new JButton(i+1+""); // weshalb +"" ??
    		unten.add(bZiffern[i]);
    	}
    	
    	JButton bKauf = new JButton("(");
    	unten.add(bKauf);
    	JButton bNull = new JButton("0");
    	unten.add(bNull);
    	JButton bZu = new JButton(")");
    	unten.add(bZu);
    	JButton bMal = new JButton("*");
    	unten.add(bMal);
    	JButton bBruch = new JButton("/");
    	unten.add(bBruch);
    	JButton bPlus = new JButton("+");
    	unten.add(bPlus);
    	JButton bMinus = new JButton("-");
    	unten.add(bMinus);
    	JButton bPunkt = new JButton(".");
    	unten.add(bPunkt);
    	JButton bGleich = new JButton("=");
    	unten.add(bGleich);
    	
    	panel.add(oben,BorderLayout.NORTH);
    	panel.add(unten,BorderLayout.CENTER);
		
		return panel;
	}
	
	
	public static void main(String[] args) 
	{
		new Taschenrechner();

	}

}
