package uebungenProg2.uebungEigen;

import java.awt.*;
import java.awt.event.*;  // decktnMouseListener und MouseMotionListener mit ab

import javax.swing.*;

public class MouseEvents extends JFrame implements MouseListener, MouseMotionListener
{
	Canvas canvas; // die Speichervariable für den MouseListener
	
	
	//Konstruktor:
	public MouseEvents()
    {
        super();
        this.setTitle("Mausereignisse");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);    // hier wird this.canvas beim MouseListener angemeldet
        this.canvas.addMouseMotionListener(this); 
        this.getContentPane().add(this.canvas);
        
       
        //this.getContentPane().add(new Canvas());     ohne MouseListener bzw ohne globale Speichervariable canvas

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
            // hier koennen wir zeichnen
        }
    }

    public static void main(String[] args) 
    {
        new MouseEvents();
    }

    
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//System.out.println("mit Maus geklickt");
		
		Point p = e.getPoint();
		int x = e.getX();
		int y = e.getY();
		System.out.println(" Maus wurde geklickt bei [x=" + p.x + ", y=" + p.y + "]");
		System.out.println(" Maus wurde geklickt bei [x=" + x + ", y=" + y + "]");
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		System.out.println("linke Maustaste wird gerade gedrückt");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		System.out.println("losgelassen");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		System.out.println("die Maus betritt");
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		System.out.println("die Maus is weg");
		
	}


	@Override
	public void mouseDragged(MouseEvent e) 
	{
		//System.out.println("die Maus bewegt sich im Fenster mit gedrückter LM-Taste"); funktioniert aber  __too much!
		
	}


	@Override
	public void mouseMoved(MouseEvent e) 
	{
		//System.out.println("die Maus bewegt sich im Fenster");  funktioniert aber  __too much!
		
	}

}
