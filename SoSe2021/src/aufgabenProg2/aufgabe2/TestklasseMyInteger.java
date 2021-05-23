package aufgabenProg2.aufgabe2;

public class TestklasseMyInteger {

	public static void main(String[] args) 
	{
		MyInteger i1 = null, i2 = null, i3 = null, 
				i4 = null, i5 = null, i6 = null, i7 = null, 
				i8 = null, i9 = null, i10 = null;
		
		/*
		 
		MyInteger i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
		*/
		
		try 
		{
			i1 = new MyInteger("2147483800");
			System.out.println("i1: " + i1.intValue());
			System.out.println("i1: " + i1.toString());
		}
		catch(NumberFormatException e) 
		{
			System.out.println("i1: " + e.getMessage());
		}
		
		
		try 
		{
			i2 = new MyInteger("-0056");
			System.out.println("i2: " + i2.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i2: " + e.getMessage());
		}

		try 
		{
			i3 = new MyInteger("Welt");
			System.out.println("i3: " + i3.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i3: " + e.getMessage());
		}
		
		
		// heir anderen Konstruktor aufrufen, der nur int-Wert akzeptiert und keine Exception wirft
		i4 =new MyInteger(2147483647);
		System.out.println("i4: " + i4.intValue());
		
		
		
		try 
		{
			i5 = new MyInteger("2147483649");
			System.out.println("i5: " + i5.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i5: " + e.getMessage());
		}
		
		
		
		try 
		{
			i6 = MyInteger.valueOf("-0000214783648");
			System.out.println("i6: " + i6.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i6: " + e.getMessage());
		}
		
		
		
		try 
		{
			i7 = MyInteger.valueOf("hallo");
			System.out.println("i7: " + i7.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i7: " + e.getMessage());
		}
		
		
		
		try 
		{
			i8 = MyInteger.valueOf(-214783648);
			System.out.println("i8: " + i8.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i8: " + e.getMessage());
		}
		
		
		
		try 
		{
			i9 = MyInteger.valueOf("");
			System.out.println("i9: " + i9.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i9: " + e.getMessage());
		}
		
		
		try 
		{
			i10 = MyInteger.valueOf("+");
			System.out.println("i10: " + i10.intValue());
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("i10: " + e.getMessage());
		}
		
		System.out.println("i1 equals i2 ? : " + i1.equals(i2));
		System.out.println("i1 equals i3 ? : " + i1.equals(i3));
		System.out.println("i1 equals i4 ? : " + i1.equals(i4));
		System.out.println("i1 equals i5 ? : " + i1.equals(i5));
		System.out.println("i1 equals i6 ? : " + i1.equals(i6));
		System.out.println("i1 equals i7 ? : " + i1.equals(i7));
		System.out.println("i1 equals i8 ? : " + i1.equals(i8));
		System.out.println("i1 equals i9 ? : " + i1.equals(i9));
		System.out.println("i1 equals i10 ? : " + i1.equals(i10));
		
		System.out.println("hashCode i1 : " + i1.hashCode());
		System.out.println("hashCode i2 : " + i2.hashCode());

		
		try 
		{
			System.out.println("hashcode i3 : " + i3.hashCode());
		}
		catch(NullPointerException e) 
		{
			System.out.println("Objekt exisitiert nicht!");
		}
		
		
		System.out.println("intValue i4: " + i4.intValue());
		System.out.println("doubleValue i4: " + i4.doubleValue());
		
		System.out.println("doubleValue i1: " + i1.doubleValue());
		System.out.println("doubleValue i2: " + i2.doubleValue());
	
		
		try 
		{
			System.out.println("doubleVailue i3: " + i3.doubleValue());
		}
		catch(NullPointerException e) 
		{
			System.out.println("Objekt exisitiert nicht!");
		}
		
		
	}

}
