import java.util.ArrayList;

public class Heap extends Assignment2 {
    public Heap() { }

    public static void add(ArrayList<String> list) {
        int n = list.size();
        for (int k = n/2; k >= 1; k--)
            sink(list, k, n);
        while (n > 1) {
            exch(list, 1, n--);
            sink(list, 1, n);
        }
    }

    private static void sink(ArrayList<String> list, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(list, j, j+1))
            	j++;
            if (!less(list, k, j))
            	break;
            exch(list, k, j);
            k = j;
        }
    }

    private static boolean less(ArrayList<String> list, int i, int j) {
        return list.get(i-1).compareTo(list.get(j-1)) < 0;
    }

    private static void exch(ArrayList<String> list, int i, int j) {
    	String temp = list.get(i-1);
		list.set(i-1, list.get(j-1));
		list.set(j-1, temp);
    }
    
    public String max(ArrayList<String> list) {
    	int len = list.size();
    	return list.get(len-1);
    }
    public static void show(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}