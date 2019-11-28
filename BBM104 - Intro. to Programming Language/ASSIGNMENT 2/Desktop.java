import java.util.ArrayList;

public class Desktop extends Computer
{
	public int dStock;
	ArrayList<String> desktops = new ArrayList<String>();
	
	/**
	 * listAdd method add items to desktops list.
	 * @param a is equal to items which wrote in items.txt, but it is only Desktops.
	 */
	public void listAdd(String a)
	{
		desktops.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<desktops.size()/11; c++)
		{
			System.out.println("----------------------------------\nType: "+desktops.get(11*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(desktops.get(11*c+1))+" $");
			System.out.println("Manufacturer: "+desktops.get(11*c+2));
			System.out.println("Brand: "+desktops.get(11*c+3));
			System.out.println("Max Volt: "+desktops.get(11*c+4)+" V.");
			System.out.println("Max Watt: "+desktops.get(11*c+5)+" W.");
			System.out.println("Operating System: "+desktops.get(11*c+6));
			System.out.println("CPU Type: "+desktops.get(11*c+7));
			System.out.println("RAM Capacity: "+desktops.get(11*c+8)+" GB.");
			System.out.println("HDD Capacity: "+desktops.get(11*c+9)+" GB.");
			System.out.println("Color: "+desktops.get(11*c+10));
			a++;
		}
		return "";
	}
	
	/**
	 * @return The Amount of Desktop Stock
	 */
	public int showStock()
	{
		this.dStock=desktops.size()/11;
		return dStock;
	}
}
