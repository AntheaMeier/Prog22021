package aufgabenProg2.aufgabe7;

public class Student implements Listener
{
	private String name;
	private Publisher publisher;
	
	public Student(String name) 
	{
		this.name = name;
	}

	@Override
	public void update() 
	{
		String msg = this.publisher.getUpdate(this); // die getUpdate()-Methode des publisher aufgerufen und die 
		System.out.println(this.name + " received " + msg);// zurückgegebene Nachricht msg wird auf die Konsole ausgegben	
	}

	@Override
	public void setPublisher(Publisher publisher) 
	{
		this.publisher = publisher;
		if(this.publisher.register(this)) //die register()-Methode des publisher aufgerufen und der Wert der Objektvariable publisher gesetzt.
		{
			System.out.println(this.name + " registered!"); //ergolgt bei erfolgreicher Anmeldung an den Publisher
		}
		
	}

	@Override
	public void removePublisher(Publisher publisher) 
	{
		if(this.publisher.unregister(this)) // student meldet sich beim Publisher ab
		{
			System.out.println(this.name + " deregistered!");
		}
		this.publisher = null;
		
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Student o = (Student) obj;
		return this.name.equals(o.name);
	}
	
	@Override
	public int hashCode() 
	{
		return this.name.hashCode();
	}



}
