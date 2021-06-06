package uebungenProg2.uebung7;

//6. Implementieren Sie für MyInteger das Interface Comparable<MyInteger> so, 
//dass nach den Größen der Werte sortiert wird. 
public class MyInteger implements Comparable<MyInteger>
{
  private int value;

  public MyInteger(int value)
  {
      this.value = value;
  }

  public int intValue()
  {
      return this.value;
  }

  public static MyInteger valueOf(int value)
  {
      return new MyInteger(value);
  }

  //7. Ändern Sie compareTo() in MyInteger so, dass 
  //die Werte der Schlüssel absteigend sortiert werden.
  
  //Beispiel aus dem Script für AUFsteigend sortiert:
  //public int compareTo(Rectangle o) {
      //  int diff = (this.height+this.width) - (o.height+o.width);
      //  return diff;
      //}
 
  @Override
  public int compareTo(MyInteger o) 
  {
	  return -(this.value - o.value); // - vor der Klammer da ABSTEIGEND sortieren
  }
}

