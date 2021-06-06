package uebungenProg2.uebung7;

import java.util.*;

//3. Implementieren Sie für Stadt das Interface Comparable<Stadt> so, 
//dass nach den Namen der Städte sortiert wird. 
public class Stadt implements Comparable<Stadt>
{
  String name;
  List<Integer> bevoelkerung;
  float flaeche;

  public Stadt(String name, List<Integer> bevoelkerung, float flaeche)
  {
      super();
      this.name = name;
      this.bevoelkerung = bevoelkerung;
      this.flaeche = flaeche;
  }

  void print()
  {
      System.out.printf("%-15s %9.2f km2 ", name, flaeche);
      for(Integer i : bevoelkerung)
      {
          System.out.printf("%,12d", i);
      }
      System.out.println();
  }

  @Override
  public boolean equals(Object o)
  {
      if(o==null) return false;
      if(o==this) return true;
      if(this.getClass()!=o.getClass()) return false;

      Stadt other = (Stadt)o;
      return (this.name.equals(other.name));
  }

  @Override
  public int hashCode()
  {
      return this.name.hashCode();
  }


  //3. Ändern Sie compareTo() in Stadt so, dass nach den Namen der 
  //Städte sortiert werden kann.  

  //4. Ändern Sie compareTo() in Stadt so, dass die Namen der 
  //Städte absteigend sortiert werden 

  //5. Ändern Sie compareTo() in Stadt so, 
  //dass die Städte absteigend nach ihrer Fläche sortiert werden.

  //Beispiel aus dem Script
  //@Override
      //public int compareTo(Circle o) {
      //  if(this.radius > o.radius) return 1;
      //  else if(this.radius < o.radius) return -1;
      //  else return 0; // this.radius == o.radius (diese Zeile verstehe ich nicht!)
  //}     
  @Override
  public int compareTo(Stadt o) 
  {
	  if(this.flaeche < o.flaeche)   // das ist ABSTEIGEND, > waere aufsteigend
	  {
		  return 1; 
	  }
	  else if(this.flaeche > o.flaeche) // hier muss es > damit es ABSTEIGEND sortiert wird
	  {
		  return -1; 
	  }
	  else 
	  {
		  return 0;  
	  } 
  }   

}


