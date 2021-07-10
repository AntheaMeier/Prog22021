package Klausurenprep;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormenZeichnen extends JFrame
{
   Canvas zeichenfeld;
   
   boolean zeigeQuadrat = false;
   boolean zeigeKreis = false;
   boolean zeigeRechteckLiegend = false;
   boolean zeigeRechteckStehend = false;
   boolean zeigeHalbkreis = false;
   boolean zeigeOval = false;
   boolean zeigeDreieck = false;
   

   public FormenZeichnen()
   {
       super();
       this.setTitle("Formen zeichnen");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

       JPanel norden = this.initNorden();
       this.getContentPane().add(norden, BorderLayout.NORTH);
       this.zeichenfeld = new Canvas();
       this.getContentPane().add(this.zeichenfeld, BorderLayout.CENTER);

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
           // hier koennen wir zeichnen:
           
           g2.setStroke(new BasicStroke(3.0f)); // Stiftstärke
           
           int canvasWidth = this.getWidth(); // um die Formen an ein Fenstergröße anzupassen
           int canvasHeight = this.getHeight();
           int seiteQuadrat;
           int abstandX; //Abstand rechts links
           int abstandY;  //Abstand oben unten
           int kreisDurchmesser;
           int widthRechteck;
           int heightRechteck;
           
           if(FormenZeichnen.this.zeigeQuadrat)
           {
               if(canvasHeight > canvasWidth) // falls das Fenster höher d.h schmal ist
               {
               	   seiteQuadrat = (int)(canvasWidth * 0.8);
               	   //abstandX = (int)(canvasWidth * 0.1);
                   //abstandY = (canvasHeight - seiteQuadrat) / 2;
               	   abstandX = (canvasWidth - seiteQuadrat) / 2;
               	   abstandY = (canvasHeight - seiteQuadrat) / 2;
               }
               else   // falls das Fenster breiter ist
               {
               		seiteQuadrat = (int)(canvasHeight * 0.8);
               		//abstandX = (canvasWidth - seiteQuadrat) / 2;
               		//abstandY = (int)(canvasHeight * 0.1);
               		abstandX = (canvasWidth - seiteQuadrat) / 2;
                   	abstandY = (canvasHeight - seiteQuadrat) / 2;
               }
               g2.drawRect(abstandX, abstandY, seiteQuadrat, seiteQuadrat);
           }
           
           
           else if(FormenZeichnen.this.zeigeRechteckLiegend) // ein liegendes Rechteck
           {
           	if(canvasHeight > canvasWidth) 
           	{
           		widthRechteck = (int)(canvasWidth * 0.8);
           		heightRechteck = (widthRechteck/2);
           		abstandX = (canvasWidth - widthRechteck) / 2;
                abstandY = (canvasHeight - heightRechteck) / 2;
           	}
           	else 
           	{
           		widthRechteck = (int)(canvasHeight * 0.8);
           		heightRechteck = (widthRechteck/2);
           		abstandX = (canvasWidth - widthRechteck) / 2;
                abstandY = (canvasHeight - heightRechteck) / 2;
           	}
           	g2.drawRect(abstandX, abstandY, widthRechteck, heightRechteck);	
           }
           
           
           else if(FormenZeichnen.this.zeigeRechteckStehend) // ein hochkant stehendes Rechteck
           {
           	if(canvasHeight > canvasWidth) 
           	{
           		heightRechteck = (int)(canvasWidth * 0.8);
           		widthRechteck = (heightRechteck/2);
           		abstandX = (canvasWidth - widthRechteck) / 2;
                   abstandY = (canvasHeight - heightRechteck) / 2;
           	}
           	else 
           	{
           		heightRechteck = (int)(canvasHeight * 0.8);
           		widthRechteck = (heightRechteck/2);
           		abstandX = (canvasWidth - widthRechteck) / 2;
                   abstandY = (canvasHeight - heightRechteck) / 2;
           		
           	}
           	g2.drawRect(abstandX, abstandY, widthRechteck, heightRechteck);	
           }
           
           
           
           else if(FormenZeichnen.this.zeigeKreis) 
           {
           	if(canvasHeight > canvasWidth) 
           	{
           		kreisDurchmesser = (int)(canvasWidth * 0.8);
           		abstandX = (int)(canvasWidth * 0.1);
                abstandY = (canvasHeight - kreisDurchmesser) / 2;
           	}
           	else 
           	{
           		kreisDurchmesser = (int)(canvasHeight * 0.8);
           		abstandX = (canvasWidth - kreisDurchmesser) / 2;
                abstandY = (int)(canvasHeight * 0.1);
           	}
           	g2.drawOval(abstandX, abstandY, kreisDurchmesser, kreisDurchmesser);	
           }
       }
   }

   private JPanel initNorden() 
   {
   	JPanel norden = new JPanel();
   	norden.setLayout(new BorderLayout());
   	
       JPanel oben = new JPanel();
       //oben.setLayout(new GridLayout(2, 3)); // das funktioniert, möchte ich aber nicht verwenden
       
       //////////////////////////////////////////////////
       /////////////////////////////////////////////////
       ////////// HIER LIEGT DAS PROBLEM ///////////////
       ////////////////////////////////////////////////
       
       oben.setLayout(new FlowLayout()); // funktioniert leider nicht!!!!
       
       JButton buttonQ = new JButton("Quadrat");
       JButton buttonK = new JButton("Kreis");
       JButton buttonRL = new JButton("RechteckLiegend");
       JButton buttonRS = new JButton("RechteckStehend");
       JButton buttonO = new JButton("Oval");
       JButton buttonH = new JButton("Halbreis");
       JButton buttonD = new JButton("Dreieck");

       buttonQ.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) 
           {
           	   FormenZeichnen.this.zeigeQuadrat = true;
               JButton loeschen = (JButton)e.getSource();  // überschreibt den Button buttonQ
               loeschen.setText("löschen");
               FormenZeichnen.this.zeichenfeld.repaint(); // versteh ich noch nicht ganz, ohne das wird nix gezeichnet!
           }

       });
      

       buttonK.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) 
           {
           	   FormenZeichnen.this.zeigeKreis = true;
               JButton loeschen = (JButton)e.getSource();  // überschreibt den Button button
               loeschen.setText("löschen");
               FormenZeichnen.this.zeichenfeld.repaint(); // versteh ich noch nicht ganz, ohne das wird nix gezeichnet!
           }

       });
       
       
       buttonRL.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) 
           {
        	   FormenZeichnen.this.zeigeRechteckLiegend = true;
               JButton loeschen = (JButton)e.getSource();  // überschreibt den Button buttonRL
               loeschen.setText("löschen");
               FormenZeichnen.this.zeichenfeld.repaint(); // versteh ich noch nicht ganz, ohne das wird nix gezeichnet!
           }
       });
       
       buttonRS.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) 
           {
        	   FormenZeichnen.this.zeigeRechteckStehend = true;
               JButton loeschen = (JButton)e.getSource();  // überschreibt den Button buttonRS
               loeschen.setText("löschen");
               FormenZeichnen.this.zeichenfeld.repaint(); // versteh ich noch nicht ganz, ohne das wird nix gezeichnet!
           }
       });

       oben.add(buttonRL);
       oben.add(buttonRS);
       oben.add(buttonQ);
       oben.add(buttonK);
       
       oben.add(buttonH);
       oben.add(buttonO);
      
       oben.add(buttonD);
       
       
       
       norden.add(oben, BorderLayout.NORTH);
        
       return norden;
   }
   
  

   private JPanel initSueden() 
   {
       JPanel sueden = new JPanel();
       // hier das JPanel fuer SOUTH befuellen
       
       return sueden;
   }


   
   
   public static void main(String[] args) 
   {
       new FormenZeichnen();
   }
} 
