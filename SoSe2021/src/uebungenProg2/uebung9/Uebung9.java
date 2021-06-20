package uebungenProg2.uebung9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Uebung9 extends JFrame implements ActionListener
{
    //Objektvariablen: 
    //1. Textfeld, zwei Buttons (add und remove)
    //2. unteres Panel
    //4. Liste mit Labeln
	
	JTextField textfeld;
	JPanel unten;
    JButton b1;
    JButton b2;
    List<JLabel> labels = new ArrayList<>();  // Liste voll mit Labels
	

    public Uebung9()
    {       
        super();
        this.setTitle("Elemente hinzufügen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = this.initContent();                                    //muss ich unten schreiben
        this.getContentPane().add(panel);
        
        this.setSize(400,100);
        this.setLocation(200,300);
        this.setVisible(true);
    }
   
    private JPanel initContent()
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1));  // 2 Zeilen und 1 Spalte

        // bei Grid und Flow Layout spielt die Reihenfoge eine Rolle
        JPanel oben = new JPanel();
        this.textfeld = new JTextField(10);
        this.b1 = new JButton("add");
        this.b1.setActionCommand("add"); //dopplelmoppel?
        this.b2 = new JButton("remove");
        
        oben.setBackground(Color.YELLOW);
        oben.add(this.textfeld); 
        oben.add(this.b1); 
        oben.add(this.b2); 
        
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        
        mainPanel.add(oben);
        
        this.unten = new JPanel();
        unten.setBackground(Color.CYAN);
        
        mainPanel.add(unten);
        return mainPanel;   //Fensteroptik erscheint vollständig
}

    @Override
    public void actionPerformed(ActionEvent e) 
    {

    	Object quelle = e.getSource();    // welche Komponente hat das Actionevent ausglöst, d.h. welcher Button wurde geklickt?
		if(quelle instanceof JButton) 
		{
			JButton button = (JButton) quelle;
			if(button.getActionCommand().equals("add")) 
			{
				JLabel neu = new JLabel(this.textfeld.getText());
				neu.setOpaque(true);
				neu.setBackground(Color.RED);
				neu.setForeground(Color.WHITE);
				this.labels.add(neu);
				this.unten.add(neu);
				System.out.println(this.textfeld.getText()); //gibt den Text im Textfeld auf der Konsole aus 
				System.out.println("Es wurde der add-Button geklickt!");
			}
			else if(button.getActionCommand().equals("remove"))
			{
				String inputText = this.textfeld.getText();
				Iterator<JLabel> itero = this.labels.iterator();
				while(itero.hasNext()) 
				{
					JLabel aktLabel = itero.next();
					if(aktLabel.getText().equals(inputText)) 
					{
						itero.remove();
						this.unten.remove(aktLabel);
					}
				}
				System.out.println("Es wurde der remove-Button geklickt!");
			}
			this.unten.revalidate();
			this.unten.repaint();
		}
    }

    public static void main(String[] args) 
    {
        new Uebung9();
    }
}