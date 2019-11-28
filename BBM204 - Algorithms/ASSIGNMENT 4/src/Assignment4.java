import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
// My assignment is not working on the big file. The small file also calculates the route incorrectly.
public class Assignment4 {
	
	/**
	 * The algorithm used to create the graph.
	 */
	public static final double INF = Double.MAX_VALUE/2;
    public String source;
    
    static class Neighbor {
        String id;
        double weight;
        String activeOrNot;
         
        public Neighbor(String id, double weight, String string){
            this.id = id;
            this.weight = weight;
            this.activeOrNot = string;
        }
    }
     
    static class PQ_Entry implements Comparable<PQ_Entry>{
        double distance;
        String id;
 
        public PQ_Entry(double distance, String id){
            this.id = id;
            this.distance = distance;
        }
 
        @Override
        public int compareTo(PQ_Entry o) {
            double diff = this.distance - o.distance;
            if(diff > 0) return 1;
            else if(diff < 0) return -1;
            else return 0;
        }
    }
    
    public static ArrayList<String> shortPath(HashMap<String, ArrayList<Neighbor>> graph, String source, String target, String nodes[]){
    	ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> pred = new HashMap<String, String>();
        for(String node : graph.keySet()){
            pred.put(node, node);
        }
         
        HashMap<String, Double> dist = new HashMap<String, Double>();
        for(String node : graph.keySet()){
            dist.put(node, INF);
        }
         
        dist.put(source, 0.0);
         
        PriorityQueue<PQ_Entry> pq = new PriorityQueue<PQ_Entry>();
        pq.add(new PQ_Entry(dist.get(source), source));
         
        while(!pq.isEmpty()){
            PQ_Entry u = pq.poll();
            if(u.distance == dist.get(u.id)){
                for(Neighbor v : graph.get(u.id)){
                    double w_uv = v.weight;
                    double alt = dist.get(u.id) + w_uv;
                    if(alt < dist.get(v.id)){
                        dist.put(v.id, alt);
                        pq.add(new PQ_Entry(dist.get(v.id), v.id));
                        pred.put(v.id, u.id);
                    }
                }
            }
        }
        
        if(dist.get(target).equals(INF)){
            System.out.println("No route!");
        }
        else{
            Stack<String> st = new Stack<String>();
            String node = target;
            while(! pred.get(node).equals(node)){
                st.push(node);
                node = pred.get(node);
            }
            st.push(node);
            while(!st.isEmpty()){
            	list.add(st.pop());
            }
            list.add(Double.toString(dist.get(nodes[Integer.parseInt(target)])));
        }
        return list;
    }
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan1 = new Scanner(new File(args[0])); // First File.
		Scanner scan2 = new Scanner(new File(args[1])); // SEcond File.
		Scanner scan3 = new Scanner(new File(args[2])); // Third File.
		
		ArrayList<ArrayList<ArrayList<String>>> topology = new ArrayList<>(); // Topology List
		ArrayList<ArrayList<String>> distance = new ArrayList<>(); // Distance List
		ArrayList<ArrayList<String>> commands = new ArrayList<>(); // Commands List
		
		
		
		while(scan1.hasNextLine()) // Read topology file and write topology list.
		{
		    Scanner scanner2 = new Scanner(scan1.nextLine());
	        scanner2.useDelimiter("\\W");
	        ArrayList<ArrayList<String>> list1 = new ArrayList<>();
	        String s = scanner2.next();
		    while(scanner2.hasNext())
		    {
		    	ArrayList<String> list2 = new ArrayList<>();
		    	list2.add(s);
		        list2.add(scanner2.next());
		        list1.add(list2);
		    }
		    topology.add(list1);
			scanner2.close();
		}
		scan1.close();
		
		while(scan2.hasNextLine()) { // Read distance file and write distance list.
		    Scanner scanner = new Scanner(scan2.nextLine());
	        scanner.useDelimiter("\\W");
			ArrayList<String> list = new ArrayList<>();
			while(scanner.hasNext()) {
				list.add(scanner.next());
				
			}
			distance.add(list);
			scanner.close();
		}
		scan2.close();
		
