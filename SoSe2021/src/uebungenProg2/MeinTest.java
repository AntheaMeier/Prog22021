package uebungenProg2;

import java.util.*;

public class MeinTest 
{

	public static void main(String[] args) 
	{
        //mit hashSet:
		
		Set<String> menge = new HashSet<>();

        String s1 = "erster";
        String s2 = "zweiter";
        String s3 = "dritter";
        String s4 = "zweiter";

        System.out.println(menge.add(s1)); // true
        System.out.println(menge.add(s2)); // true
        System.out.println(menge.add(s3)); // true
        System.out.println(menge.add(s4)); // false

        System.out.println(menge.size()); // 3

        for(String s : menge)
        {
            System.out.println(s);
        }
       
        System.out.println();
        System.out.println();
        
      //mit TreeSet:
		
      		Set<String> mengeT = new TreeSet<>();

              String s1T = "erster";
              String s2T = "zweiter";
              String s3T = "dritter";
              String s4T = "zweiter";

              System.out.println(mengeT.add(s1T)); // true
              System.out.println(mengeT.add(s2T)); // true
              System.out.println(mengeT.add(s3T)); // true
              System.out.println(mengeT.add(s4T)); // false

              System.out.println(mengeT.size()); // 3

              for(String s : mengeT)
              {
                  System.out.println(s);
              }
	}//MK

}//KK
