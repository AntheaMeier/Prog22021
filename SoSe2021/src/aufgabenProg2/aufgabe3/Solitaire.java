package aufgabenProg2.aufgabe3;

public class Solitaire 
{
	private Moves spiel;
    private State[][] spielfeld;

    public Solitaire()
    {
        this.spiel = new Moves();
        this.spielfeld = new State[7][7];
        for(int row = 0; row < this.spielfeld.length; row++)
        {
            for(int col = 0; col < this.spielfeld[row].length; col++)
            {
                if((row < 2 || row > 4) && (col < 2 || col > 4))
                {
                    this.spielfeld[row][col] = State.NOT;
                }
                else
                {
                    this.spielfeld[row][col] = State.USED;
                }
            }
        }
        this.spielfeld[3][3] = State.FREE;
    }

    /*
     * Geben Sie das Spielfeld aus! Am Anfang sollte auf der
     * Konsole so ein Bild erscheinen:
     *     o o o     
     *     o o o     
     * o o o o o o o 
     * o o o   o o o 
     * o o o o o o o 
     *     o o o     
     *     o o o 
     * 
     */
    
    
    public void print()
    {
    	for (int row = 0; row < this.spielfeld.length; row++) 
    	{
			System.out.print(row + 1 + "|");
			for (int col = 0; col < this.spielfeld[row].length; col++) 
			{
				if(this.spielfeld[row][col] == State.USED)
				{
					System.out.print(col + 1 + " ");
				}
				else if(this.spielfeld[row][col] == State.NOT)
				{
					System.out.print("  ");
				}
				else
				{
					System.out.print("x ");
				}
			}
			System.out.println();
		}
    	System.out.println();
    }

    /*
     * diese Methode gibt ein true zurueck, wenn von der
     * uebergebenen Position (row,col) ein Zug moeglich ist
     * d.h. 
     * 1. auf der angegebenen Position muss ein Stein sein
     * 2. zwei Steine weiter (oben, unten, rechts oder links)
     *      darf kein Stein sein
     * 3. dazwischen muss ein Stein sein
     */
    public boolean possibleFrom(int row, int col)
    {
    	if(row>=0 && row<7 && col>=0 && col<7 && this.spielfeld[row][col] == State.USED) 
    	{
    		//nach oben?
    		if(row>1 && this.spielfeld[row-1][col] == State.USED && this.spielfeld[row-2][col] == State.FREE)
    		{
    			return true;
    		} 
        	//nach unten?
    		if(row<5 && this.spielfeld[row+1][col] == State.USED && this.spielfeld[row+2][col] == State.FREE)
    		{
    			return true;
    		}
    		//nach rechts?
    		if(col<5 && this.spielfeld[row][col+1] == State.USED && this.spielfeld[row][col+2] == State.FREE)
    		{
    			return true;
    		}
    		//nach links?
    		if(col>1 && this.spielfeld[row][col-1] == State.USED && this.spielfeld[row][col-2] == State.FREE)
    		{
    			return true;
    		}	
    	}
        return false;
    }

    /*
     * diese Methode gibt alle Positionen (Point) zurueck,
     * AUF die von (fromRow,fromCol) aus gesprungen werden
     * kann
     */
    
