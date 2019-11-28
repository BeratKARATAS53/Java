import java.util.*;
import java.io.*;

public class Assignment2 {
	public static void main(String[] args) throws IOException {
		long tStart = System.currentTimeMillis(); // Time has begun !!!

		Scanner scan = new Scanner(new File(args[0])); // Reading File (args[0])
		scan.next();
		int memory = scan.nextInt(); // Size of Memory
		scan.next();
		String method = scan.next(); // Method to be used
		scan.next();
		
		Queue<String> q = new Queue<>();
		BST bst = new BST();
		Heap h = new Heap();
		
		PrintWriter output = new PrintWriter(new FileWriter("output.txt", true), true); // Output File
		
		output.write("Memory "+memory+"\n"+method+" Page Replacement"+"\nBinary Search Tree\n\n");

		LinkedList<String> list1 = new LinkedList<>(); // List of all values held.
		MemoryList memoryList = new MemoryList(); // The list of memory in the desired size.
		
		/**
		 * The data is read from the file and written to list1.
		 */
		while(scan.hasNext()) {
			String s1 = scan.next();
			if(s1.equals("Read")) {
				String s2 = scan.next();
				list1.add(s2);
			}
		}
		scan.close();
		
		int page_faults = 0;
		switch (method) { // 3 Different methods, depending on which one is selected.
		case "FIFO":
			for (int i=0; i<list1.size(); i++)
	        {
	            if (q.size() < memory) // If The Queue is empty
	            {
	                if (!bst.search(list1.get(i))) // With Binary Search Tree; Is the element added before the control?
	                {
	                	memoryList.list.add(list1.get(i));
	                    bst.insert(list1.get(i));
	                    q.enqueue(list1.get(i));
	                    
	                    page_faults++;

	                    output.write("Page Fault\t"+memoryList.toString()+"\n");
	                }
	                else
	                	output.write("          \t"+memoryList.toString()+"\n");
	            }
	            else // If The Queue is full
	            {
	               if(!bst.search(list1.get(i)))  // With Binary Search Tree; Is the element added before the control?
	                {
	                    String s = q.poll(); // Set Queue first added element
		            	
	                    bst.delete(s); // The specified element is deleted from the Tree.
	                    int index = memoryList.list.indexOf(s); // The specified element has the index in memory.
	                    memoryList.list.set(index, list1.get(i)); // It is replaced with the element to be added.
	                    
	                    bst.insert(list1.get(i)); // The same element is added to the Tree.
	                    
	                    q.enqueue(list1.get(i)); // The same element is added to the queue.
	                    
	                    page_faults++;
	                    output.write("Page Fault\t"+memoryList.toString()+"\n");
	                }
	                else 
	                	output.write("          \t"+memoryList.toString()+"\n");
	            }
	        }
			break;
		case "SecondChance":
			int[] chance = new int[memory]; // 	
		
			for(int e=0; e<memory; e++)
				chance[e] = 0;
			
			for (int i=0; i<list1.size(); i++)
        	{
            	if (q.size() < memory) // If The Queue is empty
            	{
                	if (!bst.search(list1.get(i))) // With Binary Search Tree; Is the element added before the control?
                	{
                		memoryList.list.add(list1.get(i));
                    	q.enqueue(list1.get(i));
                    	bst.insert(list1.get(i));
                    
                    	page_faults++;
                    	output.write("Page Fault\t"+memoryList.toString()+"\n");
                	}
                	else {
                		int index = memoryList.list.indexOf(list1.get(i));
                		chance[index] = 1;
                		output.write("          \t"+memoryList.toString()+"\n");
               		}
            	}
            	else // If The Queue is full
            	{
            		if(!bst.search(list1.get(i)))  // With Binary Search Tree; Is the element added before the control?
            		{
            			/**
            			 * Chance bit; If "1" is passed and this bit will be "0".
            			 * If "0", the index of that element is taken and the chances of the passed elements are reset.
            			 */
            			int index = 0;
                 	   	for(int r=0; r<chance.length; r++) {
                 	   		if(chance[r] == 0) {
                 	   			index += r;
                 	   			Arrays.fill(chance, 0);
                 	   			break;
                 	   		}
                 	   	}
                 	   	q.dequeue();
            			String s2 = memoryList.list.get(index); // The index element with the chance bit "0" is checked.
                		memoryList.list.set(index, list1.get(i)); // This element is replaced by the element to be added.
                		bst.delete(s2); // The element with the chance bit "0" is deleted from the tree.

            			bst.insert(list1.get(i)); // The same element is added to the binary search tree.

            			q.enqueue(list1.get(i)); // The same element is added to the queue.
            			
            			page_faults++;
            			
            			/**
            			 * If the chance bit is used; it is printed on the screen which elements have this bit.
            			 */
            			if(index!=0) {
            				String temp = "";
            				for(int y=0; y<index; y++)
            					temp += memoryList.list.get(y)+" ";
            			
            				output.write("Page Fault\t"+memoryList.toString()+"\tSecond Chance "+temp+"\n");
            			}
            			else
            				output.write("Page Fault\t"+memoryList.toString()+"\n");
            		}
            		else {
            			int index2 = i%memory;
            			chance[index2] = 1;
            			output.write("          \t"+memoryList.toString()+"\n");
            		}
            	}
        	}
			break;
		
		case "PriorityQueue":
        	ArrayList<String> heapList = new ArrayList<>();
			for (int i=0; i<list1.size(); i++)
	        {
	            if (q.size() < memory)
	            {
	                if (!bst.search(list1.get(i))) // With Binary Search Tree; Is the element added before the control?
	                {
	                	memoryList.list.add(list1.get(i));
	                	heapList.add(list1.get(i));
	                	q.enqueue(list1.get(i));
	                    bst.insert(list1.get(i));
	                    
	                    page_faults++;
	                    output.write("Page Fault\t"+memoryList.toString()+"\n");
	                }
	                else
	                	output.write("          \t"+memoryList.toString()+"\n");
	            }
	            else
	            {
	            	if(!bst.search(list1.get(i)))  // With Binary Search Tree; Is the element added before the control?
	                {
	                    h.add(heapList); // The list is being sent to the created Heap Tree.
	                    String max = h.max(heapList); // Find a maximum element of Heap Tree.
	                    
	                    bst.delete(max); // Maximum element is extracted from Binary Search Free.

	                    memoryList.list.set(memoryList.list.indexOf(max), list1.get(i)); // The maximum element is replaced with the element to be added.
	                    heapList.set(heapList.indexOf(max), list1.get(i)); // The replacement is also applied to the heap.
	                    bst.insert(list1.get(i)); // Finally, the modified element is added to binarySearchTree.
	                    
	                    
	                    page_faults++;
	                    output.write("Page Fault\t"+memoryList.toString()+"\n");
	                }
	                else
	                	output.write("          \t"+memoryList.toString()+"\n");
	            }
	        }
			break;
		default:
			break;
		}
        output.write(page_faults+"\n");

		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		String elapsed = Double.toString(elapsedSeconds);
		
		output.write(elapsed); // The elapsed time is printed.
		
		output.close();
		
	}
}
