package aufgabenProg2.aufgabe4;

import java.util.*;

public class SingleNumber 
{
	public static int singleNumber(int[] nums) 
	{
		// das Array im PM darf nicht leer sein
		// jede Zahl in nums muss genau 2x vorkommen, ausser eine und die wird ausgegeben.
		
		List<Integer> meineListe = new ArrayList<>();  // erzeuge neue Liste "meineListe"
		final int NOT_FOUND = -1;
		
		for(int element : nums) // geht durch das ganze PM array 
		{
			if(!meineListe.contains(element)) // wenn es noch nicht in meiner Liste ist
			{
				meineListe.add(element); // füge es meiner Liste hinzu
			}
			else 
			{
				meineListe.remove(new Integer(element)); // versteh ich noch nicht
			}
		}
		if(meineListe.size()==0) // falls sie leer ist 
		{
			System.out.println("Keine einzeln vorkommende Zahl wurde gefunden");
			return NOT_FOUND;
		}
		else 
		{
			for(int zaehler = 0; zaehler < meineListe.size(); zaehler++)   // gehe durch meine Liste
			{																//gebe jendes Elemenet auf jedem Index der Liste aus??
				System.out.println(meineListe.get(zaehler));
			}
			return meineListe.get(0);
		}	
	}
	
	
	
	public static void main(String[] args) 
	{
		int [] meinArray = {4,1,5,4,1};
		singleNumber(meinArray);
	}


}
