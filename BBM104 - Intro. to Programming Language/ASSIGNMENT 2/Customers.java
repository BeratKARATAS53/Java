import java.util.ArrayList;

public class Customers extends Users
{
	public int customerID;
	public String password;
	public int balance;
	public String status;
	
	ArrayList<String> shoppingCard = new ArrayList<String>();
	ArrayList<String> customers = new ArrayList<String>();
	
	public void setCustomers(String name, String eMail, String dateOfBirth,int customerID, String password, int balance, String status)
	{
		this.name = name;
		this.eMail = eMail;
		this.dateOfBirth = dateOfBirth;
		this.customerID = customerID;
		this.password = password;
		this.balance = balance;
		this.status = status;
	}
	
	public void shoppingCard(String item)
	{
		shoppingCard.add(item);
	}
	
	/**
	 * listAdd method add items to customers list.
	 * @param a is equal to items which wrote in users.txt, but it is only Customers.
	 */
	
	public void listAdd(String a)
	{
		customers.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int i=0 ; i<customers.size()/5; i++)
		{
			System.out.println("Customer Name: "+customers.get(5*i)+"\tID: "+a+"\tE-Mail: "+customers.get(5*i+1)+"\tDate Of Birth: "+customers.get(5*i+2)
			+"\tBalance: "+customers.get(5*i+3)+"\tPassword: "+customers.get(5*i+4));
			a++;
		}
		return "\n";
	}
	
	
}
