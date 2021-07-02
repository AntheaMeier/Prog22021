package uebungenProg2.uebung10;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Uebung10 extends JFrame
{
	public Uebung10()
    {
        super();
        this.setTitle("Uebung 10");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        //this.getContentPane().add(this.initContent());
        this.getContentPane().add(new Canvas());

        this.setSize(400, 300);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private class Canvas extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)    // wird bei jeder Fensterskalierung aufgerufen
        {
        	super.paintComponent(g); // zeichnet ein graues Recheck
        	Graphics2D g2 = (Graphics2D)g; // importiert g nach Graphics2D um mehr Methoden zur Verfügung zu haben
        	
        	//g2.drawRect(20, 130, 200, 100);
        	
        	int abstand = this.getHeight()/20;
        	int hoehe = this.getHeight() - 2 * abstand;
        	int breite = this.getWidth() - 2 * abstand;
        	
        	Random r = new Random();
        	int rot = r.nextInt(265);
        	int gruen = r.nextInt(265);
        	int blau = r.nextInt(265);
        	
        	Color c = new Color(rot, gruen, blau);
        	g2.setColor(c);
        	
        	if(hoehe < breite)      // solange das Fenster breiter als hoch ist -> farbig gefülltes Quadrat (g2 ist eine Fläche)
        	{
        		int abstandLinks = (this.getWidth() - hoehe)/2;   // hier ist die Höhe kleiner, also passt sich die Q.größe der Höhe an
        		g2.fillRect(abstandLinks, abstand, hoehe, hoehe);
        	}
        	else                     // solange das Fenster schmaler als hoch ist -> Quadratrahmen dick zeichnen (g2 ist eine Linie)
        	{
        		int abstandOben = (this.getHeight() - breite)/2; // hier ist die Breite kleiner, also passt sich die Q.größe der Breite an
        		g2.setStroke(new BasicStroke(5.0f));               //dicke Linien
        		g2.drawRect(abstandOben, abstand, breite, breite);
        	}
        	
            
        }
    }

    public static void main(String[] args) 
    {
        new Uebung10();
    }

}
