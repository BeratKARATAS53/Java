import java.util.ArrayList;

public class SkinCare extends Cosmetics
{
	public int sStock2;
	ArrayList<String> skincares = new ArrayList<String>();
	
	/**
	 * listAdd method add items to skincares list.
	 * @param a is equal to items which wrote in items.txt, but it is only Skin Cares. 
	 */
	public void listAdd(String a)
	{
		skincares.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<skincares.size()/8; c++)
		{
			System.out.println("----------------------------------\nType: "+skincares.get(8*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(skincares.get(8*c+1))+" $");
			System.out.println("Manufacturer: "+skincares.get(8*c+2));
			System.out.println("Brand: "+skincares.get(8*c+3));
			if(skincares.get(8*c+4).compareTo("0")==0)
				System.out.println("Organic: No");
			else
				System.out.println("Organic: Yes");
			System.out.println("Expiration Date: "+skincares.get(8*c+5));
			System.out.println("Weight: "+skincares.get(8*c+6)+" g.");
			if(skincares.get(8*c+4).compareTo("0")==0)
				System.out.println("Baby Sensitive: No");
			else
				System.out.println("Baby Sensitive: Yes");
		}
		return "\n";
	}
	
	/**
	 * @return The Amount of Skin Care Stock
	 */
	public int showStock()
	{
		this.sStock2=skincares.size()/8;
		return sStock2;
	}
}
