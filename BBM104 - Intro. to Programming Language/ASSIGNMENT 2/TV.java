import java.util.ArrayList;

public class TV extends Electronics
{
	public int tStock2;
	
	ArrayList<String> tv = new ArrayList<String>();
	
	/**
	 * listAdd method add items to tv list.
	 * @param a is equal to items which wrote in items.txt, but it is only TVs. 
	 */
	public void listAdd(String a)
	{
		tv.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<tv.size()/7; c++)
		{
			System.out.println("----------------------------------\nType: "+tv.get(7*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(tv.get(7*c+1))+" $");
			System.out.println("Manufacturer: "+tv.get(7*c+2));
			System.out.println("Brand: "+tv.get(7*c+3));
			System.out.println("Max Volt: "+tv.get(7*c+4)+" V.");
			System.out.println("Max Watt: "+tv.get(7*c+5)+" W.");
			System.out.println("Screen size: "+tv.get(7*c+6)+"\"");
		}
		return "";
	}
	
	/**
	 * @return The Amount of TV Stock
	 */
	public int showStock()
	{
		this.tStock2=tv.size()/7;
		return tStock2;
	}
}
