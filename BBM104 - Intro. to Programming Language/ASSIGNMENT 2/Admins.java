import java.util.ArrayList;

public class Admins extends ServiceProviders
{
	public int salary;
	public String password;
	
	ArrayList<String> admins = new ArrayList<String>();
	
	public void setAdmins(String name, String eMail, String dateOfBirth, int salary, String password)
	{
		this.name = name;
		this.eMail = eMail;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.password = password;
	}
	
	/**
	 * listAdd method add items to admins list.
	 * @param a is equal to items which wrote in users.txt, but it is only Admins.
	 */
	public void listAdd(String a)
	{
		admins.add(a);
	}
	
	public String toString()
	{
		System.out.println("------------Admin Info------------");
		for (int i=0 ; i<admins.size()/5; i++)
		{
			System.out.println("Admin name: "+admins.get(5*i));
			System.out.println("Admin e-Mail: "+admins.get(5*i+1));
			System.out.println("Admin date of birth: "+admins.get(5*i+2)+"\n");
		}
		return "\n";
	}
}
