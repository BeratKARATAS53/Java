import java.io.*;
import java.util.*;

/**
 * @author Berat KARATAS
 *
 */
public class Main
{
	private static Scanner scanner1;
	private static Scanner scanner2;
	
	public static int signedIN;
	
	static User u1 = new User();
	
	public Main()
	{
	}
	
	/**
	 * @param args The arguments are file1 and file2. File1 is the first "users.txt" file we need to read.
	 * By reading this file, we have reached our general user list. File2 is the second file "commands.txt".
	 * In this file, we see functions which we can find out with which commands we need to run the program.
	 */
	public static void main(String[] args)
	{
		try
        {
        	File file1 = new File("users.txt");
        	File file2 = new File("commands.txt");
        	
            scanner1 = new Scanner(file1);
            scanner2 = new Scanner(file2);
            
            while (scanner1.hasNextLine())
            {
            	String line1 = scanner1.nextLine();
                String[] input = line1.split("\\t");
                for (int i = 0; i < input.length; i++) 
                {
                	UserCollection.users.add(input[i]);
                }
            }
       
            while (scanner2.hasNextLine())
            {
                String line1 = scanner2.nextLine();
                String[] input = line1.split("\\t");
                	
                switch (input[0]) {					
				case "ADDUSER":
					System.out.println("----------------------"); 
					System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]+"\t"+input[3]+"\t"+input[4]+"\t"+input[5]);
					System.out.println(input[1]+" has been succesfully added.");
					UserCollection.addUser(input[1], input[2], input[3], input[4], input[5]);
					break;
					
				case "REMOVEUSER":
					System.out.println("----------------------"); System.out.print("COMMAND : "+input[0]+"\t"+input[1]+"\n");
					if (UserCollection.users.size()==0)
					{
						System.out.println("No such user!");
					}
					else
					{
						if (UserCollection.removeUser(Integer.parseInt(input[1])))
						{
							System.out.println("User has been successfully removed.");
							UserCollection.users.remove(5*(Integer.parseInt(input[1])-1)); UserCollection.users.remove(5*(Integer.parseInt(input[1])-1));
							UserCollection.users.remove(5*(Integer.parseInt(input[1])-1)); UserCollection.users.remove(5*(Integer.parseInt(input[1])-1));
							UserCollection.users.remove(5*(Integer.parseInt(input[1])-1));
						}
					}
					break;
					
				case "SIGNIN":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]);
					if (UserCollection.userSignIn(input[1], input[2]))
					{
						signedIN++;
						User.addSignInUser(input[1]);
						System.out.println("You have succesfully signed in.");
					}
					break;

