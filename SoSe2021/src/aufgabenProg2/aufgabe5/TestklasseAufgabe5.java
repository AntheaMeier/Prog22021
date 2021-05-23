package aufgabenProg2.aufgabe5;

public class TestklasseAufgabe5 {

	public static void main(String[] args) 
	{
		SetOperations alleDreiMengen = new SetOperations();
		alleDreiMengen.fill(); // erstmal füllen
		
		// nun testen:
		alleDreiMengen.fillBothUnion();
		alleDreiMengen.print();
		alleDreiMengen.fillBothIntersection();
		alleDreiMengen.print();
		alleDreiMengen.fillBothDifference();
		alleDreiMengen.print();

	}

}
