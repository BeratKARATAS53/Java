import java.util.ArrayList;
import java.util.Date;

public class ImagePost extends TextPost
{
	public static int[] resolution = new int[2];
	public static String imageFileName;
	
	static ArrayList<String> tag = new ArrayList<String>();
	
	static Date date = new Date();
	
	/**
	 * @param text The text when posting.
	 * @param longitude Longitude information on which the image is shared.
	 * @param latitude The name of the latitude in which the image is shared.
	 * @param image The name of the shared image.
	 * @param resulotion The name on the size of your image.
	 * @param tags Friends tagged in the images posted.
	 * @return
	 */
	public static String toString(String text, String longitude, String latitude, String image, String resulotion, String tags)
	{
		System.out.print(text+"\nDate: "+Post.dateFormat.format(date)+"\nLocation: "+longitude+", "+latitude+"\nImage: "
				+image+"\nImage Resulotion: "+resulotion+"\nFriends tagged in this post: ");
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
