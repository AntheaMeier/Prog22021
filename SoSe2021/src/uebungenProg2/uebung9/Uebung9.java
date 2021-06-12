package uebungenProg2.uebung9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Uebung9 extends JFrame implements  ActionListener
{
    //Objektvariablen: 
    //1. Textfeld, zwei Buttons (add und remove)
    //2. unteres Panel
    //4. Liste mit Labeln
	
	JLabel textfeld;
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

        JPanel oben = new JPanel();
        oben.setLayout(new FlowLayout());       
        oben.setBackground(Color.YELLOW);
        
        this.textfeld = new JLabel("Text");
        this.b1 = new JButton("add");
        this.b2 = new JButton("remove");
        
        oben.add(textfeld); 
        oben.add(b1); 
        oben.add(b2); 
        
        this.unten = new JPanel();
        unten.setBackground(Color.CYAN);
        

        /*JPanel links = new JPanel();
        links.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        JLabel text2 = new JLabel("Weiterer Text");
        links.add(text2);
        JTextField input = new JTextField("Feld",10);
        links.add(input);       
        links.setBackground(Color.LIGHT_GRAY);


        JPanel rechts = new JPanel();
        rechts.setLayout(new GridLayout(2,1,20,20));
        rechts.add(new JButton("Button 1"));*/
        

     
       

        return mainPanel;
    

    
    //2. main-JPanel in JPanels unten und oben unterteilen
    //Dem Panel oben werden das Textfeld und die beiden Buttons hinzugefügt,
    //das lagern wir in die Methode createOben() aus
    //oben: Hintergrundfarbe ist YELLOW
    //unten: Hintergrundfarbe ist CYAN
    //Das Panel unten soll ebenfalls eine Objektvariable sein.

    //4. neue ArrayList für die Label anlegen 
}

    /*private JPanel createOben()
    {
        //...

        return panel;
    }*/

    @Override
    public void actionPerformed(ActionEvent e) 
    {

        //Quelle des Events ermitteln

        //Falls es der "add"-Button ist
        // - Text aus dem Textfeld übernehmen
        // - neues Label mit dem Text anlegen 
        // - das Label formatieren (Hintergrundfarbe RED)
        //   Tipp: wenn Sie einem JLabel eine Hintergrundfarbe mit setBackground(Color c) 
        //   setzen, dann sieht man diese nur, wenn Sie für dieses JLabel die Methode 
        //   setOpaque(true) aufrufen. Nur dadurch werden für dieses JLabel alle Pixel 
        //   gezeichnet, die in dessen Grenzen sind, d.h. das komplette Rechteck, 
        //   das das JLabel ausfüllt. Ansonsten würde nur der Text "gezeichnet" und 
        //   die Hintergrundfarbe wäre hinter dem Text versteckt.
        // - das Label in Label-Liste einfügen 
        // - das Label dem unteren Panel hinzufügen

        //Falls es der "remove"-Button ist
        // - Text aus dem Textfeld übernehmen
        // - durch die Label-Liste iterieren, um das zu entfernende Label zu finden  
        //   Tipp: Iterator nehmen
        //   Iterator<Typ> it = variable.iterator();
        //   while(it.hasNext()){ 
        //      mach irgendwas mit it.next()
        //   } 
        //   das Label muss sowohl aus der Liste als auch aus dem Panel entfernt werden 

        //Text im Textfeld löschen      
        //weitere nötige Schritte requestFocus(), revalidate(), repaint()

    }

    public static void main(String[] args) 
    {
        new Uebung9();
    }

    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("wurde geklickt");
		
	}
}