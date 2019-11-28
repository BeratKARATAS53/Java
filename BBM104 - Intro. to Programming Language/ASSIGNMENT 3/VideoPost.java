import java.util.ArrayList;
import java.util.Date;

public class VideoPost extends TextPost
{
	public static int maxVideoLength = 10;
	public static String videoFileName;
	
	static ArrayList<String> tag = new ArrayList<String>();
	
	static Date date = new Date();
	
	/**
	 * @param text The text when posting.
	 * @param longitude Longitude information on which the video is shared.
	 * @param latitude The name of the latitude information that the video is shared on.
	 * @param video Shared video name.
	 * @param duration The length of the video above the name.
	 * @param tags Posted in videos tagged friends.
	 * @return
	 */
	public static String toString(String text, String longitude, String latitude, String video, String duration, String tags)
	{
		System.out.print(text+"\nDate: "+Post.dateFormat.format(date)+"\nLocation: "+longitude+", "+latitude+"\nVideo: "
				+video+"\nVideo Duration: "+duration+" minutes\nFriends tagged in this post: ");
		for (int i = 0; i < tag.size(); i++)
		{
			if (i==(tag.size()-1))
				System.out.print(tag.get(i).substring(0,1).toUpperCase()+tag.get(i).substring(1));
			else
				System.out.print(tag.get(i).substring(0,1).toUpperCase()+tag.get(i).substring(1)+", ");
		}
		return "\n-----------------------";
	}
}
