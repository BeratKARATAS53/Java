import java.util.Date;

public class TextPost extends Post
{
	static Date date = new Date();
	
	/**
	 * @param text The post when posting.
	 * @param longitude Longitude information on which the text is shared.
	 * @param latitude The name of the latitude information that the video is shared on.
	 * @return
	 */
	public static String toString(String text, String longitude, String latitude)
	{
		System.out.print(text+"\nDate: "+Post.dateFormat.format(date)+"\nLocation: "+longitude+" "+latitude);
		return "\n-----------------------";
	}
}
