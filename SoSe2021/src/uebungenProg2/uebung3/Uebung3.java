package uebungenProg2.uebung3;

import javax.swing.JOptionPane;

public class Uebung3 
{
	//input#00
	public static int inputWindow(int min, int max, String message) 
	{
		boolean eingabeOK = false;
		int zahl = 0;
		while (!eingabeOK) //solange die Eingabe falsch ist und das ist sie gleich zu Beginn
		{
			// blenden wir die Anfangsanfrage ein
			String eingabe1 = JOptionPane.showInputDialog(message);
    		try 
		    {
    			zahl = Integer.valueOf(eingabe1); // verstehe nicht was die() macht
    			if(zahl >= min && zahl <= max)  // ist die zahl zw min und max, dann
    			{
    				eingabeOK = true; // dann ok -> verlasse M und return Zahl
    			}
    			else // ansosnten ändere das Anfargenfenster und wiederhole die Schleife
    			{
    				message = "Die Zahl muss zwischen " +min+ " und " +max+ " liegen";
    			}
		    }
		    catch(NumberFormatException e) 
		    {
		    	message = "Die Eingabe war keine Zahl. Bitte eine Zahl eingeben.";
		    }
    	 }// Schleifenende
		 return zahl;
	}
	
	//input#01 wird tatsächlich in main aufgerufen und ruft dann selbst intern input#00 auf
	public static int inputWindow(String message) 
	{
		return inputWindow(Integer.MIN_VALUE, Integer.MAX_VALUE, message);
	}

	public static int division(int divident, int divisor) throws ArithmeticException 
	{
		int quotient = divident/divisor;
		return quotient;
	}
	
	public static void printDivision() 
	{
		int divident = inputWindow("Geben Sie eine Zahl als Divident ein: ");
		
		boolean divisorCheck = false; //true würde bedeuten, dass der Divisor keine Null ist
		
		String messageDivisor = "Geben Sie eine Zahl als Divisor ein: ";
		
		while(!divisorCheck) // Divisor ist 0
		{
			int result = 0; //erzeuge neue lokale Variable, die das Divisionsergebnis auffängt
			int divisor = inputWindow(messageDivisor); //farge erneut nach der Eingabe für Divisor
			
			try 
			{
				result = division(divident, divisor);
				divisorCheck = true; // Schleifenende, da Divisor nicht mehr Null ist.
			} 
			catch (ArithmeticException e) 
			{
				messageDivisor = "Die zweite Zahl, d.h. der Divisor darf nicht Null sein!";
			}
			System.out.println(divident + " geteilt durch " + divisor + " ist " + result + ".");
		}
	}


	public static int quersumme(int pmZahl) 
	{
		int quersumme = 0;
		int ganz = pmZahl;
		
		while(ganz>0)  // solange wie der PM größer als Null ist 
		{
			int rest = ganz % 10;
			quersumme += rest;
			ganz = ganz / 10;
		}
		return quersumme;
	}
	
	
	public static void printUmrechnungSek() 
	{
		int sek = inputWindow("Anzahl Sekunden: "); //sekunden werden über Fenster eingegeben
		int tage = sek/(24*60*60); //Sek durch (Stunden,Minute,Sek)
		int stunden = sek/(60 *60);
		int minuten = sek/ 60;
		int sekunden = sek;   // ist gegeben
		
		String s = sek + " Sekunden sind: ";
		if(tage > 1) 
		{
			s += tage + " Tage, ";
		}
		else if(tage == 1) 
		{
			s += "1 Tag, ";
		}
		if(stunden > 1) 
		{
			s += stunden + " Stunden, ";
		}
		else if(stunden == 1) 
		{
			s += "1 Stunde, ";
		}
		if(minuten > 1) 
		{
			s += minuten + " Minuten, ";
		}
		else if(minuten == 1) 
		{
			s += "1 Minute, ";
		}
		if(sekunden > 1) 
		{
			s += sekunden + " Sekunden, ";
		}
		else if(sekunden == 1) 
		{
			s += "1 Sekunde, ";
		}
		System.out.println(s);
	}
	
	
	

	public static void main(String[] args) 
	{
    
		printDivision();
		int zahlFuerQuersumme = inputWindow("Bitte geben Sie eine Zahl ein um eine Quersumme zu berechnen");
		JOptionPane.showMessageDialog(null, "Quersumme von " + zahlFuerQuersumme + " ist " + quersumme(zahlFuerQuersumme));
	}
}
