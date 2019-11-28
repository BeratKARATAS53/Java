import java.util.ArrayList;

public class MemoryList extends Assignment2{
    public ArrayList<String> list = new ArrayList<>();
    
    @Override
    public String toString() {
    	String temp = "";
        for(int i=0; i<list.size(); i++){
        	if(i==list.size()-1)
        		temp += list.get(i);   
        	else
        		temp += list.get(i)+" ";
        }
        return temp;
    }
}