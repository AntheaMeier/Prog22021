package Klausurenprep;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Quadrat extends JFrame 
{
    Canvas canvas;
    boolean zeigeQuadrat = false;
    boolean fuelleQuadrat = false;

    public Quadrat()
    {
        super();
        this.setTitle("GrundgeruestMitCanvas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);

        this.setSize(500, 500);
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
            
            if(Quadrat.this.zeigeQuadrat) 
            {
            	g2.setStroke(new BasicStroke(3.0f));
            	int canvasWidth = this.getWidth();
            	int canvasHeight = this.getHeight();
            	
            	// zum Füllen des willkürlich eingefärbten Quadartes
            	
            	Random r = new Random();
            	int rot = r.nextInt(256);
            	int blau = r.nextInt(256);
            	int gruen = r.nextInt(256);
            	g2.setColor(new Color(rot, blau, gruen));
            	
            	
            	// zum zeichnen und füllen des Quadartes
            	if(canvasHeight > canvasWidth)
            	{
            		int abstand = (int)(canvasWidth * 0.1);
            		int seiteQuadrat = (int)(canvasWidth * 0.8);
            		int oben = (canvasHeight - seiteQuadrat) / 2;
            		
            		//zum befüllen
            		if(fuelleQuadrat) 
            		{
            			g2.fillRect(abstand, oben, seiteQuadrat, seiteQuadrat);
            		}
            		
            		//nur zum Randzeichnen des leeren Q
            		g2.setColor(Color.BLACK);
            		g2.drawRect(abstand, oben, seiteQuadrat, seiteQuadrat);
            	}
            	else 
            	{
            		int abstand = (int)(canvasWidth * 0.1);
            		int seiteQuadrat = (int)(canvasWidth * 0.8);
            		int links = (canvasHeight - seiteQuadrat) / 2;
            		
            		//zum befüllen
            		if(fuelleQuadrat) 
            		{
            			g2.fillRect(links, abstand, seiteQuadrat, seiteQuadrat);
            		}
            		
            		//nur zum Randzeichnen des leeren Q
            		g2.setColor(Color.BLACK);
            		g2.drawRect(links, abstand, seiteQuadrat, seiteQuadrat);
            	}
            	
            }
        }
    }

   

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        // hier das JPanel fuer SOUTH befuellen
        
        //für das leere Q
        JButton newBtn = new JButton("new");
        newBtn.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Quadrat.this.zeigeQuadrat = true;
        		JButton thisBtn = (JButton)e.getSource();  // kann nur der newBtn sein!
        		thisBtn.setText("refresh");
        		Quadrat.this.canvas.repaint();
			
			}
        });
        
        
      //für das leere Q
        JButton fillBtn = new JButton("fill");
        fillBtn.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
        		JButton thisBtn = (JButton)e.getSource();  
        		if(thisBtn.getText().equals("fill")) 
        		{
        			Quadrat.this.fuelleQuadrat = true;
            		thisBtn.setText("unfill");
        		}
        		else
        		{
        			Quadrat.this.fuelleQuadrat = false;
            		thisBtn.setText("fill");
        		}
        		Quadrat.this.canvas.repaint();
			}
        });
        
        
        south.add(newBtn);
        south.add(fillBtn);
        
        return south;
    }


   

    public static void main(String[] args) 
    {
        new Quadrat();
    }




	

}
