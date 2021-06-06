package uebungenProg2.uebung6;

import java.util.*;

public class StadtTest 
{
	// diese Methode (rein kopiert) gibt uns ein 
	// Array zurück bestehend aus lauter Städten:
	public static Stadt[] staedte()
	{
	    Stadt[] staedte = new Stadt[6];
	    List<Integer> berlinBevoelkerung = new ArrayList<>();
	    berlinBevoelkerung.add(3382169);    
	    berlinBevoelkerung.add(3460725);    
	    berlinBevoelkerung.add(3574830);
	    staedte[0] = new Stadt("Berlin", berlinBevoelkerung, 891.68f);

	    List<Integer> hamburgBevoelkerung = new ArrayList<>();
	    hamburgBevoelkerung.add(1715392);   
	    hamburgBevoelkerung.add(1786448);   
	    hamburgBevoelkerung.add(1810438);   
	    staedte[1] = new Stadt("Hamburg", hamburgBevoelkerung, 755.22f);

	    List<Integer> muenchenBevoelkerung = new ArrayList<>();
	    muenchenBevoelkerung.add(1210223);  
	    muenchenBevoelkerung.add(1353186);  
	    muenchenBevoelkerung.add(1464301);
	    staedte[2] = new Stadt("Muenchen", muenchenBevoelkerung, 310.70f);

	    List<Integer> koelnBevoelkerung = new ArrayList<>();
	    koelnBevoelkerung.add(962884);  
	    koelnBevoelkerung.add(1007119); 
	    koelnBevoelkerung.add(1075935); 
	    staedte[3] = new Stadt("Koeln", koelnBevoelkerung, 405.02f);

	    List<Integer> frankfurtBevoelkerung = new ArrayList<>();
	    frankfurtBevoelkerung.add(648550);  
	    frankfurtBevoelkerung.add(679664);  
	    frankfurtBevoelkerung.add(736414);
	    staedte[4] = new Stadt("Frankfurt/Main", frankfurtBevoelkerung, 248.31f);

	    berlinBevoelkerung = new ArrayList<>();
	    berlinBevoelkerung.add(3382169);    
	    berlinBevoelkerung.add(3460725);    
	    berlinBevoelkerung.add(3574830);
	    staedte[5] = new Stadt("Berlin", berlinBevoelkerung, 891.68f);

	    return staedte;
	}
	
	

	
	public static void main(String[] args) 
	{
		
		System.out.printf("%n%n--------------------------------- Listen ---------------------------------%n%n");
		
		
		List<Stadt> unsereListe = new ArrayList<>(); // neuer Liste erzeugen
		
		//Stadt[] staedte = staedte();// Auffangvariable speichert das Staedte-Array, 
		                            // welches aus Listen besteht (Methode steht über main)
		
		//for(Stadt element : staedte) //for-each durchkämt das gesamte Array
		for(Stadt element : staedte())
		{
			unsereListe.add(element); // fügt jedes Array-Element der neuen Liste hinzu
		}
		
		
		//Geben Sie alle Informationen über alle Städte aus der Liste unter 
		// Verwendung der print()-Methode aus der Klasse Stadt aus.
		for(Stadt element : unsereListe) //for-each durchkämt diesmal die neue Liste
		{
			element.print(); // gibt die Info jedes Elementes (d.h. jeder Stadt) aus
		}
		
		
		System.out.printf("%n%n--------------------------------- Mengen ---------------------------------%n%n");
		

		Set<Stadt> unsereMenge = new HashSet<>(); // neue Menge erzeugen
		
		
		for(Stadt element : staedte()) //wie bei Listen
		{
			unsereMenge.add(element); // fügt jedes Array-Element der Menge hinzu
		}
		
		
		for(Stadt element : unsereMenge) //for-each durchkämt diesmal die neue Menge
		{
			element.print(); // gibt die Info jedes Elementes (d.h. jeder Stadt) aus
		}
		
		
		System.out.printf("%n%n--------------------------------- Maps ---------------------------------%n%n");
		

		Map<Integer,Stadt> unsereMap = new HashMap<>(); // neue Map erzeugen
		Integer schluessel = 1;
		
		for(Stadt element : staedte()) // wie bei Listen und Mengen
		{
			unsereMap.put(schluessel, element); // fügt jedes Array-Element der Map als Wert hinzu
			schluessel++;                       // und gibt jedem Wert einen fortlaufenden Schluessel
		}
		
		
		for(Map.Entry<Integer, Stadt> entryElement : unsereMap.entrySet()) //for-each durchkämt diesmal die neue Map mittels entrySet-Methode
		{
			System.out.printf("%-3d" , entryElement.getKey()); // printed den Schluessel
			Stadt wert = entryElement.getValue();             // merkt sich den dazugehörigen Wert
			wert.print();                                     // printed den Wert
		}
		
		
		
		
	}//MK

	
}//KK
