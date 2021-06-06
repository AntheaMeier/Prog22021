package uebungenProg2.uebungEigen;

import java.awt.Color;
import javax.swing.JFrame;

public class MyFirstWindow extends JFrame
{
    public MyFirstWindow()
    {
        super();
    	//JFrame window = new JFrame(); -----> erben wir bereits!
        this.setTitle("My first window");  // ------> ohne erben window. anstatt this.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.CYAN);
        this.setSize(400, 300);
        this.setLocation(500,300); // mittig
        this.setVisible(true);
    }

    public static void main(String[] args) 
    {
        new MyFirstWindow();
    }

}

