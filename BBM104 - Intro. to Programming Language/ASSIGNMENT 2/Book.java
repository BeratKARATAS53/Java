import java.util.ArrayList;

public class Book extends OfficeSuplies
{
	public int bStock;
	
	ArrayList<String> books = new ArrayList<String>();
	
	/**
	 * listAdd method add items to books list.
	 * @param a is equal to items which wrote in items.txt, but it is only Books.
	 */
	
	public void listAdd(String a)
	{
		books.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int c=0 ; c<books.size()/7; c++)
		{
			System.out.println("----------------------------------\nType: "+books.get(7*c));
			System.out.println("Item ID: "+a);
			System.out.println("Price: "+Double.parseDouble(books.get(7*c+1))+" $");
			System.out.println("Release Date: "+books.get(7*c+2));
			System.out.println("Title: "+books.get(7*c+3));
			System.out.println("Publisher: "+books.get(7*c+4));
			System.out.println("Author: "+books.get(7*c+5));
			System.out.println("Page: "+books.get(7*c+6)+" pages");
			a++;
		}
		return "";
	}
	
	/**
	 * @return The Amount of Book Stock
	 */
	public int showStock()
	{
		this.bStock=books.size()/7;
		return bStock;
	}
}
