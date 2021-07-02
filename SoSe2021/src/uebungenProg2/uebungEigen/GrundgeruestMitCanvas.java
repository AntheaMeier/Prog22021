package uebungenProg2.uebungEigen;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
            // hier koennen wir zeichnen
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
	 

