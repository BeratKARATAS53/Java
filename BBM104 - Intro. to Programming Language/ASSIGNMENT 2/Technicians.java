import java.util.ArrayList;

public class Technicians extends ServiceProviders
{
	ArrayList<String> technicians = new ArrayList<String>();
	
	public void setTechnicians(String name, String eMail, String dateOfBirth)
	{
		this.name = name;
		this.eMail = eMail;
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * listAdd method add items to technicians list.
	 * @param a is equal to items which wrote in items.txt, but it is only Technicians.
	 */
	public void listAdd(String a)
	{
		technicians.add(a);
	}
	
	public String toString()
	{
		int a = 1;
		for (int i=0 ; i<technicians.size()/5; i++)
		{
			if(technicians.get(5*i+4)=="1")
				System.out.println("Technician Name: "+technicians.get(5*i)+"\tID: "+a+"\tE-Mail: "+technicians.get(5*i+1)+"\tDate Of Birth: "+technicians.get(5*i+2)
				+"\tBalance: "+technicians.get(5*i+3)+"\tSenior ");
			else
				System.out.println("Technician Name: "+technicians.get(5*i)+"\tID: "+a+"\tE-Mail: "+technicians.get(5*i+1)+"\tDate Of Birth: "+technicians.get(5*i+2)
				+" \tBalance: "+technicians.get(5*i+3)+"\tNot Senior ");
			a++;
		}
		return "\n";
	}
}
