package aufgabenProg2.aufgabe1;

import java.util.Random;

import javax.swing.JOptionPane;

public class Spieler 
{
	private String name;
	private int spielstand;
	private Random r;
	
	public Spieler (String name) 
	{
		this.name = name;
		this.spielstand = 0;
		this.r = new Random();
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public boolean wuerfeln() // Versuch
	{
		int aktuelleRunde = 0;
		System.out.println();
		System.out.println("Spieler " + this.name + " ist an der Reihe (bisheriger Spielstand: " + this.spielstand + " Punkte");
		System.out.println("-------------------------------------------------------------------------------------------------");
		while(JOptionPane.showConfirmDialog(null, this.name + " Wollen Sie weiter wuerfeln?" , "Weiter wuerfeln", aktuelleRunde) == JOptionPane.YES_OPTION) 
		{
			int wurfErgebnis = this.r.nextInt(6)+1;
			System.out.println(this.name + " hat eine " + wurfErgebnis + "gewuerfelt");
			if((this.spielstand + aktuelleRunde) >= Spiel.punkteZiel) 
			{
				this.spielstand += aktuelleRunde;
				System.out.println(this.name + " hat insgesamt " + this.spielstand + " Punkte und somit gewonnen!!");
				return true;
			}
			else
			{
				System.out.println(this.name + " hat eine 6 gewuerfelt -- Versuch zu Ende");
				System.out.println("Aktueller Spielstand von " + this.name + " : " + this.spielstand + " Punkte");
				System.out.println("Der naechste Spieler ist dran");
				return false;
			}	
		}
		this.spielstand += aktuelleRunde;
		return false;
	}
	

}
