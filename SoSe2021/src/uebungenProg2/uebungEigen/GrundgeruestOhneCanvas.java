package uebungenProg2.uebungEigen;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrundgeruestOhneCanvas extends JFrame{
    JPanel content;

    public GrundgeruestOhneCanvas()
    {
        super();
        this.setTitle("GrundgeruestOhneCanvas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.content = this.initCenter();
        this.getContentPane().add(this.content, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        this.getContentPane().add(this.initNorth(), BorderLayout.NORTH);
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
        this.getContentPane().add(this.initEast(), BorderLayout.EAST);
        this.getContentPane().add(this.initWest(), BorderLayout.WEST);

        this.setSize(400, 300);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private JPanel initCenter() 
    {
        JPanel center = new JPanel();
        // hier das JPanel fuer CENTER befuellen
        return center;
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
        new GrundgeruestOhneCanvas();
    }
}