    public Point[] possibleTos(int fromRow, int fromCol)
    {
        int anzahlPTs = 0; // number of possible to-Points
    	if(!possibleFrom(fromRow, fromCol)) 
    	{
    		return new Point[anzahlPTs];
    	} 
    	if(fromRow>1 && this.spielfeld[fromRow-1][fromCol] == State.USED && this.spielfeld[fromRow-2][fromCol] == State.FREE)
		{
    		anzahlPTs++;
		}
    	if(fromRow<5 && this.spielfeld[fromRow][fromCol+1] == State.USED && this.spielfeld[fromRow][fromCol+2] == State.FREE)
		{
    		anzahlPTs++;
		}
		if(fromCol<5 && this.spielfeld[fromRow][fromCol+1] == State.USED && this.spielfeld[fromRow][fromCol+2] == State.FREE)
		{
			anzahlPTs++;
		}
		if(fromCol>1 && this.spielfeld[fromRow][fromCol-1] == State.USED && this.spielfeld[fromRow][fromCol-2] == State.FREE)
		{
			anzahlPTs++;
		}
		
		Point[] arrayOfTos = new Point[anzahlPTs++];
		int index = 0;
		
		if(fromRow>1 && this.spielfeld[fromRow-1][fromCol] == State.USED && this.spielfeld[fromRow-2][fromCol] == State.FREE)
		{
    		arrayOfTos[index] = new Point(fromRow-2, fromCol);
    		index++;
		}
    	if(fromRow<5 && this.spielfeld[fromRow+1][fromCol] == State.USED && this.spielfeld[fromRow+2][fromCol] == State.FREE)
		{
    		arrayOfTos[index] = new Point(fromRow, fromCol+2);
    		index++;
		}
		if(fromCol<5 && this.spielfeld[fromRow][fromCol+1] == State.USED && this.spielfeld[fromRow][fromCol+2] == State.FREE)
		{
			arrayOfTos[index] = new Point(fromRow+2, fromCol);
    		index++;
		}
		if(fromCol>1 && this.spielfeld[fromRow][fromCol-1] == State.USED && this.spielfeld[fromRow][fromCol-2] == State.FREE)
		{
			arrayOfTos[index] = new Point(fromRow, fromCol-2);
		}
		return arrayOfTos;
    }

    /* 
     * diese Methode erzeugt ein Moves-Objekt
     * in dieses Moves-Objekt werden mithilfe der
     * Objektmethode addMove() (aus Moves) alle
     * moeglichen Zuege hinzugefuegt
     * (moeglich im aktuellen Zustand von field[][])
     */
    public Moves possibleHops()
    {
    	Moves possibleHops = new Moves();
		for(int row = 0; row < this.spielfeld.length; row++)
		{
			for(int col = 0; col < this.spielfeld[row].length; col++)
			{
				if(possibleFrom(row,col))
				{
					Point from = new Point(row,col);
					Point[] arrayOfTos = this.possibleTos(row, col);
					for(int index=0; index<arrayOfTos.length; index++)
					{
						Move move=new Move(from, arrayOfTos[index]);
						possibleHops.addMove(move);
					}
				}
			}
		}
		return possibleHops;

    }

    /*
     * gibt ein true zurueck, wenn im aktuellen Zustand 
     * von field[][] ueberhaupt noch ein Zug moeglich ist
     * sonst false
     */
    public boolean hopPossible()
    {
		for(int row = 0; row < this.spielfeld.length; row++)
		{
			for(int col = 0; col < this.spielfeld[row].length; col++)
			{
				if(possibleFrom(row,col))
				{
					return true;
				}
			}
		}
		return false;

    }

    /*
     * ruft die Methode move(Move move) auf,
     * wenn ein Zug moeglich ist (dann true zurueck)
     * sonst false
     */
    public boolean hopFirstPoss()
    {
    	System.out.println("Moving the first possible move from the following list of possible moves:");
		if(!hopPossible()) return false;
		else {
			Moves possibleHops = this.possibleHops();
			possibleHops.printHops();
			try {
				Move hopX = possibleHops.getHopAtIndex(0);
				this.hop(hopX);
			
				return true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Zug nicht moeglich!");
				return false;
			}
		}

    }

    /*
     * hier wird der Zug Move hop ausgefuehrt
     * nach dem Zug ist 
     * 1. die from-Position leer
     * 2. die to-Position mit einem Stein besetzt
     * 3. dazwischen leer (Stein wird "entfernt")
     * falls Zug nicht moeglich, wird eine 
     * IllegalArgumentException geworfen 
     */
    public void hop(Move hop) throws IllegalArgumentException
    {
		Point from = hop.getFrom();
		Point to = hop.getTo();
		int fromRow = from.getRow();
		int fromCol = from.getCol();
		int toRow = to.getRow();
		int toCol = to.getCol();
		int middleRow = (fromRow + toRow) / 2;
		int middleCol = (fromCol + toCol) / 2;
		try {
			this.spielfeld[fromRow][fromCol] = State.FREE;
			this.spielfeld[middleRow][middleCol] = State.FREE;
			this.spielfeld[toRow][toCol] = State.USED;	
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new IllegalArgumentException("Zug nicht moeglich! (" + fromRow + ", " + fromCol + ") --> "
					+ "( " + toRow + ", " + toCol + ") ");
		}


    }

}
