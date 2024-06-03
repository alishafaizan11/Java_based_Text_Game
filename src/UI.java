import java.util.*;
public class UI extends ConcreteSubject implements Runnable{
	
	public boolean UIdisable = false;
	
	public synchronized void setDisableUI()
	{
		UIdisable = true;
	}
	
	public synchronized void resetDisableUI()
	{
		UIdisable = false;

	}
	
	public synchronized boolean returnDisableStatus()
	{
		return UIdisable;
	}
	
	public UI() {
		Thread t = new Thread(this);
		t.start();
	}
	
	public void print(String a) {
		System.out.println(a);
	}
	
	public void printsameline(String a) {
		System.out.print(a);
	}
	
	
	public String input() {
		Scanner in = new Scanner(System.in);  
		String input = in.nextLine();
		return input;
	}

	@Override
	public void run() {
		try {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);  
		
		while(true) {
			String temp = in.nextLine();
			String tocken[] = temp.split(" ", 2);
		
			Message m;
			m = new Message(this, tocken[0], temp);
			publishMessage(m);
		
		}
	
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}      
		
	}
}
