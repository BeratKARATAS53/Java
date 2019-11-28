import java.util.ArrayList;

public class HairCare extends Cosmetics
{
	public int hStock;
	ArrayList<String> haircares = new ArrayList<String>();
	
	/**
	 * listAdd method add items to haircares list.
	 * @param a is equal to items which wrote in items.txt, but it is only Hair Cares. 
	 */
	public void listAdd(String a)
	{
		haircares.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<haircares.size()/8; c++)
		{
			System.out.println("----------------------------------\nType: "+haircares.get(8*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(haircares.get(8*c+1))+" $");
			System.out.println("Manufacturer: "+haircares.get(8*c+2));
			System.out.println("Brand: "+haircares.get(8*c+3));
			if(haircares.get(8*c+4).compareTo("0")==0)
				System.out.println("Organic: No");
			else
				System.out.println("Organic: Yes");
			System.out.println("Expiration Date: "+haircares.get(8*c+5));
			System.out.println("Weight: "+haircares.get(8*c+6)+" g.");
			if(haircares.get(8*c+4).compareTo("0")==0)
				System.out.println("Medicated: No");
			else
				System.out.println("Medicated: Yes");
		}
		return "\n";
	}
	
	/**
	 * @return The Amount of Hair Care Stock
	 */
	public int showStock()
	{
		this.hStock=haircares.size()/8;
		return hStock;
	}
}
