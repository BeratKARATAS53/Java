import java.util.*;

class DFSGraph extends Graph{
    private int V;
    private LinkedList<Integer> adj[];
    
    DFSGraph(int v) {
    	super(v);
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }
    
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> DFSUtil(int v, boolean visited[], ArrayList<String> pairs) {
        visited[v] = true;

    	list.add(pairs.get(v));
        
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, pairs);
        }
        return list;
    }

    ArrayList<String> DFS(int v, ArrayList<String> pairs) {
    	
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        return DFSUtil(v, visited, pairs);
    }
}