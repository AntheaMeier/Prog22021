package aufgabenProg2.aufgabe3;


/*
 diese Klasse repraesentiert eine Folge 
 von Zuegen (Move), die in einem Array
 moves gespeichert sind
 */


public class Moves 
{
    private Move[] hopArray;   //hieß urspünglich moves

/* der Konstruktor erstellt ein leeres moves-Array
(d.h. noch keine Zuege (Moves) gespeichert)
*/
    
    
    public Moves()
    {
        this.hopArray = new Move[0];
    }

/*
der Konstruktor erstellt ein hopArray (vom Typ Move) mit einem
hop - dem ersten Zug (firstHop) 
*/
    
    
    public Moves(Move firstHop)
    {
        this.hopArray = new Move[1];
        this.hopArray[0] = firstHop;
    }

    
    
// Anzahl der bisher gespeicherten Zuege
    
    public int getLength()
    {
        return this.hopArray.length;
    }

    
/*
fuegt einen Zug (nextHop) zum hopArray hinzu
dazu muss das newHopArray um 1 laenger sein als zuvor
 es wird eine Kopie aller Zuege erstellt und dann
der nextHop hinzugefuegt */
    
    public void addMove(Move nextHop)
    {
        Move[] newHopArray = new Move[this.hopArray.length + 1];
        for (int index = 0; index < this.hopArray.length; index++) 
        {
            newHopArray[index] = this.hopArray[index];
        }
        newHopArray[newHopArray.length - 1] = new Move(nextHop.getFrom(), nextHop.getTo());
        this.hopArray = newHopArray;
    }

/*
gibt den Hop zurueck, der im hopArray unter dem Index index gespeichert ist;
kann sein, dass index kein korrekter Index im hopArray ist, 
dann wird eine IllegalArgumentException geworfen
*/
    public Move getHopAtIndex(int index) throws IllegalArgumentException
    {
        try 
        {
            return this.hopArray[index];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new IllegalArgumentException("kein gueltiger Index!");
        }
    }

/*
Ausgabe aller im hopArray gespeicherten Zuege
wird nur zum Debuggen benoetigt
*/
    
    public void printHops()
    {
        System.out.printf("%n--------------------%n");
        for (int index = 0; index < this.hopArray.length; index++) 
        {
            //Move hop = this.hopArray[index];
            //Point from = hop.getFrom();
            //Point to = hop.getTo();
            System.out.println(hopArray[index].getFrom().toString() + " --> " + hopArray[index].getTo().toString());
        }
        System.out.printf("%n---%n%n");
    }
}

