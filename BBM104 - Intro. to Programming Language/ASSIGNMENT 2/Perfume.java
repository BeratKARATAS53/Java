import java.util.ArrayList;

public class Perfume extends Cosmetics
{
	public int pStock;
	
	ArrayList<String> perfumes = new ArrayList<String>();
	
	/**
	 * listAdd method add items to perfumes list.
	 * @param a is equal to items which wrote in items.txt, but it is only Perfumes. 
	 */
	public void listAdd(String a)
	{
		perfumes.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<perfumes.size()/8; c++)
		{
			System.out.println("----------------------------------\nType: "+perfumes.get(8*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(perfumes.get(8*c+1))+" $");
			System.out.println("Manufacturer: "+perfumes.get(8*c+2));
			System.out.println("Brand: "+perfumes.get(8*c+3));
			if(perfumes.get(8*c+4).compareTo("0")==0)
				System.out.println("Organic: No");
			else
				System.out.println("Organic: Yes");
			System.out.println("Expiration Date: "+perfumes.get(8*c+5));
			System.out.println("Weight: "+perfumes.get(8*c+6)+" g.");
			System.out.println("Lasting Duration: "+perfumes.get(8*c+7)+" min.");
		}
		return "\n";
	}
	
	/**
	 * @return The Amount of Book 
	 */
	public int showStock()
	{
		this.pStock=perfumes.size()/8;
		return pStock;
	}
}
