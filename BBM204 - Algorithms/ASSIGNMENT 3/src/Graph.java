import java.util.*;
 
public class Graph extends Assignment3 {
    class Edge implements Comparable<Edge> {
        int edge, vertex;
        double weight;
        
		@Override
		public int compareTo(Edge o) {
			return 0;
		}
    };

    class subset {
        int parent;
		int rank;
    };
    
    int V, E;
    Edge edge[];

	Map<String, Integer> G = new HashMap<String, Integer>(); // Dictionary
	ArrayList<String> pairs = new ArrayList<String>();
	
    public void graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    Graph(int v) {
    }
    
    Graph(ArrayList<String> pairList, ArrayList<ArrayList<String>> graphList) {
    	this.pairs = pairList;
		for(int i=0; i<pairList.size(); i++) {
			G.put(pairList.get(i), i);
		}
		graph(pairList.size(), graphList.size());
		
		/**
		 * Graph creation starts; The edges and the vertexes are added to Graph.
		 */ 	
		for(int j=0; j<graphList.size(); j++) {
			int E = G.get(graphList.get(j).get(0)); 
			int V = G.get(graphList.get(j).get(1));
			double W = Double.parseDouble(graphList.get(j).get(2));
			
	        edge[j].edge = E;
	        edge[j].vertex = V;
	        edge[j].weight = W;
		}
	}
    
	int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets of x and y (uses union by rank)
    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // Kruskal's Algorithm
    ArrayList<ArrayList<String>> KruskalMST() {
    	
        Edge result[] = new Edge[V];  // This will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<V; i++)
            result[i] = new Edge();
 
        // First of all, sort all the edges in non-decreasing order of their weight.
        Arrays.sort(edge);

        subset subsets[] = new subset[V];
        for(i=0; i<V; i++)
            subsets[i]=new subset();
        
        for (int v = 0; v < V; v++) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0;  // index used to pick next edge

        while (e < V - 3) {
        	
            // Secondly, pick the smallest edge.        	
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.edge);
            int y = find(subsets, next_edge.vertex);
            
            /**
             * If including this edge does't cause cycle,
             * include it in result and increment the index of result for next edge
             */
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
        
        // Thirdly, Depth First Search Algorithm
		DFSGraph dfs = new DFSGraph(result.length);
        for(int a=0; a<result.length-4; a++) {
        	dfs.addEdge(G.get(pairs.get(result[a].edge)), G.get(pairs.get(result[a].vertex))); // DFS graph create
        }
        
        ArrayList<ArrayList<String>> list3 = new ArrayList<ArrayList<String>>();
    	
        for(int j=0; j<pairs.size()-4; j++) {
        	String s1 = pairs.get(result[j].edge);
        	
        	dfs.DFS(G.get(s1), pairs);
        }
        for (i = 0; i < e; ++i) {
        	ArrayList<String> list = new ArrayList<>();
        	list.add(pairs.get(result[i].edge));
        	list.add(pairs.get(result[i].vertex));
        	
            list3.add(list);
        }
        return list3;
    }
}