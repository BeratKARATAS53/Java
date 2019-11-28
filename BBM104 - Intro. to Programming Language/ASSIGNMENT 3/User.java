import java.util.ArrayList;
import java.util.Date;

public class User
{
	public static int totalNumberOfUsers;
	public static int userID;
	public String password;
	public String name;
	public String username;
	public Date dateOfBirth;
	public String schoolGraduated;
	public Date lastLogin;
	public static boolean signedIn;
	
	static ArrayList<String> blockedUsers = new ArrayList<String>();
	static ArrayList<String> blockedFriends = new ArrayList<String>();
	static ArrayList<String> posts = new ArrayList<String>();
	static ArrayList<String> friends = new ArrayList<String>();

	public String toString()
	{
		for (int i=0 ; i<UserCollection.users.size()/5; i++)
		{
			System.out.println("Name: "+UserCollection.users.get(5*i)+"\nUser Name: "+UserCollection.users.get(5*i+1)
			+"\nDate Of Birth: "+UserCollection.users.get(5*i+3)+"\nSchool: "+UserCollection.users.get(5*i+4)+"\n-----------------------");
		}
		return "\n";
	}
	
	/**
	 * @param name is the name of the person logging in.
	 */
	public static void addSignInUser(String name)
	{
		friends.add(name);
	}
	
	/**
	 * @param name is the name of the person added to the friends list.
	 */
	public static void addFriend(String name)
	{
		friends.add(name);
	}
	
	/**
	 * @param name is the name of the person deleted from the friends list.
	 */
	public static void removeFriend(String name)
	{
		int x = friends.indexOf(name);
		friends.remove(x);
	}
	
	/**
	 * @param name is the name of the person blocked from friends and added to the blockedFriends list.
	 */
	public static void addBlockedFriends(String name)
	{
		blockedFriends.add(name);
	}
	
	/**
	 * @param name is the name of the person blocked from all users and added to the blockedUsers list.
	 */
	public static void addBlockedUsers(String name)
	{
		blockedUsers.add(name);
	}	
}
