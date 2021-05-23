package aufgabenProg2.aufgabe5;

import java.util.*;

public class SetOperations 
{
	Set<Integer> numbers1;
	Set<Integer> numbers2;
	Set<Integer> both;
	//final static int hundertAlsInt = 100;
	
	public SetOperations() 
	{
		this.numbers1 = new TreeSet<>();
		this.numbers2 = new TreeSet<>();
		this.both = new TreeSet<>();
	}
	
	public void fill() 
	{
		for (int i = 0; i < 100; i++) 
		{
			Random r = new Random();
			this.numbers1.add(Integer.valueOf(r.nextInt(100)));
			this.numbers2.add(Integer.valueOf(r.nextInt(100)));
			
			// Dies Zufallszahl zw. 0-99 wird zunächst in ein Integer-Objekt 
			// umgewandelt mittels Integer.valueOf(zz) und 
			// dieses Integer-Objekt wird dann dem Set hinzugefügt 
			// (wenn es nicht schon enthalten ist), da Mengen keine Dopplungen
			// enthalten und automatisch nur Neuartiges adden.
		}
	}
	
	// In dieser Methode wird die both-Menge derart befüllt, dass both 
	// einer Vereinigung der Mengen numbers1 und numbers2 entspricht.
	public void fillBothUnion() 
	{
		this.both.addAll(numbers1);
		this.both.addAll(numbers2);
	}
		
	
	// In dieser Methode wird die both-Menge derart befüllt, 
	// dass both einem Schnitt der Mengen numbers1 und numbers2 
	// entspricht.
	public void fillBothIntersection() 
	{
		this.both.clear();
		this.both.addAll(numbers1);
		this.both.retainAll(numbers2);
	}
		
	
	
	// In dieser Methode wird die both-Menge derart befüllt, dass 
	// both der Differenz der Menge numbers1 minus der Menge 
	// numbers2 entspricht. 
	public void fillBothDifference() 
	{
		this.both.addAll(numbers1);
		this.both.removeAll(numbers2);
	}
	
	
	// eine Methode print() so, dass jede Menge als ein Quadrat (10x10) 
	// aus Punkten auf der Konsole erscheint. Es wird ein Punkt 
	// gezeichnet, wenn die entsprechende Zahl (die 100 Punkte bilden 
	// die Zahlen 0..99 ab) in der Menge enthalten ist und es wird kein 
	// Punkt gezeichnet, wenn die Zahl nicht vorhanden ist. (Anstelle 
	// von Punkten können Sie auch jedes beliebige Zeichen 
	// (o, *, #, x, ...) verwenden). Gestalten Sie die Ausgabe so, 
	// dass die drei Mengen numbers1, numbers2 und both nebeneinander 
	// auf der Konsole erscheinen. 
	
	
	
	public void print() 
	{
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehlerBoth = 0;
		for (int i = 0; i < 10; i++) // i fuer Row und j fuer Collumn
		{
			for (int j = 0; j < 10; j++)  // 1.Spalte
			{
				if(this.numbers1.contains(Integer.valueOf(zaehler1))) 
				{
					//System.out.printl( versteh ich noch nicht ->u25cf);
				}
				else
				{
					//System.out.printl( versteh ich noch nicht ->u2009);
				}
				zaehler1++;
			}
			printSpaces(5);
			
			for (int j = 0; j < 10; j++) //2.Spalte
			{
				if(this.numbers2.contains(Integer.valueOf(zaehler2))) 
				{
					//System.out.printl( versteh ich noch nicht ->u25cf);
				}
				else
				{
					//System.out.printl( versteh ich noch nicht ->u2009);
				}
				zaehler2++;
			}
			printSpaces(5);
			
			for (int j = 0; j < 10; j++) // 3.Spalte
			{
				if(this.both.contains(Integer.valueOf(zaehlerBoth))) 
				{
					//System.out.printl( versteh ich noch nicht ->u25cf);
				}
				else
				{
					//System.out.printl( versteh ich noch nicht ->u2009);
				}
				zaehlerBoth++;
			}
			System.out.println(); //fertig
			
		}
		
	}
	
	
	private void printSpaces(int nrOfSpaces) 
	{
		for (int i = 0; i < nrOfSpaces; i++) 
		{
			System.out.print(" ");
		}
	}
	
}//KK
	

