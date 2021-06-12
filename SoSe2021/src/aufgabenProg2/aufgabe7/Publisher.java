package aufgabenProg2.aufgabe7;


public interface Publisher 
{
	public boolean register(Listener listener);
	public boolean unregister(Listener listener);
	public void notifyListener();
	public String getUpdate(Listener listener);
	
}
