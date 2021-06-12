package uebungenProg2.uebung8;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class GUIuebung extends JFrame
{
	public GUIuebung() //Konstruktor
    {
        super(); //erbt von JFrame
        this.setTitle("GUI Uebung");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel content = this.initContent();  // die Methode unten drunter ausführen und in content aufangen
        this.getContentPane().add(content);   // diesen Inhalt der ContentPane hinzufügen
        
        this.setSize(400, 300);
        this.setLocation(500,300); // mittig
        this.setVisible(true);
    }

    private JPanel initContent()
    {       
        //mehrere Panels verwenden
    	JPanel mainP = new JPanel();
    	mainP.setLayout(new BorderLayout()); 
    	
    	Border redline = BorderFactory.createLineBorder(Color.RED); // rote Rahmenfarbe erzeugen
    	
    	//Oben
    	JPanel oben = new JPanel();
    	oben.setLayout(new FlowLayout());
    	JLabel text1 = new JLabel("Text im FlowLayout in North"); // Textinhalt
    	text1.setForeground(Color.WHITE);  // Textfarbe
    	oben.add(text1);                   // Text bzw Lable platzieren
    	oben.setBackground(Color.BLUE);    // Feld einfärben
    	oben.setBorder(redline);           // jetzt den rotenRahemn zum ersten mal einsetzen
    	
    	//Links
    	JPanel links = new JPanel();
    	links.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
    	JLabel text2 = new JLabel(" linker Text im FlowLayout im Center"); // Textinhalt
    	links.add(text2);                   // Text bzw Lable platzieren
    	links.setBackground(Color.LIGHT_GRAY);    // Feld einfärben, Textfarbe automatisch black, da nicht gesetzt
    	
    	JTextField input = new JTextField("linkes Textfeld",10);  //erzeugt ein Textfeld, durch die 10 Breite erfolgt es unter dem Text, sonst daneben
    	links.add(input);                                 // setzt dieses Textfeld ein
    	
    	
    	//Rechts
    	JPanel rechts = new JPanel();
    	rechts.setLayout(new GridLayout(2,1,10,10));
    	rechts.add(new JButton("Button 1"));        // Buttons erzeugen, einfügen und benennen
    	rechts.add(new JButton("Button 2")); 
    	rechts.setBackground(Color.LIGHT_GRAY);    // Feld einfärben
    	
    	mainP.add(oben, BorderLayout.NORTH);
    	mainP.add(links, BorderLayout.CENTER);
    	mainP.add(rechts, BorderLayout.EAST);
    	
    	return mainP;
    	
        //JTextField hat verschiedene Konstruktoren, nicht nur JTextField(int columns)
        //Beim FlowLayout ändert sich die Größe der Steuerelemente nicht,
        //bei GridLayout passt sich die Größe an den Container an

    }

    
    
    public static void main(String[] args) 
    {
        new GUIuebung();
    }

}
