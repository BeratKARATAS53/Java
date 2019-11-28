import java.io.*;
import java.util.*;

public class Assignment1 {
	public static void main(String[] args) throws Exception {
		Scanner scanner1 = new Scanner(new File(args[0])); // First Argument: File Name
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>();
		titleList.add(scanner1.nextLine());
		
		// Read a file and first row add to titleList, other rows add to list1.
		while(scanner1.hasNextLine())
		{
		    Scanner scanner2 = new Scanner(scanner1.nextLine());
	        scanner2.useDelimiter(",");
	        ArrayList<String> list2 = new ArrayList<String>();
		    while(scanner2.hasNext())
		    {
		        list2.add(scanner2.next());
		    }
		    list1.add(list2);
			scanner2.close();
		}
		scanner1.close();
		
		double[] unsortedList = new double[list1.size()]; // Separate the desired column.
		for(int i=0; i<list1.size(); i++) {
			int col = Integer.parseInt(args[1]); // Second Argument: Which column ?
			String s = list1.get(i).get(col-1);
			unsortedList[i] = Double.parseDouble(s);
		}
		
		String save = args[2]; // Third Argument: Save (T) or Don't Save (F)
		
		
		ArrayList<ArrayList<String>> list2 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> list3 = new ArrayList<ArrayList<String>>();
		
		list2 = list1;
		list3 = list1;
		
		QuickSort quick = new QuickSort(unsortedList,list1);
		HeapSort heap = new HeapSort(unsortedList, list2);
		SelectionSorts sell = new SelectionSorts(unsortedList,list3);
		
		
		// Print sorted list to file
		if(save.equals("T")) {
			FileWriter writeFile = new FileWriter(args[0]); // First Argument: File Name
			writeFile.write(titleList.get(0));
			for(int a=0; a<list1.size(); a++) {
				writeFile.write(System.getProperty("line.separator"));
				for(int b=0; b<list1.get(1).size(); b++) {
					if(b!=(list1.get(1).size()-1))
						writeFile.write(list1.get(a).get(b)+", ");
					else
						writeFile.write(list1.get(a).get(b));
				}
			}
			writeFile.close();
		}
	}
}

class SelectionSorts extends Assignment1 {
	SelectionSorts(double[] array1, ArrayList<ArrayList<String>> array2) {
		selectionSort(array1, array2);
	}
	
	static void selectionSort(double[] array, ArrayList<ArrayList<String>> array2) {
		for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) 
                    index = j;
            }
            double smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
            
            arraySort(array2, index, i);
        }
	}
	
	static void arraySort(ArrayList<ArrayList<String>> array2, int index, int i) {
		ArrayList<String> first = array2.get(index);
		array2.set(index, array2.get(i));
		array2.set(i, first);
	}
}

class HeapSort {
	HeapSort(double[] array1, ArrayList<ArrayList<String>> array2) {
		heapSort(array1, array2);
	}
	
    static void heapSort(double arr[], ArrayList<ArrayList<String>> array2)
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, array2);
        for (int i=n-1; i>=0; i--)
        {
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            arraySort(array2, 0, i);
            heapify(arr, i, 0, array2);
        }
    }
    
    static void heapify(double arr[], int n, int i, ArrayList<ArrayList<String>> array2)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
 
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            arraySort(array2, i, largest);
            heapify(arr, n, largest, array2);
        }
    }
	
	static void arraySort(ArrayList<ArrayList<String>> array2, int index, int i) {
		ArrayList<String> first = array2.get(index);
		array2.set(index, array2.get(i));
		array2.set(i, first);
	}
}

class QuickSort extends Assignment1 {
	QuickSort(double[] array, ArrayList<ArrayList<String>> array2) {
		quickSort(array,array2);
	}
	
	static int partition(double[] array, int low, int high, ArrayList<ArrayList<String>> array2) {
		 int i = low, j = high+1;
		 while (true) {
			 while (array[++i] < array[low])
				 if (i == high) break;
			 while (array[low] < array[--j])
				 if (j == low) break;

		 	if (i >= j) break;
		 	exch(array, i, j);
		 	arraySort(array2, i, j);
		 	
		 }
		 exch(array, low, j);
		 arraySort(array2, low, j);
		 return j;
	}
	
	static void exch(double[] array, int index, int i) {
		double smallerNumber = array[index];
	    array[index] = array[i];
	    array[i] = smallerNumber;
	}
	
	static void arraySort(ArrayList<ArrayList<String>> array2, int index, int i) {
		ArrayList<String> first = array2.get(index);
		array2.set(index, array2.get(i));
		array2.set(i, first);
	}
		
	static void quickSort(double[] array, ArrayList<ArrayList<String>> array2) {
		randomize(array,array.length,array2);
		sort(array, 0, array.length - 1, array2);
	}
	
	static void sort(double[] array, int low, int high, ArrayList<ArrayList<String>> array2) {
		if (high <= low) return;
		int j = partition(array, low, high, array2);
	 	sort(array, low, j-1, array2);
	 	sort(array, j+1, high, array2);
	}
		
	static void randomize(double[] arr, int n, ArrayList<ArrayList<String>> array2) {
	    Random r = new Random();
	         
	    for (int i = n-1; i > 0; i--) {
	             
	        int j = r.nextInt(i);
	             
	        double temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	        
	        ArrayList<String> first = array2.get(i);
			array2.set(i, array2.get(j));
			array2.set(j, first);
	    }
	}
}