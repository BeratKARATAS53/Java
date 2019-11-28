import java.util.ArrayList;


public class UserCollection extends User
{
	static ArrayList<String> users = new ArrayList<String>();
	
	public UserCollection()
	{
	}	
	
	public static void addUser(String name, String username, String password, String birthDate, String school)
	{
		users.add(name); users.add(username); users.add(password); users.add(birthDate); users.add(school); 
	}
	
	
	/**
	 * @param userID is the ID number of the deleted person.
	 * @return If the person to be deleted is in the user list, it will be deleted by returning a "true" statement,
	 * or else this person will return a "false" expression between the users, so that this person remains on the list.
	 */
	public static boolean removeUser(int userID)
	{
		if(userID <= (UserCollection.users.size()/5))
		{
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * @param username is the username of the person who wants to login to the system.
	 * @param password is the password that this user has already specified and should be used to log in to the system.
	 * @return If the username and password match the username and password registered on the system,
	 * it will enable the user to login to the system by returning "true" or prevent the system from entering the system by returning "false" if not.
	 */
	public static boolean userSignIn(String username, String password)
	{
		if (UserCollection.users.contains(username) && UserCollection.users.contains(password))
		{
			return true;
		}
		else if (UserCollection.users.contains(username) && !UserCollection.users.contains(password))
		{
			System.out.println("Invalid username and password. Please try again.");
			return false;
		}
		else if (UserCollection.users.contains(password) && !UserCollection.users.contains(username))
		{
			System.out.println("Invalid username and password. Please try again.");
			return false;
		}
		else
			System.out.println("No such user!");
			return false;
	}
	
	/**
	 * @param username The person whose post is desired to be displayed.
	 */
	public static void showPosts(String username)
	{
		System.out.println("**************\n"+username+"'s Posts\n**************");
		for (int i = 0; i < User.posts.size(); i++)
		{
			if (User.posts.get(i).equals("ADDPOST-TEXT"))
			{
				System.out.println(TextPost.toString(User.posts.get(i+1), User.posts.get(i+2), User.posts.get(i+3)));
			}
			else if (User.posts.get(i).equals("ADDPOST-IMAGE"))
			{
				System.out.println(ImagePost.toString(User.posts.get(i+1), User.posts.get(i+2), User.posts.get(i+3),
						User.posts.get(i+5), User.posts.get(i+6), User.posts.get(i+4)));
			}
			else if (User.posts.get(i).equals("ADDPOST-VIDEO"))
			{
				System.out.println(VideoPost.toString(User.posts.get(i+1), User.posts.get(i+2), User.posts.get(i+3),
						User.posts.get(i+5), User.posts.get(i+6), User.posts.get(i+4)));
			}
		}
	}

}
