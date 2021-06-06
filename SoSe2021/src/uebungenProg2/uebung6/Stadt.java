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
		System.out.printf("%-15s %9.2f km2 ", this.name, this.flaeche);
		for(Integer element : this.bevoelkerung)
        {
            System.out.printf("%, 10d", element);
        }
		System.out.println();
	}

	@Override // wichtig damit keine Dopplung in Mengen
	 public boolean equals(Object o)
	 {
		if(o == null) return false;
	    if(this == o) return true;
	    if(this.getClass() != o.getClass()) return false;

	    Stadt p = (Stadt)o;             //in der wir sind  
        return this.name.equals(p.name);
               
	 }

	@Override // wichtig damit keine Dopplung in Mengen
    public int hashCode()
    {
	    return this.name.hashCode(); //Hashcode der OV name zurückgeben
	}
	
	// wurde aus der Übung genommen
	@Override 
	public int compareTo(Object o) 
	{
        Stadt stadt = (Stadt)o;
        return this.name.compareTo(stadt.name);
    }
 
}
