import java.util.ArrayList;

public class Tablet extends Computer
{
	public int tStock1;
	ArrayList<String> tablets = new ArrayList<String>();
	
	/**
	 * listAdd method add items to tablets list.
	 * @param a is equal to items which wrote in items.txt, but it is only Tablets.
	 */
	public void listAdd(String a)
	{
		tablets.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<tablets.size()/11; c++)
		{
			System.out.println("----------------------------------\nType: "+tablets.get(11*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(tablets.get(11*c+1))+" $");
			System.out.println("Manufacturer: "+tablets.get(11*c+2));
			System.out.println("Brand: "+tablets.get(11*c+3));
			System.out.println("Max Volt: "+tablets.get(11*c+4)+" V.");
			System.out.println("Max Watt: "+tablets.get(11*c+5)+" W.");
			System.out.println("Operating System: "+tablets.get(11*c+6));
			System.out.println("CPU Type: "+tablets.get(11*c+7));
			System.out.println("RAM Capacity: "+tablets.get(11*c+8)+" GB.");
			System.out.println("HDD Capacity: "+tablets.get(11*c+9)+" GB.");
			System.out.println("Dimension: "+tablets.get(11*c+10)+" in.");
			a++;
		}
		return "";
	}
	
	/**
	 * @return The Amount of Tablet Stock
	 */
	public int showStock()
	{
		this.tStock1=tablets.size()/11;
		return tStock1;
	}
}
