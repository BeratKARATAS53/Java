import java.text.*;
import java.util.*;

public abstract class Post implements PostInterface
{
	public static UUID postID = UUID.randomUUID();
	public static String text;
	
	static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	
}
