import java.util.*;
import java.io.*;

public class Assignment3 {
	/**
	 * cosineSimilarity function calculate cosine similarity these two vectors.
	 * @param vector1 -- First Vector
	 * @param vector2 -- Second Vector
	 * @return -- return a cosine similarity.
	 */
	public static double cosineSimilarity(ArrayList<Double> vector1, ArrayList<Double> vector2) {
	    double Product = 0.0;
	    double lenghtVec1 = 0.0;
	    double lenghtVec2 = 0.0;
	    for (int i = 0; i < vector1.size(); i++) {
	        Product += vector1.get(i) * vector2.get(i);
	        lenghtVec1 += Math.pow(vector1.get(i), 2);
	        lenghtVec2 += Math.pow(vector2.get(i), 2);
	    }   
	    return Product / (Math.sqrt(lenghtVec1) * Math.sqrt(lenghtVec2));
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan1 = new Scanner(new File(args[0])); // Read Word Vector File.
		Scanner scan2 = new Scanner(new File(args[1])); // Read Word Pairs File.
		
		ArrayList<ArrayList<String>> wordVec = new ArrayList<ArrayList<String>>(); // Word Vector List.
		ArrayList<ArrayList<String>> wordPairs = new ArrayList<ArrayList<String>>(); // Word Pairs List

		FileWriter outputFile = new FileWriter(args[2]);
		
		/**
		 * wordVec file read and write to wordVec list.
		 */
		while(scan1.hasNextLine()) {
		    Scanner scanner1 = new Scanner(scan1.nextLine());
	        scanner1.useDelimiter(" ");
	        ArrayList<String> list1 = new ArrayList<String>();
		    while(scanner1.hasNext()) {
		        list1.add(scanner1.next());
		    }
		    wordVec.add(list1);
		    scanner1.close();
		}
		scan1.close();
		
		/**
		 * wordPairs file read and write to wordPairs list.
		 */
		while(scan2.hasNextLine()) {
			Scanner scanner2 = new Scanner(scan2.nextLine());
			scanner2.useDelimiter("-");
	        ArrayList<String> list2 = new ArrayList<String>();
	        while(scanner2.hasNext()) {
	        	list2.add(scanner2.next());
	        }
	        wordPairs.add(list2);
	        scanner2.close();
		}
		scan2.close();
		
		ArrayList<String> pairList = new ArrayList<String>(); // A list that holds each word.
		for(int z=0; z<wordPairs.size(); z++) {
			int count = 0;
			while(count<2) {
				pairList.add(wordPairs.get(z).get(count));
				count++;
			}
		}
		
		ArrayList<ArrayList<String>> graphList = new ArrayList<ArrayList<String>>(); // A list of graphs to create.
		for(int o=0; o<pairList.size(); o++) {
			String root = pairList.get(o); // The root is taken from pairList.
			ArrayList<Double> vectorRoot = new ArrayList<Double>(); // List of root vector values.
			
			for(int j=0; j<wordVec.size(); j++) { // Used to get the root's vectors.
				String vecStr = wordVec.get(j).get(0).substring(1, wordVec.get(j).get(0).length()-1);
				if(root.equals(vecStr)) {
					for(int m=1; m<wordVec.get(j).size(); m++)
						vectorRoot.add(Double.parseDouble(wordVec.get(j).get(m)));
				}
			}
			
			/**
			 * To create a complete graph, the root finds the vectors of all other words in a
			 * for loop to calculate similarity to each word and sends them to cosineSimilarity.
			 */
			for(int i=0; i<pairList.size(); i++) {
				ArrayList<Double> vector1 = new ArrayList<Double>();
				String s1 = pairList.get(i);
				
				if(s1.equals(root)) {}
				else {
					ArrayList<String> graphList2 = new ArrayList<String>();
					
					for(int j=0; j<wordVec.size(); j++) {
						String vecStr = wordVec.get(j).get(0).substring(1, wordVec.get(j).get(0).length()-1);
						if(s1.equals(vecStr)) {
							for(int m=1; m<wordVec.get(j).size(); m++)
								vector1.add(Double.parseDouble(wordVec.get(j).get(m)));
						}
					}
					double similarity = cosineSimilarity(vectorRoot, vector1); // Calculate similarity.
					if(similarity>0 && similarity<1) { // Cosine Similarity must be between 0-1 !!!
						graphList2.add(root);
						graphList2.add(s1);
						graphList2.add(Double.toString(1-similarity));

						graphList.add(graphList2); // This list is added to the first graphList to create a 2-dimensional list.
					}
				}
			}
		}
		selectionSort(graphList);
		Graph graph = new Graph(pairList, graphList);
		ArrayList<ArrayList<String>> list = graph.KruskalMST();
		
		int clusterNum = Integer.parseInt(args[3]);
		if(clusterNum==wordPairs.size()) {
			for(int p=0; p<clusterNum; p++) {
				for(int q=0; q<2; q++) {
					if(q!=1)
						outputFile.write(list.get(p).get(q)+",");
					else
						outputFile.write(list.get(p).get(q));
				}
				outputFile.write(System.getProperty( "line.separator" ));
			}
		}
		else {
			for(int p=0; p<5; p++) {
				if(p!=4)
					outputFile.write(list.get(p).get(0)+","+list.get(p).get(1)+",");
				else
					outputFile.write(list.get(p).get(0)+","+list.get(p).get(1));
			}
		}
		outputFile.close();
		
		
	}
	
	/**
	 * The sorting algorithm for the Kruskal's algorithm.
	 */
	static void selectionSort(ArrayList<ArrayList<String>> array) {
		for (int i = 0; i < array.size() - 1; i++)
        {
			int index = i;
            for (int j = i + 1; j < array.size(); j++) {
    			ArrayList<String> list1 = array.get(index);
    			ArrayList<String> list2 = array.get(j);
                if (list1.get(2).compareTo(list2.get(2))>0) 
                    index = j;
            }
            arraySort(array, index, i);
        }
	}
	
	static void arraySort(ArrayList<ArrayList<String>> array2, int index, int i) {
		ArrayList<String> first = array2.get(index);
		array2.set(index, array2.get(i));
		array2.set(i, first);
	}
}