				case "UPDATEPROFILE":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]+"\t"+input[3]);
					if (signedIN==1)
					{
						int x1 = UserCollection.users.indexOf(input[1]);
						if (UserCollection.users.contains(input[1]))
						{
							System.out.println("Your user profile has been succesfully updated.");
							UserCollection.users.set(x1+3, input[2]); UserCollection.users.set(x1+4, input[3]);
						}
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "CHPASS":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]);
					if (signedIN==1)
					{
						int x2 = UserCollection.users.indexOf(input[1]);
						if (UserCollection.users.contains(input[1]))
						{
							UserCollection.users.set(x2, input[2]);
							break;
						}
						else
						{
							System.out.println("Password mismatch! Please, try again.");
						}
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
						
				case "ADDFRIEND":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]);
					if (signedIN==1)
					{
						if (UserCollection.users.contains(input[1]))
						{
							if (User.friends.contains(input[1]))
							{
								System.out.println("This user is already in your friend list!");
							}
							else
							{
								User.addFriend(input[1]);
								System.out.println(input[1]+" has been successfully added to your friend list.");
							}
						}
						else
							System.out.println("No such user!");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "REMOVEFRIEND":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]);
					if (signedIN==1)
					{
						if (User.friends.contains(input[1]))
						{
							User.removeFriend(input[1]);
							System.out.println(input[1]+" has been successfully removed from your friend list.");
						}
						else
							System.out.println("No such friend!");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "ADDPOST-TEXT":
					System.out.println("----------------------");
					System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]+"\t"+input[3]+"\t"+input[4]);
					if (signedIN==1)
					{
						String[] tags = input[4].split(":");
						for (int j = 0; j < tags.length; j++)
						{
							if (User.friends.contains(tags[j]))
							{
							}
							else
								System.out.println("Username "+tags[j]+" is not your friend, and will not be tagged!");
						}
						for (int i = 0; i < 5; i++)
						{
							User.posts.add(input[i]);
						}
						System.out.println("The post has been succesfully added.");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "ADDPOST-IMAGE":
					System.out.println("----------------------");
					System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]+"\t"+input[3]+"\t"+input[4]+"\t"+input[5]+"\t"+input[6]);
					if (signedIN==1)
					{
						String[] tags = input[4].split(":");
						for (int j = 0; j < tags.length; j++)
						{
							ImagePost.tag.add(tags[j]);
							if (User.friends.contains(tags[j]))
							{
							}
							else
							{
								ImagePost.tag.remove(j);
								System.out.println("Username "+tags[j]+" is not your friend, and will not be tagged!");
							}
						}
						for (int i = 0; i < 7; i++)
						{
							User.posts.add(input[i]);
						}
						System.out.println("The post has been succesfully added.");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "ADDPOST-VIDEO":
					System.out.println("----------------------");
					System.out.println("COMMAND : "+input[0]+"\t"+input[1]+"\t"+input[2]+"\t"+input[3]+"\t"+input[4]+"\t"+input[5]+"\t"+input[6]);
					if (signedIN==1)
					{
						String[] tags = input[4].split(":");
						for (int j = 0; j < tags.length; j++)
						{
							VideoPost.tag.add(tags[j]);
							if (User.friends.contains(tags[j]))
							{
							}
							else
							{
								VideoPost.tag.remove(j);
								System.out.println("Username "+tags[j]+" is not your friend, and will not be tagged!");
							}	
						}
						for (int i = 0; i < 7; i++)
						{
							User.posts.add(input[i]);
						}
						System.out.println("The post has been succesfully added.");
					}					
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "REMOVELASTPOST":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]);
					if (signedIN==1)
					{
						if (User.posts.size()==0)
						{
							System.out.println("Error: you don't have any posts.");
						}
						else
						{
							if (User.posts.get(User.posts.size()-7).equals("ADDPOST-VIDEO") || User.posts.get(User.posts.size()-7).equals("ADDPOST-IMAGE"))
							{
								System.out.println("Your last post has been successfully removed.");
								for (int i = 0; i < 7; i++)
									User.posts.remove(User.posts.size()-1);
							}
							else if (User.posts.get(User.posts.size()-5).equals("ADDPOST-TEXT"))
							{
							System.out.println("Your last post has been successfully removed.");
								for (int i = 0; i < 5; i++)
									User.posts.remove(User.posts.size()-1);
							}
						}
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "SHOWPOSTS":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]);
					if (signedIN==1)
					{
						if (User.posts.size()==0)
						{
							System.out.println(input[1]+" does not have any posts yet.");
						}
						else
						{
							if (User.friends.get(0).equals(input[1]))
							{	
								UserCollection.showPosts(input[1]);
							}
							else
								System.out.println("No such user!");
						}
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "BLOCK":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]);
					if (signedIN==1)
					{
						if (UserCollection.users.contains(input[1]))
						{
							User.addBlockedUsers(input[1]);
							System.out.println(input[1]+" has been succesfully blocked.");
							if (User.friends.contains(input[1]))
							{
								User.addBlockedFriends(input[1]);
							}
						}
						else
							System.out.println("No such user!");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "SHOWBLOCKEDFRIENDS":
					System.out.println("----------------------"); System.out.print("COMMAND : "+input[0]+"\n");
					if (signedIN==1)
					{
						if (User.blockedFriends.size()==0)
						{
							System.out.println("You haven't blocked any friends yet!");
						}
						else
						{
							for (int i = 0; i < User.blockedFriends.size(); i++)
							{
								if (UserCollection.users.contains(User.blockedFriends.get(i)))
								{
									int count = UserCollection.users.indexOf(User.blockedFriends.get(i));
									System.out.println("Name: "+UserCollection.users.get(count-1)+"\nUser Name: "+UserCollection.users.get(count)
									+"\nDate Of Birth: "+UserCollection.users.get(count+2)+"\nSchool: "+UserCollection.users.get(count+3)+"\n-----------------------");
								}
							}
						}
					}	
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "SHOWBLOCKEDUSERS":
					System.out.println("----------------------"); System.out.print("COMMAND : "+input[0]+"\n");
					if (signedIN==1)
					{
						if (User.blockedUsers.size()==0)
						{
							System.out.println("You haven't blocked any users yet!");
						}
						for (int i = 0; i < User.blockedUsers.size(); i++)
						{
							if (UserCollection.users.contains(User.blockedUsers.get(i)))
							{
								int count = UserCollection.users.indexOf(User.blockedUsers.get(i));
								System.out.println("Name: "+UserCollection.users.get(count-1)+"\nUser Name: "+UserCollection.users.get(count)
								+"\nDate Of Birth: "+UserCollection.users.get(count+2)+"\nSchool: "+UserCollection.users.get(count+3)+"\n-----------------------");
							}
							
						}
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "UNBLOCK":
					System.out.println("----------------------"); System.out.println("COMMAND : "+input[0]+"\t"+input[1]);
					if (signedIN==1)
					{
						if (User.blockedFriends.contains(input[1]) || User.blockedUsers.contains(input[1]))
						{
							int count1 = User.blockedFriends.indexOf(input[1]); int count2 = User.blockedUsers.indexOf(input[1]);
							User.blockedFriends.remove(count1); User.blockedUsers.remove(count2);
							System.out.println(input[1]+" has been succesfully unblocked.");
						}
						else
							System.out.println("No such user in your blocked users list!");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "LISTUSERS":
					System.out.println("----------------------"); System.out.print("COMMAND : "+input[0]+"\n");
					if (signedIN==1)
					{
						System.out.println(u1.toString());
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "LISTFRIENDS":
					System.out.println("----------------------"); System.out.print("COMMAND : "+input[0]+"\n");
					if (signedIN==1)
					{
						if (User.friends.size()==1)
						{
							System.out.println("You haven't added any friend yet!");
						}
						for (int i = 1; i < User.friends.size(); i++)
						{
							if (UserCollection.users.contains(User.friends.get(i)))
							{
								int count = UserCollection.users.indexOf(User.friends.get(i));
								System.out.println("Name: "+UserCollection.users.get(count-1)+"\nUser Name: "+UserCollection.users.get(count)
								+"\nDate Of Birth: "+UserCollection.users.get(count+2)+"\nSchool: "+UserCollection.users.get(count+3)+"\n-----------------------");
							}	
						}	
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
					
				case "SIGNOUT":
					System.out.println("----------------------"); System.out.print("COMMAND : "+input[0]+"\n");
					if (signedIN==1)
					{
						signedIN--; User.blockedFriends.clear(); User.blockedUsers.clear();
						User.friends.clear(); User.posts.clear();
						System.out.println("You have succesfully signed out.");
					}
					else
						System.out.println("Error: Please sign in and try again.");
					break;
                }
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
	}
}
