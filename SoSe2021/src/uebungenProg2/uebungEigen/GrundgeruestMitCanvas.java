package uebungenProg2.uebungEigen;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrundgeruestMitCanvas extends JFrame
{
    Canvas canvas;

    public GrundgeruestMitCanvas()
    {
        super();
        this.setTitle("GrundgeruestMitCanvas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        this.getContentPane().add(this.initNorth(), BorderLayout.NORTH);
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
        this.getContentPane().add(this.initEast(), BorderLayout.EAST);
        this.getContentPane().add(this.initWest(), BorderLayout.WEST);

        this.setSize(400, 300);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private class Canvas extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen mit folgenden Methoden:
            
            
            g2.setStroke(new BasicStroke(3.0f));  // bestimmt die Zeichenstiftgroesse
            
            
            // Färben 1) - direkt in paintComponent im Canvas
            Random r = new Random();              // Farbe zufällig mischen
        	int rot = r.nextInt(256);
        	int blau = r.nextInt(256);
        	int gruen = r.nextInt(256);
        	g2.setColor(new Color(rot, blau, gruen));  // mischt die Zeichenstiftfarbe und setzt alle 3 Farbkomponenten RGB zufällig
        	
        	
        	// Färben 2) - mittels globaler Variablen
        	Color aktuelleFuellefarbe = Color.WHITE;   // ganz oben im JFrame, d.h. vor dem Konstruktor die globale Variable setzen
        
        	// in paintComponent, Quadrat ist das Objekt des Konstruktors
        	g2.setColor(Quadrat.this.aktuelleFuellfarbe); // nun ist die Q-Zeichenstiftfarbe white!
        	
        	// in die actionPerformed vom ActionListeners des Bottons hängen:
        	Random r = new Random();
            int rotBut = r.nextInt(256);
            int gruenBut = r.nextInt(256);
            int blauBut = r.nextInt(256);
            Quadrat.this.aktuelleFuellfarbe = new Color(rotBut, gruenBut, blauBut);
        
 
            
        	// zum zeichnen eines Quadrates, dessen Größe sich ans Fenster anpasst
        	if(canvasHeight > canvasWidth)    // ist das Fenster schmaler als hoch, orientieren wir uns an der Breite
        	{
        		int linkerAbstand = (int)(canvasWidth * 0.1);		     //linker Abstand soll 10% sein
        		int seiteQuadrat = (int)(canvasWidth * 0.8);             //Quadratseitenlänge soll 80% der FensterBREITE sein
        		int obigerAbstand = (canvasHeight - seiteQuadrat) / 2;   // Abstand nach oben und unten ist gleich, daher mittig
        	
        	// ist das Fenster jedoch breiter als hoch, orientieren wir uns an der Höhe
            else
            	
            	int obigerAbstand = (int)(canvasHeight * 0.1);            //Abstand nach oben soll 10% sein
        		int seiteQuadrat = (int)(canvasHeight * 0.8);             //Quadratseitenlänge soll 80% der FensterHÖHE sein
        		int linkerAbstand = (canvasHeight - seiteQuadrat) / 2;    // Abstand nach links und rechts ist gleich, daher mittig        		
        		
        		// in beiden Fällen: ein leeres Q zeichen
        		g2.drawRect(linkerAbstand, obigerAbstand, seiteQuadrat, seiteQuadrat);
        		
        		// in beiden Fällen: ein ausgemaltes Q zeichnen
        		g2.fillRect(linkerAbstand, obigerAbstand, seiteQuadrat, seiteQuadrat);
        	
        		
        	
    		    
    		    
        	
        	
        	
        }
    }

    private JPanel initNorth() 
    {
        JPanel north = new JPanel();
        // hier das JPanel fuer NORTH befuellen
        return north;
    }

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        // hier das JPanel fuer SOUTH befuellen
        return south;
    }


    private JPanel initEast() 
    {
        JPanel east = new JPanel();
        // hier das JPanel fuer EAST befuellen
        return east;
    }

    private JPanel initWest() 
    {
        JPanel west = new JPanel();
        // hier das JPanel fuer WEST befuellen
        return west;
    }

    public static void main(String[] args) 
    {
        new GrundgeruestMitCanvas();
    }
}
	 

