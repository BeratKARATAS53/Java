import java.io.*;
import java.util.*;


/**
 * @author BeratKARATAS
 * @since 04.04.2017
 */
public class Main
{
	private static Scanner scanner1;
	private static Scanner scanner2;
	private static Scanner scanner3;
	
	static Users u = new Users();
	static Customers c = new Customers();
	static Admins a = new Admins();
	static Technicians t = new Technicians();
	
	static Book b1 = new Book();
	static CDDVD c1 = new CDDVD();
	static Desktop d1 = new Desktop();
	static Laptop l1 = new Laptop();
	static Tablet t1 = new Tablet();
	static TV t2 = new TV();
	static SmartPhone s1 = new SmartPhone();
	static HairCare h1 = new HairCare();
	static Perfume p1 = new Perfume();
	static SkinCare s2 = new SkinCare();
	
	/**
	 * @param The Arguments are users.txt, item.txt, commands.txt.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
        try
        {
        	File file1 = new File("users.txt");
        	File file2 = new File("item.txt"));
        	File file3 = new File("commands.txt");
        	
            scanner1 = new Scanner(file1);
            scanner2 = new Scanner(file2);
            scanner3 = new Scanner(file3);
            
            while (scanner1.hasNextLine())
            {
                String line1 = scanner1.nextLine();
                String[] input = line1.split("\\t");
                for (int i = 1; i < input.length; i++) 
                {
                	switch (input[0])
                	{
                	case "ADMIN":
                		a.listAdd(input[i]); break;
                	case "CUSTOMER":
						c.listAdd(input[i]); break;
                	case "TECH":
						t.listAdd(input[i]); break;
	                default:
	                	u.listAdd(input[i]); break;
                	}
                }
            }
             
            while (scanner2.hasNextLine())
            {
                String line2 = scanner2.nextLine();
                String[] input2 = line2.split("\\t");
                for (int a = 0; a < input2.length; a++) 
                {
                	switch (input2[0])
                	{
					case "BOOK":
	                	b1.listAdd(input2[a]); break;
					case "CDDVD":
	                	c1.listAdd(input2[a]); break;
					case "DESKTOP":
	                	d1.listAdd(input2[a]); break;
					case "LAPTOP":
	                	l1.listAdd(input2[a]); break;
					case "TABLET":
	                	t1.listAdd(input2[a]); break;
					case "TV":
	                	t2.listAdd(input2[a]); break;
					case "SMARTPHONE":
	                	s1.listAdd(input2[a]); break;
					case "HAIRCARE":
	                	h1.listAdd(input2[a]); break;
					case "PERFUME":
	                	p1.listAdd(input2[a]); break;
					case "SKINCARE":
	                	s2.listAdd(input2[a]); break;
					}
                }
            }
            while (scanner3.hasNextLine())
            {
                String line2 = scanner3.nextLine();
                String[] input2 = line2.split("\\t");
                
                switch (input2[0]) {
				case "ADDCUSTOMER":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+"\t"+input2[3]+"\t"+input2[4]+"\t"+input2[5]+"\t"+input2[6]+">\n");						
					if(a.admins.contains(input2[1]))
					{
						for (int a = 2; a < 7; a++)
						{
							c.listAdd(input2[a]);
						}
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "ADDADMIN":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+"\t"+input2[3]+"\t"+input2[4]+">\n");						
					if(a.admins.contains(input2[1]))
					{
						for (int b = 2; b < 7; b++)
						{
							a.listAdd(input2[b]);
						}
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "ADDTECH":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+"\t"+input2[3]+"\t"+input2[4]+">\n");						
					if(a.admins.contains(input2[1]))
					{
						for (int a = 2; a < 7; a++)
						{
							t.listAdd(input2[a]);
						}
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "SHOWCUSTOMER":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+">\n");
					if(a.admins.contains(input2[1]))
					{
						System.out.println(c.toString());
						break;
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "SHOWCUSTOMERS":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(a.admins.contains(input2[1]))
					{
						System.out.println(c.toString());
						break;
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "SHOWADMININFO":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(a.admins.contains(input2[1]))
					{
						System.out.println(a.toString());
						break;
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "ADDITEM":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+">\n");
					if(t.technicians.contains(input2[1]))
					{
						System.out.println("\n");
					}
					else
						System.out.println("No technician person named "+input2[1]+" exists!\n");
					break;
				case "ADDTOCART":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+">\n");
					if(Integer.parseInt(input2[1])<=(c.customers.size()/5))
					{
						System.out.println("The item has been succesfully added to your card.\n");
					}
					else
						System.out.println("No customer with ID number "+input2[1]+" exists!\n");
					break;
				case "SHOWCAMPAIGNS":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(Integer.parseInt(input2[1])<=(c.customers.size()/5))
					{
						System.out.println("\n");
					}
					else
						System.out.println("No customer with ID number "+input2[1]+" exists!\n");
					break;
				case "DEPOSITMONEY":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+">\n");
					if(Integer.parseInt(input2[1])<=(c.customers.size()/5))
					{
						System.out.println("\n");
					}
					else
						System.out.println("No customer with ID number "+input2[1]+" exists!\n");
					break;
				case "EMPTYCART":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(Integer.parseInt(input2[1])<=(c.customers.size()/5))
					{
						System.out.println("The cart has been emptied.\n");
					}
					else
						System.out.println("No customer with ID number "+input2[1]+" exists!\n");
					break;
				case "SHOWORDERS":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(t.technicians.contains(input2[1]))
					{
						System.out.println("\n");
					}
					else
						System.out.println("No technician person named "+input2[1]+" exists!\n");
					break;
				case "SHOWVIP":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(a.admins.contains(input2[1]))
					{
						System.out.println("\n");
					}
					System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "DISPITEMSOF":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+">\n");
					if(t.technicians.contains(input2[1]))
					{
						System.out.println("\n");
					}
					else
						System.out.println("No admin or technician person named "+input2[1]+" exists!\n");
					break;
				case "CREATECAMPAIGN":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+"\t"+input2[3]+"\t"+input2[4]+"\t"+input2[5]+">\n");
					if(a.admins.contains(input2[1]) || t.technicians.contains(input2[1]))
					{
						if(Integer.parseInt(input2[5])<=50)
						{
							System.out.println("\n");
						}
						else
							System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.\n");
					}
					else
						System.out.println("No admin person named "+input2[1]+" exists!\n");
					break;
				case "ORDER":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+">\n");
					if(Integer.parseInt(input2[1])<=(c.customers.size()/5))
					{
						if(c.customers.contains(input2[2]))
						{
							System.out.println("You should add some items to your cart before order request!\n");
						}
						else
							System.out.println("Order could not be placed. Invalid password.\n");
					}
					else
						System.out.println("No customer with ID number "+input2[1]+" exists!\n");
					break;
				case "CHPASS":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+"\t"+input2[2]+"\t"+input2[3]+">\n");
					if(Integer.parseInt(input2[1])<=(c.customers.size()/5))
						for (int i = 0; i < c.customers.size();)
						{
							if(c.customers.contains(input2[2]))
							{
								c.customers.set(5*i+4, input2[3]);
								System.out.println("The password has been succesfully changed.\n");
								break;
							}
							else
							{
								System.out.println("The given password does not match the current password. Please try again.\n");
								break;
							}
						}
					else
						System.out.println("No customer with ID number "+input2[1]+" exists!\n");
					break;
				case "LISTITEM":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(a.admins.contains(input2[1]) || t.technicians.contains(input2[1]))
					{
						System.out.println(b1.toString()+c1.toString()+d1.toString()+l1.toString()+t1.toString()+t2.toString()
						+s1.toString()+h1.toString()+p1.toString()+s2.toString());
					}
					else
					{
						System.out.println("No admin or technician person named "+input2[1]+" exists!\n");
					}
					break;
				case "SHOWITEMSLOWONSTOCK":
					System.out.println("COMMAND TEXT : <"+input2[0]+"\t"+input2[1]+">\n");
					if(a.admins.contains(input2[1]) || t.technicians.contains(input2[1]))
					{
						System.out.println("Book: "+b1.showStock());
						System.out.println("CDDVD: "+c1.showStock());
						System.out.println("Desktop: "+d1.showStock());
						System.out.println("Laptop: "+l1.showStock());
						System.out.println("Tablet: "+t1.showStock());
						System.out.println("TV: "+t2.showStock());
						System.out.println("SmartPhone: "+s1.showStock());
						System.out.println("HairCare: "+h1.showStock());
						System.out.println("Perfume: "+p1.showStock());
						System.out.println("SkinCare: "+s2.showStock()+"\n");
					}
					else
					{
						System.out.println("No admin or technician person named "+input2[1]+" exists!\n");
					}
					break;
				}
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
	}
}
