package aufgabenProg2.aufgabe1;

import javax.swing.JOptionPane;

public class Spiel 
{
	private Spieler[] spieler;
	public static int punkteZiel;
	
	public Spiel(int punkteZiel, int anzSpieler) 
	{
		Spiel.punkteZiel = punkteZiel;
		this.spieler = new Spieler[anzSpieler];
		for(int i = 0; i<this.spieler.length; i++) 
		{
			this.spieler[i]= new Spieler(JOptionPane.showInputDialog(null, "Name des Spielers " + (i+1)));
		}
	}
	
	public void spielen()
	{
		boolean spiel = false;
		while(!spiel) 
		{
			for(int i = 0; i<this.spieler.length && (!spiel); i++) 
			{
				boolean spielA = spieler[i].wuerfeln();
				if (spielA) 
				{
					JOptionPane.showMessageDialog(null, spieler[i].getName() + " hat das Spiel gewonnen!");
					spiel = true;
				}
			}
		}
	}
}
