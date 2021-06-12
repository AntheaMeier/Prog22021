package aufgabenProg2.aufgabe7;

import java.util.*;

public class Slack implements Publisher
{
	//OVs:
	private Set<Listener> listeners; // speichtert alle Abonnenten in Menge, könnte auch ne List sein
	private int nrOfMessages; // alle veröffentlichten Nachrichten werden fortlaufend nummeriert

	//parameterloser Konstruktor:
	public Slack() 
	{
		this.listeners = new HashSet<>();
		this.nrOfMessages = 0;
	}
	
	@Override
	public boolean register(Listener listener) 
	{
		return this.listeners.add(listener);
	}

	@Override
	public boolean unregister(Listener listener) 
	{
		return this.listeners.remove(listener);
	}

	@Override
	public void notifyListener() 
	{
		for(Listener element : listeners) 
		{
			element.update();
		}
	}

	@Override
	public String getUpdate(Listener listener) 
	{
		return "Breaking News " + this.nrOfMessages;
	}
	
	public void publishNews() 
	{
		this.nrOfMessages++;
		this.notifyListener();
	}

}
