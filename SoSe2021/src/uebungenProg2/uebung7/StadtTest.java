package uebungenProg2.uebung7;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

public class StadtTest
{
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

    //Zusatz: Schreiben Sie in StadtTest.java eine Methode 
    //public static boolean contains(Map<MyInteger, Stadt> staedteMap, Stadt stadt), 
    //die ein true zurückgibt, wenn die Stadt stadt bereits in der staedteMap als ein 
    //value existiert. 
    //Tipp: Die Methode get(Object key) aus Map gibt den zu key gehörigen value zurück 
    //und mit keySet() bekommt man die Menge aller keys aus der Map ermittelt. 
    //Testen Sie die Methode, indem Sie zur Menge nur dann die stadt hinzufügen, 
    //wenn sie nicht bereits in der Menge aufgeführt ist.
    
    public static boolean contains(Map<MyInteger, Stadt> staedteMap, Stadt stadt)
    {
        //alle Schlüssel ermitteln mit keySet() 
    	Set<MyInteger> allKeys = staedteMap.keySet();
    	for (MyInteger elementKey : allKeys) 
    	{
			if(staedteMap.get(elementKey).equals(stadt))
			{
				return true;
			}
		}
    	return false;

        //durch alle Schlüssel iterieren und testen ob der jeweilige Schlüssel 
        //gleich der übergebenen Stadt ist
        //wird die Stadt gefunden -> return true, sonst false   

    }

    public static void main(String[] args)
    {

        System.out.printf("%n------------ Menge --------------%n");
        //3. Ändern Sie in der StadtTest.java den Konstruktoraufruf der 
        //Set von HashSet nach TreeSet und führen Sie die Klasse aus - 
        //es wird eine Exception geworfen (Stadt cannot be cast to 
        //class java.lang.Comparable). 
        Set<Stadt> staedteMenge = new TreeSet<>();
        for(Stadt s : staedte())
        {
            staedteMenge.add(s);
        }
        for(Stadt s : staedteMenge)
        {
            s.print();
        }

        System.out.printf("%n------------ Maps --------------%n");
        //6. Ändern Sie in der StadtTest.java den Konstruktoraufruf der Map von     
        //HashMap nach TreeMap und führen Sie die Klasse aus - es wird eine Exception
        // geworfen (MyInteger cannot be cast to class java.lang.Comparable). 
        Map<MyInteger, Stadt> staedteMap = new TreeMap<>();
        int i = 1;
        
        for(Stadt s : staedte())
        {
            //für die Zusatzaufgabe muss hier noch geprüft werden, ob s bereits in   
            //der Map vorhanden ist, dafür wird die contains-Methode benötigt 
            
        	if(!contains(staedteMap, s)) 
        	{
        		staedteMap.put(new MyInteger(i++), s);
        	}
        	
        }           

        for(Map.Entry<MyInteger, Stadt> entry : staedteMap.entrySet())
        {
            MyInteger key = entry.getKey();
            System.out.printf("%-3d",key.intValue());
            entry.getValue().print();
        }

    }

}

