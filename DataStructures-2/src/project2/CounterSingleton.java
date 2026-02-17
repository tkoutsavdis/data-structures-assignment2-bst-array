package project2;

public class CounterSingleton {
	
	private static CounterSingleton singleInstance = null;
	
	private int counter;
	
	private CounterSingleton() {
		counter = 0;
	}
	
	public static CounterSingleton getInstance() {
		if(singleInstance == null)
			singleInstance = new CounterSingleton();
		
		return singleInstance;
	}
	
	public void resetCounter() {
		counter = 0; 
	}
	
	public int getCount() {
		return counter;
	}
	
	public boolean increaseCounter() {
		counter++;
		return true;
	}
	
}
