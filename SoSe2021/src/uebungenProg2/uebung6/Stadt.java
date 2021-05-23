package uebungenProg2.uebung6;

import java.util.*;

public class Stadt implements Comparable
{
	String name;
	List<Integer> bevoelkerung;
	float flaeche;
	
	// geht erstma so, aber eigentlich handelt es sich um eine Kindklasse und da sollte zuerst dei Elternklasse explizit aufgerufen werden
	public Stadt(String name, List<Integer> bevoelkerung, float flaeche) 
	{
		this.bevoelkerung = bevoelkerung;
		this.name = name;
		this.flaeche = flaeche;
	}
	// eine print()-Methode, 
	//so dass eine Ausgabe auf der Konsole in folgender Form erscheint (Bsp.): 
    //Berlin     891,68 km2    3.382.169   3.460.725   3.574.830
	//d.h. Namen der Stadt, ihre Fläche und "km2" und dann alle Bevoelkerungselemente die in der Liste sind
	public void print() 
	{
		System.out.printf("%-15s, %9.2f km2 ", this.name, this.flaeche);
		for(Integer element : this.bevoelkerung)
        {
            System.out.printf("%, 10d", element);
        }
		System.out.println();
	}

	
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
 
}
