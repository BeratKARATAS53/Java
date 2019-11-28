import java.util.ArrayList;

public class CDDVD extends OfficeSuplies
{
	public int cStock;
	
	ArrayList<String> cddvds = new ArrayList<String>();
	
	/**
	 * listAdd method add items to cddvds list.
	 * @param a is equal to items which wrote in items.txt, but it is only CDDVDs.
	 */
	public void listAdd(String a)
	{
		cddvds.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<cddvds.size()/6; c++)
		{
			System.out.println("----------------------------------\nType: "+cddvds.get(6*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(cddvds.get(6*c+1))+" $");
			System.out.println("Release Date: "+cddvds.get(6*c+2));
			System.out.println("Title: "+cddvds.get(6*c+3));
			System.out.println("Songs: "+cddvds.get(6*c+5));
			System.out.println("Composer: "+cddvds.get(6*c+4));
			a++;
		}
		return " ";
	}
	
	/**
	 * @return The Amount of CDDVD Stock
	 */
	public int showStock()
	{
		this.cStock=cddvds.size()/6;
		return cStock;
	}

}