		/**
		 * Adding edge length between 2 vertices to topology list and specifying hanging is active.
		 */
		for(int i=0; i<topology.size(); i++) {
			for(int j=0; j<topology.get(i).size()-1; j++) {
				for(int k=0; k<distance.size(); k++) {
					if((topology.get(i).get(j).get(0).equals(distance.get(k).get(0)) && topology.get(i).get(j).get(1).equals(distance.get(k).get(1)))
							|| (topology.get(i).get(j).get(1).equals(distance.get(k).get(0)) && topology.get(i).get(j).get(1).equals(distance.get(k).get(0)))) {
						topology.get(i).get(j).add(2, distance.get(k).get(2));
						break;
					}
				}
				if(topology.get(i).get(j).get(0).equals(topology.get(i).get(topology.get(i).size()-1).get(0)) 
						&& topology.get(i).get(j).get(1).equals(topology.get(i).get(topology.get(i).size()-1).get(1))) {
					topology.get(i).get(j).add(3, "active");
				}
				else
					topology.get(i).get(j).add(3, "passive");
			}
			topology.get(i).remove(topology.get(i).size()-1);
		}
		
		while(scan3.hasNextLine()) { // Read commands file and write commands list.
			Scanner scanner = new Scanner(scan3.nextLine());
			scanner.useDelimiter("\\W");
			ArrayList<String> list = new ArrayList<>();
			while(scanner.hasNext()) {
				list.add(scanner.next());
			}
			commands.add(list);
			scanner.close();
		}
		scan3.close();

