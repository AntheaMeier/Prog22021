package aufgabenProg2.aufgabe6;

import java.util.*;

public class PizzaMenu 
{
	// diese Methode testet, ob eine eingegebene Pizza(pizza im PM) 
	// im Menü(menuMap im PM) existiert:
	public static boolean existingPizza(Map<String,Double> menuMap, String pizza) 
	{
		if(menuMap.containsKey(pizza)) 
		{
			return true;
		}
		return false;
	}
	
	/* diese gibt für eine eingegebene Pizza den Preis aus */
	public static void printPrice(Map<String,Double> menuMap, String pizzaPM)
	{
		if(existingPizza(menuMap, pizzaPM)) 
		{
			System.out.println(pizzaPM + ": " + menuMap.get(pizzaPM));
		}
		else
		{
			System.out.println(pizzaPM + ": Diese Pizza gibt es nicht.");
		}		
	}
	/* Schreiben Sie eine Methode, die ausgibt wie viele Pizzen es im Menü gibt. 
	 * und falls das Menü nicht leer ist, werden alle Pizzen mit ihrem Preis ausgegeben */
	public static void printMenu(Map<String, Double> menuMap) 
	{
		System.out.printf("%n########################%n%n");
		System.out.printf("Das Menu enthält " + menuMap.size() +" Pizzen.%n%n");
		if(menuMap.isEmpty()) 
		{
			System.out.println("########################");
		}
		for(Map.Entry<String, Double> element : menuMap.entrySet()) 
		{
			System.out.printf("Pizza " + element.getKey() + ": " + element.getValue() + " Euro%n");
		}
		System.out.println("########################");
	}
	
	/*eine Methode, die alle Pizzen ausgibt, die man sich für einen 
	 * bestimmten Betrag leisten kann.*/
	public static void affordablePizza(Map<String,Double> menuMap, double maxPrice) 
	{
		Set<String> pizzenAffordable = new HashSet<>();
		System.out.println("Eingegebener Betrag: " + maxPrice + " Euro"); 
		for(Map.Entry<String, Double> element : menuMap.entrySet()) 
		{
			if(element.getValue() <= maxPrice) 
			{
				pizzenAffordable.add(element.getKey());
			} 
			if(pizzenAffordable.isEmpty()) 
			{
				System.out.println("Leider gibt es zu diesem Preis keine Pizza.");
			}
			else
			{
				System.out.println("Mögliche Pizzen: " + pizzenAffordable);   //z.B.: "Mögliche Pizzen: [Margherita, Veggie]"
			}
		}
	}
	
	

	public static void main(String[] args) 
	{
		// eine Hshmap erzeugen und mit Pizzen/Preisen befüllen
		Map<String, Double> pizzaMap = new HashMap<>(); // neue Map erzeugen
		pizzaMap.put("Margherita", 7.0);
		pizzaMap.put("Veggie", 7.5);
		pizzaMap.put("Salami", 8.5);
		pizzaMap.put("Schinken", 8.5);
		printMenu(pizzaMap); // erstmalig ausgeben
		
		//obige Methoden testen:
		printPrice(pizzaMap, "Veggi");
		printMenu(pizzaMap); // nach der Änderung nochma ausgeben
		affordablePizza(pizzaMap, 3.0);
		affordablePizza(pizzaMap, 7.0);


		
		// Ändern Sie den Preis der Schinken-Pizza in der HashMap zu 8,20:
		pizzaMap.put("Schinken", 8.2);
		
		// Das Menu wird überarbeitet, alle Einträge löschen und mit neuen Pizzen befüllen:
		pizzaMap.clear();
		pizzaMap.put("Verde", 7.0);
		pizzaMap.put("Hawaii", 8.2);
		pizzaMap.put("Tradizionale", 8.5);
		
		
		// ein zweites Menü anlegen, dazu alle Einträge aus dem ersten Menü kopieren 
		// und die Pizza Hawaii löschen. Dann alle Namen der noch verfügbaren Pizzen ausgeben:
		Map<String, Double> pizzaMap2 = new HashMap<>(); // neue Map erzeugen
		pizzaMap2.putAll(pizzaMap);
		pizzaMap2.remove("Hawaii");
		printMenu(pizzaMap2); // erstmalig die zweite HashMap ausgeben		
	}
}
