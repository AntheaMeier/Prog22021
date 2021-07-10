package Klausurenprep;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.*;


public class Quadrat extends JFrame implements MouseListener, MouseMotionListener
{
    Canvas canvas;
    boolean zeigeQuadrat = false;
    boolean fuelleQuadrat = false;
    Color aktuelleFuellfarbe = Color.WHITE;
    int linkerAbstand, rechterAbstand, obererAbstand, untererAbstand, seitenLaenge;
    boolean bewegt = false;
    boolean rechteKante = false;
    boolean linkeKante = false;
    boolean obereKante = false;
    boolean untereKante = false;
    int warX = 0;
    int warY = 0;		
    		

    public Quadrat()
    {
        super();
        this.setTitle("GrundgeruestMitCanvas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);
        this.canvas.addMouseMotionListener(this);
        
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
            	g2.setColor(Quadrat.this.aktuelleFuellfarbe);
            	
            	// zum Füllen des willkürlich eingefärbten Quadartes wird wegen der globalen Variablen direkt 
            	// an den ActionListener des new Button gehängt
            	// Random r = new Random();
            	// int rot = r.nextInt(256);
            	// int blau = r.nextInt(256);
            	// int gruen = r.nextInt(256);
            	// g2.setColor(new Color(rot, blau, gruen));
            	
            	int canvasWidth = this.getWidth();
            	int canvasHeight = this.getHeight();
            	
            	
            	if (!Quadrat.this.bewegt)  // für MouseListener 
            	{
                	// zum zeichnen und füllen des Quadartes
                	if(canvasHeight > canvasWidth)                // ist das Fenster schmaler als hoch, orientieren wir uns an der Breite
                	{
                		//Punkte im Koordinatensystem
                		Quadrat.this.linkerAbstand = (int)(canvasWidth * 0.1);		     //linker Abstand soll 10% sein
                		Quadrat.this.seitenLaenge = (int)(canvasWidth * 0.8);             //Quadratseitenlänge soll 80% der FensterBREITE sein
                		Quadrat.this.rechterAbstand = Quadrat.this.linkerAbstand + Quadrat.this.seitenLaenge;
                		Quadrat.this.obererAbstand = (canvasHeight - Quadrat.this.seitenLaenge) / 2;   // Abstand nach oben und unten ist gleich, daher mittig
                		
                		//zum befüllen
                		if(fuelleQuadrat) 
                		{
                			g2.fillRect(Quadrat.this.linkerAbstand, Quadrat.this.obererAbstand, Quadrat.this.seitenLaenge, Quadrat.this.seitenLaenge);
                		}
                		
                		//nur zum Randzeichnen des leeren Q
                		g2.setColor(Color.BLACK);
                		g2.drawRect(Quadrat.this.linkerAbstand, Quadrat.this.obererAbstand, Quadrat.this.seitenLaenge, Quadrat.this.seitenLaenge);
                	}
                	else   // ist das Fenster breiter als hoch, orientieren wir uns an der Höhe
                	{
                		Quadrat.this.obererAbstand = (int)(canvasHeight * 0.1);		        //Abstand nach oben soll 10% sein
                		Quadrat.this.seitenLaenge = (int)(canvasHeight * 0.8);             //Quadratseitenlänge soll 80% der FensterHÖHE sein
                		Quadrat.this.rechterAbstand = Quadrat.this.linkerAbstand + Quadrat.this.seitenLaenge; //bleibt unverändert
                		Quadrat.this.linkerAbstand = (canvasHeight - Quadrat.this.seitenLaenge) / 2;   // Abstand nach links und rechts ist gleich, daher mittig
                		
                		//zum befüllen
                		if(fuelleQuadrat) 
                		{
                			g2.fillRect(Quadrat.this.linkerAbstand, Quadrat.this.obererAbstand, Quadrat.this.seitenLaenge, Quadrat.this.seitenLaenge);
                		}
                		
                		//nur zum Randzeichnen des leeren Q
                		g2.setColor(Color.BLACK);
                		g2.drawRect(Quadrat.this.linkerAbstand, Quadrat.this.obererAbstand, Quadrat.this.seitenLaenge, Quadrat.this.seitenLaenge);
                	}
            	}
            	else // bewegt -> für MouseListener
            	{
            		if(fuelleQuadrat) 
            		{
            			g2.fillRect(Quadrat.this.linkerAbstand, Quadrat.this.obererAbstand, Quadrat.this.seitenLaenge, Quadrat.this.seitenLaenge);
            		}
            		
            		//nur zum Randzeichnen des leeren Q
            		g2.setColor(Color.BLACK);
            		g2.drawRect(Quadrat.this.linkerAbstand, Quadrat.this.obererAbstand, Quadrat.this.seitenLaenge, Quadrat.this.seitenLaenge);
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
				
        		JButton thisBtn = (JButton)e.getSource();  // kann nur der newBtn sein!
        		
        		if(thisBtn.getText().equals("new"))  // wurde der "new" Button geklickt?
        		{
        			Quadrat.this.zeigeQuadrat = true;
            		thisBtn.setText("refresh");
        		}
        		Random r = new Random();
        		int rotBut = r.nextInt(256);
                int gruenBut = r.nextInt(256);
                int blauBut = r.nextInt(256);
                Quadrat.this.aktuelleFuellfarbe = new Color(rotBut, gruenBut, blauBut);
            	
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


    @Override
	public void mousePressed(MouseEvent e) 
	{
		int x = e.getX();
		int y = e.getY();
		System.out.println("mousePressed x = " + x + ", y = " + y);
		
		int linksX = this.linkerAbstand;
		int rechtsX = this.rechterAbstand;
		int obenY = this.obererAbstand;
		int untenY = this.untererAbstand;
		
		if(x > linksX-10 && x < linksX+10)
		{
			this.bewegt = true;
			this.linkeKante = true;
			this.warX = x;
		}	
		else if(x > rechtsX-10 && x < rechtsX+10)
		{
			this.bewegt = true;
			this.rechteKante = true;
			this.warX = x;
		}
		else if(y > obenY-10 && y < obenY+10)
		{
			this.bewegt = true;
			this.obereKante = true;
			this.warY = y;
		}
		else if(y > untenY-10 && y < untenY+10)
		{
			this.bewegt = true;
			this.untereKante = true;
			this.warY = y;
		}
	}
    

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		int x = e.getX();
		int y = e.getY();
		System.out.println("mouseDragged x = " + x + ", y = " + y);
		
		if(this.linkeKante) 
		{
			int diffX = x - this.warX;
			this.linkerAbstand = this.linkerAbstand + diffX;
			this.obererAbstand = this.obererAbstand + diffX;
			this.seitenLaenge = this.seitenLaenge - 2 * diffX;
			this.warX = x;
		}
		else if(this.rechteKante) 
		{
			int diffX = x - this.warX;
			this.linkerAbstand = this.linkerAbstand - diffX;
			this.obererAbstand = this.obererAbstand - diffX;
			this.seitenLaenge = this.seitenLaenge + 2 * diffX;
			this.warX = x;
		}
		else if(this.obereKante) 
		{
			int diffY = y - this.warY;
			this.linkerAbstand = this.linkerAbstand + diffY;
			this.obererAbstand = this.obererAbstand + diffY;
			this.seitenLaenge = this.seitenLaenge - 2 * diffY;
			this.warY = y;
		}
		else if(this.untereKante) 
		{
			int diffY = y - this.warY;
			this.linkerAbstand = this.linkerAbstand - diffY;
			this.obererAbstand = this.obererAbstand - diffY;
			this.seitenLaenge = this.seitenLaenge + 2 * diffY;
			this.warY = y;
		}
		Quadrat.this.canvas.repaint();
	}


	@Override
	public void mouseReleased(MouseEvent e) 
	{
		this.bewegt = false;
		Quadrat.this.canvas.repaint();
		
		//vor der letzten Anpassung:
		//int x = e.getX();
		//int y = e.getY();
		//System.out.println("mouseReleased x = " + x + ", y = " + y);
	}


	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}




	

}