		ArrayList<String> maintain = new ArrayList<>();
		ArrayList<String> broke = new ArrayList<>();
		for(int i=0; i<commands.size(); i++) {
			switch (commands.get(i).get(0)) {
			case "MAINTAIN":
				maintain.add(commands.get(i).get(1));
				System.out.print("COMMAND IN PROCESS >> MAINTAIN "+commands.get(i).get(1)+"\n\tCommand \"MAINTAIN "+commands.get(i).get(1)+"\"  has been executed successfully!\r\n");
				break;
			case "SERVICE":
				maintain.remove(Integer.parseInt(commands.get(i).get(1)));
				System.out.print("COMMAND IN PROCESS >> SERVICE "+commands.get(i).get(1)+"\n\tCommand \"SERVICE "+commands.get(i).get(1)+"\"  has been executed successfully!\r\n");
				break;
			case "BREAK":
				broke.add(commands.get(i).get(1));
				broke.add(commands.get(i).get(2));
				System.out.print("COMMAND IN PROCESS >> BREAK "+commands.get(i).get(1)+">"+commands.get(i).get(2)+
						"\n\tCommand \"BREAK "+commands.get(i).get(1)+">"+commands.get(i).get(2)+"\"  has been executed successfully!\r\n");
				break;
			case "REPAIR":
				broke.remove(Integer.parseInt(commands.get(i).get(1)));
				broke.remove(Integer.parseInt(commands.get(i).get(2)));
				System.out.print("COMMAND IN PROCESS >> REPAIR "+commands.get(i).get(1)+">"+commands.get(i).get(2)+
						"\n\tCommand \"REPAIR "+commands.get(i).get(1)+">"+commands.get(i).get(2)+"\"  has been executed successfully!\r\n");
				break;
			case "ADD":
				System.out.print("COMMAND IN PROCESS >> ADD "+commands.get(i).get(1)+"\n\tCommand \"ADD "+commands.get(i).get(1)+"\"  has been executed successfully!\r\n");
				break;
			case "ROUTE":
				HashMap<String, ArrayList<Neighbor>> graph = new HashMap<String, ArrayList<Neighbor>>();
		        
		        String[] nodes = new String[topology.size()];
		        for(int m=0; m<topology.size(); m++)
		        	nodes[m] = Integer.toString(m);
		        
		        for(String node : nodes) {
		            graph.put(node, new ArrayList<Neighbor>());
		        }

		        double speed = Double.parseDouble(commands.get(i).get(3));
		        double switchTime = Double.parseDouble(args[3]);
		        for(int n=0; n<topology.size(); n++) {
		        	for(int j=0; j<topology.get(n).size(); j++) {
		        		if(topology.get(n).get(j).get(3).equals("active"))
		        			// If the path is active, it is added normally.
		        			graph.get(nodes[n]).add(new Neighbor(topology.get(n).get(j).get(1),Double.parseDouble(topology.get(n).get(j).get(2))/speed*60,topology.get(n).get(j).get(3)));
		        		else
		        			// If the path is not active, the switch duration is added.
		        			graph.get(nodes[n]).add(new Neighbor(topology.get(n).get(j).get(1),Double.parseDouble(topology.get(n).get(j).get(2))/speed*60+switchTime,topology.get(n).get(j).get(3)));
		        	}
		        }
		        // The DijKstra algorithm is applied.
		        ArrayList<String> result = shortPath(graph, nodes[Integer.parseInt(commands.get(i).get(1))], nodes[Integer.parseInt(commands.get(i).get(2))], nodes);
		        
		        int switchNum = 0; // How many times has the switch been applied while calculating the route?
		        for(int y=0; y<result.size()-1; y++) {
		        	for(int x=0; x<topology.get(Integer.parseInt(result.get(y))).size(); x++) {
		        		if(topology.get(Integer.parseInt(result.get(y))).get(x).get(0).equals(result.get(y))
		        				&& topology.get(Integer.parseInt(result.get(y))).get(x).get(1).equals(result.get(y+1))) {
		        			if(topology.get(Integer.parseInt(result.get(y))).get(x).get(3).equals("passive"))
		        				switchNum++;
		        			break;
		        		}
		        	}
		        }
		        double time = Double.parseDouble(result.get(result.size()-1));
		        result.remove(result.get(result.size()-1));

				System.out.print("COMMAND IN PROCESS >> ROUTE "+commands.get(i).get(1)+">"+commands.get(i).get(2)+" "+commands.get(i).get(3)
						+"\n\tTime (in min): "+time+"\n\tTotal # of switch changes: "+switchNum+"\n\tRoute from "+commands.get(i).get(1)+" to "+commands.get(i).get(2)+": ");
				for(int b=0; b<result.size(); b++) {
					if(b==result.size()-1)
						System.out.print(result.get(b));
					else
						System.out.print(result.get(b)+" ");
				}
				System.out.print("\n\tCommand \"ROUTE "+commands.get(i).get(1)+">"+commands.get(i).get(2)+" "+commands.get(i).get(3)+"\"  has been executed successfully!\r\n");
				break;
			case "LINK":
				System.out.print("COMMAND IN PROCESS >> LINK "+commands.get(i).get(1)+":");
				for(int f=2; f<commands.get(i).size()-1; f=f+2) {
					if(f==commands.get(i).size()-3)
						System.out.print(commands.get(i).get(f)+"-"+commands.get(i).get(f+1));
					else
						System.out.print(commands.get(i).get(f)+"-"+commands.get(i).get(f+1)+",");
				}
				System.out.print(">"+commands.get(i).get(commands.get(i).size()-1)+"\n\tCommand \"LINK "+commands.get(i).get(1)+":");
				for(int g=2; g<commands.get(i).size()-1; g=g+2) {
					if(g==commands.get(i).size()-3)
						System.out.print(commands.get(i).get(g)+"-"+commands.get(i).get(g+1));
					else
						System.out.print(commands.get(i).get(g)+"-"+commands.get(i).get(g+1)+",");
				}
				System.out.print(">"+commands.get(i).get(commands.get(i).size()-1)+"  has been executed successfully!\r\n");
				break;
			case "LISTROUTESFROM":
				System.out.print("COMMAND IN PROCESS >> LISTROUTESFROM "+commands.get(i).get(1)+"\r\n\tRoutes from "+commands.get(i).get(1)+": ");
				for(int n=0; n<topology.get(Integer.parseInt(commands.get(i).get(1))).size(); n++) {
					if(n==topology.get(Integer.parseInt(commands.get(i).get(1))).size()-1)
						System.out.print(topology.get(Integer.parseInt(commands.get(i).get(1))).get(n).get(1));
					else
						System.out.print(topology.get(Integer.parseInt(commands.get(i).get(1))).get(n).get(1)+" ");
		        }
				System.out.print("\n\tCommand \"LISTROUTESFROM "+commands.get(i).get(1)+"\"  has been executed successfully!\r\n");
				break;
			case "LISTMAINTAINS":
				System.out.print("COMMAND IN PROCESS >> LISTMAINTAINS\r\n\tIntersections under maintenance: ");
				Collections.sort(maintain);
				for(int h=0; h<maintain.size(); h++) {
					if(h==maintain.size()-1)
						System.out.print(maintain.get(h));
					else
						System.out.print(maintain.get(h)+" ");
				}
				System.out.print("\n\tCommand \"LISTMAINTAINS\"  has been executed successfully!\r\n");
				break;
			case "LISTACTIVERAILS":
				System.out.print("COMMAND IN PROCESS >> LISTACTIVERAILS\n\tActive Rails: ");
				for(int n=0; n<topology.size(); n++) {
		        	for(int j=0; j<topology.get(n).size(); j++) {
		        		if(topology.get(n).get(j).get(3).equals("active")) {
		        			if(n==topology.size()-1)
		        				System.out.print(topology.get(n).get(j).get(0)+">"+topology.get(n).get(j).get(1));
		        			else
		        				System.out.print(topology.get(n).get(j).get(0)+">"+topology.get(n).get(j).get(1)+" ");
		        		}
		        	}
		        }
				System.out.print("\n\tCommand \"LISTACTIVERAILS\"  has been executed successfully!\r\n");
				break;
			case "LISTBROKENRAILS":
				System.out.print("COMMAND IN PROCESS >> LISTBROKENRAILS\n\tBroken Rails: ");
				for(int k=0; k<broke.size(); k=k+2) {
					if(k==broke.size() || k==broke.size()-2 || k==broke.size()-1)
						System.out.print(broke.get(k)+">"+broke.get(k+1));
					else
						System.out.print(broke.get(k)+">"+broke.get(k+1)+" ");
				}
				System.out.print("\n\tCommand \"LISTBROKENRAILS\"  has been executed successfully!\r\n");
				break;
			case "LISTCROSSTIMES":
				System.out.print("COMMAND IN PROCESS >> LISTCROSSTIMES\r\n\tCommand \"LISTCROSSTIMES\" has not been executed successfully!\r\n");
				break;
			case "TOTALNUMBEROFJUNCTIONS":
				System.out.print("COMMAND IN PROCESS >> TOTALNUMBEROFJUNCTIONS\r\n\tCommand \"TOTALNUMBEROFJUNCTIONS\" has not been executed successfully!\r\n");
				break;
			case "TOTALNUMBEROFRAILS":
				System.out.print("COMMAND IN PROCESS >> TOTALNUMBEROFRAILS\r\n\tTotal # of rails: ");
				int railNum = 0;
				for(int z=0; z<topology.size(); z++) {
					for(int j=0; j<topology.get(z).size(); j++) {
						railNum++;
					}
				}
				System.out.print(railNum);
				System.out.print("\n\tCommand \"TOTALNUMBEROFRAILS\"  has been executed successfully!\r\n");
				break;
			default:
				System.out.print("COMMAND IN PROCESS >> "+commands.get(i).get(0)+"\r\n\tUnrecognized command \"TERMINATE\"!\r\n");
				break;
			}
		}
	}
}
