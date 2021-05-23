package uebungenProg2.uebung5;

import java.util.*;

//Aufgabe 1
public class uebung5 
{
	public static void main(String[] args) 
	{
		//Aufgabe 2
		String[] words = {"Linux", "Apple", "Facebook", "Amazon", "IBM", "Lenovo", 
				"Google", "IBM", "Microsoft", "Apple", "Google", "Twitter", 
				"Skype", "Chrome", "Linux", "Firefox"};

		//Aufgabe A.3
		System.out.printf("%n%n----------------Array-Liste und Ausgabe (Aufgabe A.3)----------------%n%n");
		List<String> listOne = createArrayList(words); //Auffangvariable listOne
		printList(listOne);
		
		
		// Aufgabe A.4
		System.out.printf("%n%n----------------Methoden fuer Listen (Aufgabe A.4)----------------%n%n");
		System.out.println("Index des ersten Auftretens von Apple : " + listOne.indexOf("Apple"));
		System.out.println("Index des letzten Auftretens von Apple : " + listOne.lastIndexOf("Apple"));
		System.out.println("erstes Elemnet der Liste : " + listOne.get(0));
		System.out.println("letztes Elemnet der Liste : " + listOne.get(listOne.size()-1));
		listOne.remove("Apple");
		listOne.remove("Google");
		listOne.remove("Facebook");
		printList(listOne);
		
		//Aufgabe B.3
		System.out.printf("%n%n---------------HashSet und Ausgabe (Aufgabe B.3)----------------%n%n");	
		Set<String> auffangHashSet = createHashSet(words);
		printSet(auffangHashSet);
		
		//Aufgabe B.5
		System.out.printf("%n%n---------------TreeSet und Ausgabe (Aufgabe B.5)----------------%n%n");	
		Set<String> auffangTreeSet = createHashSet(words);
		printSet(auffangTreeSet);
		
		
		//Zusatz
		System.out.printf("%n%n---------------Ausgabe der Doublet-Liste (Aufgabe Zusatz)----------------%n%n");	
		List<String> list2 = createArrayList(words); // macht aus dem words Array eine List
		List<String> catchIt = findDoublets(list2);
		printList(catchIt);
		
	}//MK
	
	
	// Aufagbe: A1
	// In dieser Methode soll eine ArrayList erstellt werden. 
	// Alle Elemente in dieser Liste sind vom Typ String. 
	// Befüllen Sie diese Liste mit allen Wörtern aus dem words-Array. 
	// Die Methode gibt die befüllte Liste zurück.  
	
		public static List<String> createArrayList(String[] words) 
		{
			List<String> meineListe = new ArrayList<>();
			for (int i = 0; i < words.length; i++) 
			{
				meineListe.add(words[i]);
			}
			return meineListe;  
		}
	
		// Aufageb: A.2 
		// Diese Methode gibt alle Elemente der Liste im PM auf der Konsole aus 
		// und die Anzahl der Elemente dieser Liste. 
		
		public static void printList(List<String> listPM) 
		{	
			System.out.println("Liste mit " + listPM.size() + " Elementen:");
			System.out.println("----------------------------");
			
			Iterator<String> it = listPM.iterator();
			while(it.hasNext()) 
			{
				System.out.println(it.next());
			}
			
			/*for(String wordElement : words)   -> ACHTUNG: Foreach geht hier nicht da das Array words nicht im PM übergeben wurde, daher unbekannt!
			{
				System.out.println(wordElement);
			}*/
		}
		
		// Aufagbe: B1
		// In dieser Methode soll ein HashSet erstellt werden. 
		// Alle Elemente in dieser Menge sind vom Typ String. 
		// Befüllen Sie diese Liste mit allen Wörtern aus dem words-Array. 
		// Die Methode gibt die befüllte Menge zurück. 
		public static Set<String> createHashSet(String[] words)
		{
			Set<String> meinSet = new HashSet<>();
			for(String wordElement : words)
			{
				meinSet.add(wordElement); // hoffe das falls Element bereits drinnen, dann wird es eben übersprungen
			}
			/*
			 Alternativ:
			 for(int i = 0; i<words.length; i++)
			 {
			     meinSet.add(words[i]);
			 }
			 */
			return meinSet;
		}
		
		// Aufageb: B.2 
		// Diese Methode gibt alle Elemente der Menge im PM auf der Konsole aus 
		// und die Anzahl der Elemente dieser Menge. 
		
		public static void printSet(Set<String> setPM) 
		{	
			for(String element : setPM) 
			{
				System.out.println(element);
			}
			System.out.println("Die Menge hat " + setPM.size() + " Elemente.");
		}
		
		// Aufagbe: B4
		// In dieser Methode soll ein TreeSet erstellt werden. 
		// Alle Elemente in dieser Menge sind vom Typ String. 
		// Befüllen Sie diese Liste mit allen Wörtern aus dem words-Array. 
		// Die Methode gibt die befüllte Menge zurück. 
		
		public static Set<String> createTreeSet(String[] words)
		{
			Set<String> meinSet = new TreeSet<>();
			for(int i = 0; i<words.length; i++)
			{
		        meinSet.add(words[i]);
		    }
			return meinSet;
			 
		}
		
	    //Zusatz: Erstellen Sie für die Liste eine Methode public static List<String> findDoublets(List<String> list). 
	    //Diese Methode erstellt eine Liste, in der alle Elemente enthalten sind, die in list doppelt vorkommen. 
	    //Diese Elemente werden dann auch doppelt in die Resultat-Liste übernommen.
				
		public static List<String> findDoublets(List<String> listPM)
		{
			/*prüfe ob element in pm bereits doppelt
			
			-> Grundidee 
	        Beispiel-Liste: "a" "b" "a" "c" "a"

	        Index:  0 1 2 3 4
	        Inhalt: a b a c a

	        erster Index von "a": 0
	        letzter Index von "a":4 
	        0 != 4 -> es gibt Duplikate 
	        erster Index von "b":1
	        letzter Index von "b":1
	        1 == 1 -> keine Duplikate, also diesen Eintrag als Einzeleintrag merken
	        */
			
			List<String> listSingles = new ArrayList<>();
			
			Iterator<String> it = listPM.iterator();
			while(it.hasNext()) 
			{
				String s = it.next();
				if(listPM.indexOf(s) == listPM.lastIndexOf(s)) // sind erster und letzter Index gleich, gibt es keine Dopplung
				{
					listSingles.add(s); // beide Indizes sind gleich, also in die Singels-Liste
				}
			}
			List<String> listDoublets = new ArrayList<>();
			it = listPM.iterator();                          // was passiert hier? weshalb wiederholen?
			while(it.hasNext()) 
			{
				listDoublets.add(it.next());         // hier wird jedes Element auf der PM-List in Doublets hinzugefügt
			}
			listDoublets.removeAll(listSingles);
			return listDoublets;
		}	
		
	
	
	
	


}//KK
