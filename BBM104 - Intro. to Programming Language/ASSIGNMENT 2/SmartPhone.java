import java.util.ArrayList;

public class SmartPhone extends Electronics
{
	public int sStock1;
	ArrayList<String> smartphones = new ArrayList<String>();
	
	/**
	 * listAdd method add items to smartphones list.
	 * @param a is equal to items which wrote in items.txt, but it is only Smart Phones. 
	 */
	public void listAdd(String a)
	{
		smartphones.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<smartphones.size()/7; c++)
		{
			System.out.println("----------------------------------\nType: "+smartphones.get(7*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(smartphones.get(7*c+1))+" $");
			System.out.println("Manufacturer: "+smartphones.get(7*c+2));
			System.out.println("Brand: "+smartphones.get(7*c+3));
			System.out.println("Max Volt: "+smartphones.get(7*c+4)+" V.");
			System.out.println("Max Watt: "+smartphones.get(7*c+5)+" W.");
			System.out.println("Screen Type: "+smartphones.get(7*c+6));
		}
		return "\n";
	}
	
	/**
	 * @return The Amount of Smart Phone Stock
	 */
	public int showStock()
	{
		this.sStock1=smartphones.size()/7;
		return sStock1;
	}
	
}
