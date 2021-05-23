package aufgabenProg2.aufgabe3;

public class TestklasseSolitaire {

	public static void main(String[] args) 
	{
		Solitaire spiel = new Solitaire();
		System.err.println("         START");
		System.out.println();
		spiel.print();
		System.out.println();
		int spielzug = 1;
		while(spiel.hopFirstPoss()) 
		{
			System.err.println("Nach dem " + spielzug + ". Spielzug:");
			System.out.println();
			spielzug++;
			spiel.print();
		}
		System.out.println("Kein moeglicher Spielzug.");

	}

}
