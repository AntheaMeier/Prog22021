package uebungenProg2.uebungEigen;

import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class IchZeichne extends JFrame 
{

	//Konstruktor
    public IchZeichne()
    {
        super();
        this.setTitle("Wir zeichnen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        //this.getContentPane().add(this.initContent());
        this.getContentPane().add(new Canvas());

        this.setSize(800, 600);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private class Canvas extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g) 
        {
        	super.paintComponent(g); // zeichnet ein graues Recheck
        	Graphics2D g2 = (Graphics2D)g; // importiert g nach Graphics2D um mehr Methoden zur Verfügung zu haben
        	
        	/*
        	g2.drawRect(50, 20, 100, 80);
            g2.drawOval(50, 20, 100, 80);
        	
        	for(int i=0; i<10; i++)
            {
                g2.drawOval(50+i*10, 120, 80, 80);
                g2.drawOval(50+i*10, 220, 80, 180);
            }
            
        	
        	Shape rect = new Rectangle2D.Double(40.0, 30.0, 200.0, 200.0);
        	g2.draw(rect);
        	
        	Shape kreis = new Ellipse2D.Double(40.0, 30.0, 200.0, 200.0);
        	g2.draw(kreis);
        		
    
            Shape arc3 = new Arc2D.Double(60.0, 63.0, 180.0, 180.0, 0.0, 180.0, Arc2D.PIE);
            Shape arc4 = new Arc2D.Double(60.0, 63.0, 180.0, 180.0, 180.0, 180.0, Arc2D.PIE);
            
            g2.setStroke(new BasicStroke(3.0f));
            g2.setColor(Color.RED);
            g2.fill(arc3);
            g2.setColor(Color.BLUE);
            g2.draw(arc4);
            
            
            g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
            g2.drawLine(60, 100, 200, 100);
            
            */
        	
        	int diffX = 200;
            int diffY = 130;
            Color color;
            color = new Color(205,107,117,127);
            g2.setColor(color);
            g2.fillRect(50, 50, 150, 100);

            
            color = new Color(205,107,117,255);
            g2.setColor(color);
            g2.fillRect(50, 50+diffY, 150, 100);
           
            g2.setColor(Color.WHITE);
            g2.fillRect(50, 50+2*diffY, 150, 100);

            color = new Color(100,255,100,127);
            g2.setColor(color);
            g2.fillRect(50+diffX, 50, 150, 100);

            color = new Color(100,255,100,255);
            g2.setColor(color);
            g2.fillRect(50+diffX, 50+diffY, 150, 100);

            g2.setColor(Color.GREEN);
            g2.fillRect(50+diffX, 50+2*diffY, 150, 100);


            color = new Color(100,100,255,127);
            g2.setColor(color);
            g2.fillRect(50+2*diffX, 50, 150, 100);

            color = new Color(100,100,255,255);
            g2.setColor(color);
            g2.fillRect(50+2*diffX, 50+diffY, 150, 100);

            g2.setColor(Color.BLUE);
            g2.fillRect(50+2*diffX, 50+2*diffY, 150, 100);
            
        }
    }

    public static void main(String[] args) 
    {
        new IchZeichne();
    }

}
