import java.util.ArrayList;

public class Users
{
	public String name;
	public String eMail;
	public String dateOfBirth;
	
	ArrayList<String> users = new ArrayList<String>();
	
	public void setUsers(String name, String eMail, String dateOfBirth)
	{
		this.name = name;
		this.eMail = eMail;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * listAdd method add items to users list.
	 * @param a is equal to items which wrote in users.txt.
	 */
	public void listAdd(String a)
	{
		users.add(a);
	}
	
	public String toString()
	{
		System.out.println(" :USERS: ");
		for (int i=0 ; i<users.size()/5; i++)
		{
			System.out.println("User Name: "+users.get(5*i)+" E-Mail: "+users.get(5*i+1)+" Date Of Birth: "+users.get(5*i+2));
		}
		return "\n";
	}
}
