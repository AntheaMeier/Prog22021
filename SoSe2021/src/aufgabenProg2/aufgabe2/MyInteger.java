package aufgabenProg2.aufgabe2;

import java.util.Iterator;

public class MyInteger 
{
	public static final int MAX_VALUE = 2147483647; // groesste int-Zahl
	public static final int MIN_VALUE = -2147483648; //kleineste int-Zahl
	
	private int value; // value hat eine objektorientierte Hülle(MyIntenger):
	
	//Konstruktor 1:
	public MyInteger(int value) 
	{
		this.value = value;
	}
	
	/* Konstruktor 2:
	public MyInteger(String s) throws IllegalArgumentException
	{
		this.value = parseInt(s);
	}*/
	
	// ebenfalls der 2. Konstruktor, aber reicht die Exception nur weiter!
	public MyInteger(String s)
	{
	    try
	    {
	        this.value = Integer.parseInt(s);
	    }
        catch(NumberFormatException e)      
        {
            System.out.println("Der übergebe Wert entspricht keinem Integer Wert. Dem Objekt wird der Wert 0 zugewiesen.");
            this.value = 0;
        }	
	}
	
	// Hilfs-OMs für die parseInt():____________________________
	
	private static boolean charAsNumber(char c)
	{
		return(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
				|| c == '5' || c == '6' || c == '7' || c == '8' 
				|| c == '9');
	}
	
	private static int convertCharToInt(char c)
	{
		int character = c;
		int intValue = character-48; //0 ist 48 und 9 ist 57 (Asciicode)
		return intValue;
	}
	
	
	
	private static boolean inputIsNumber(String s)  // prüft ob der String aus Zahlen besteht
	{
		for (int i = 0; i < s.length(); i++) 
		{
			if(!charAsNumber(s.charAt(i)))  // das Zeichen an der Indexstelle ist keine Zahl
			{
				return false;
			}
		}
		return true;
	}
	
	
	private static String removeLeadingZeros(String s)  //schneidet alle vorderen Nullen ab
	{
		while(s.charAt(0)=='0') //solange wie auf der 0. Indexstelle eine 0 liegt, schneide sie ab
		{
			s = s.substring(1);
		}
		return s;
	}
	
	//_______________________________
	
	// eigentlich soll die Exception jedoch gecatcht werden!!
	public static int parseInt(String s) throws IllegalArgumentException 
	{
		if (s.length()==0) // falls der String leer ist dann wirf Excep.
		{
			throw new IllegalArgumentException("leerer String");
		}
		
		//nun prüfen ob es eine negative Zahl ist
		boolean negative = false;      // nehmen erstma an, dass es eine positive Zahl ist
		if (s.startsWith("-"))        // neue OM: startsWith()
		{
			negative = true;
			s = s.substring(1);       
		}
		else if (s.startsWith("+"))        
		{                             
			s = s.substring(1);       
		}
		if (s.length()==0) //falls ein + oder - die einzigen Zeichen im String waren
		{
			throw new IllegalArgumentException("keine Zahl, sondern nur ein Vorzeichen");
		}
		s = removeLeadingZeros(s); // mit s weiter arbeiten, aber ohne die vorderen Nullen
		
		if (!inputIsNumber(s)) //der String ist keine Zahl
		{
			throw new IllegalArgumentException("keine Zahl, sondern ein Zeichen");
		}
		
		int expo = 1;
		int wert = 0;
		
		for (int i = s.length()-1; i>=0; i--) 
		{
			wert += convertCharToInt(s.charAt(i)) * expo;
			expo *= 10;
		} 
		if(negative) return -wert;
		else return wert;
	}
	
	
	public int intValue() 
	{
		return value;
	}
	
	public double doubleValue() 
	{
		return (double)value;
	}
	
	public static MyInteger valueOf(String s) throws IllegalArgumentException 
	{
		return new MyInteger(s);
	}
	
	public static MyInteger valueOf(int value) 
	{
		return new MyInteger(value);
	}
	
	@Override
	 public boolean equals(Object o)
	 {
		if(o == null) return false;
	    if(this == o) return true;
	    if(this.getClass() != o.getClass()) return false;

	    MyInteger p = (MyInteger)o;                     
	    return (this.value == p.value);
	 }
	
	@Override
	public String toString()
	{                     
	   return "" + value;
	}
	
	@Override
	public int hashCode()
	{                     
	   return this.value;
     }

}
