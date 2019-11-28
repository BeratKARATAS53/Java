import java.util.ArrayList;

public class Laptop extends Computer
{
	public int lStock;
	
	ArrayList<String> laptops = new ArrayList<String>();
	
	/**
	 * listAdd method add items to laptops list.
	 * @param a is equal to items which wrote in items.txt, but it is only Laptops.
	 */
	public void listAdd(String a)
	{
		laptops.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<laptops.size()/11; c++)
		{
			System.out.println("----------------------------------\nType: "+laptops.get(11*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(laptops.get(11*c+1))+" $");
			System.out.println("Manufacturer: "+laptops.get(11*c+2));
			System.out.println("Brand: "+laptops.get(11*c+3));
			System.out.println("Max Volt: "+laptops.get(11*c+4)+" V.");
			System.out.println("Max Watt: "+laptops.get(11*c+5)+" W.");
			System.out.println("Operating System: "+laptops.get(11*c+6));
			System.out.println("CPU Type: "+laptops.get(11*c+7));
			System.out.println("RAM Capacity: "+laptops.get(11*c+8)+" GB.");
			System.out.println("HDD Capacity: "+laptops.get(11*c+9)+" GB.");
			if(laptops.get(11*c+10).compareTo("0")==0)
				System.out.println("HDMI Support: No");
			else
				System.out.println("HDMI Support: Yes");
			a++;
		}
		return "";
	}
	
	/**
	 * @return The Amount of Laptop Stock
	 */
	public int showStock()
	{
		this.lStock=laptops.size()/11;
		return lStock;
	}
}
