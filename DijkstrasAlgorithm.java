import java.io.InputStream;
import java.util.*;

public class DijkstrasAlgorithm {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("What file do you want to read? ");
        String filename = scan.nextLine();
        processFile(filename);
    }

    public static void dijkstra(Graph g, String start, String finish)
    {
        Map<String, Integer>dist = new HashMap<String,Integer>();
        Map<String,String>prev = new HashMap<String,String>();
        PriQueue<String, Integer> pq = new PriQueue<String, Integer>(true);

        for(String currVer : g.getVertices()){
            dist.put(currVer,Integer.MAX_VALUE);
            prev.put(currVer,"undefined");
        }
        dist.put(start,0);
        pq.add(start,0);

        while(!pq.isEmpty()){
            String u = pq.remove();
            System.out.println("Visiting vertex " + u);

            if(u.equals(finish)){
                break;
            }

            for(String v : g.getAdjacentVerticesFrom(u)){
                int alt = dist.get(u) + g.getWeight(u,v);
                if(alt < dist.get(v)){
                    System.out.print("  Updating dist[" + v + "] from " + dist.get(v));
                    dist.put(v,alt);
                    System.out.print(" to "+ dist.get(v));
                    System.out.println();
                    prev.put(v,u);
                    if(pq.contains(v)){
                        pq.changePriority(v,alt);
                    }
                    else{
                        pq.add(v,alt);
                    }
                }
            }
            System.out.println();
        }

        System.out.println();

        //getting the shortest distance
        ArrayList<String> shortPath = new ArrayList<>();
        String next = finish;
        shortPath.add(finish);
        for(String key : prev.keySet()){
                next = prev.get(next);
                if(next.equals("undefined")){
                    break;
                }
                shortPath.add(next);
        }
        Collections.reverse(shortPath);
        System.out.print("Shortest path is: ");
        for(int i =0; i<shortPath.size();i++){
            System.out.print(shortPath.get(i) + " ");
        }

        System.out.println();
        System.out.println("Distance is: "+ dist.get(finish));
        System.out.println();

        System.out.println("Final dist map:");
        for(String key : dist.keySet()){
            System.out.println(key + ": " + dist.get(key));
        }
        System.out.println();

        System.out.println("Final prev map:");
        for(String key : prev.keySet()){
            System.out.println(key + ": " + prev.get(key));
        }

    }

    /**
     * Read the file specified to add proper items to the word frequencies.
     */
    private static void processFile(String filename) {
        InputStream is = DijkstrasAlgorithm.class.getResourceAsStream(filename);
        if (is == null) {
            System.err.println("Bad filename: " + filename);
            System.exit(1);
        }
        Scanner scan = new Scanner(is);

        // Make a blank graph.
        Graph g = new Graph();

        boolean directed = true;
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] words = line.split(" ");
            if (words.length == 1 && words[0].equals("undirected")) {
                directed = false;
            }
            for (int i = 0; i < words.length; i++) {
                if (directed) { //directed graph
                    if (words[i].equals("dijkstra")) {
                        System.out.println("Vertices: " + g.getVertices());
                        System.out.println("Edges:");
                        for (String currVer : g.getVertices()) {
                            for (String nextVer : g.getAdjacentVerticesFrom(currVer)) {
                                System.out.println(currVer + " -> " + nextVer + ": " + g.getWeight(currVer, nextVer));
                            }
                        }
                        dijkstra(g,words[1],words[2]);
                    } else if (words[i].equals("vertex")) {
                        g.addVertex(words[1]);
                        break;
                    } else if (words[i].equals("edge")) {
                        g.addEdge(words[1], words[2], Integer.parseInt(words[3]));
                        break;
                    }
                } else { //undirected graph
                    if (words[i].equals("dijkstra")) {
                        System.out.println("Vertices: " + g.getVertices());
                        System.out.println("Edges:");
                        for (String currVer : g.getVertices()) {
                            for (String nextVer : g.getAdjacentVerticesFrom(currVer)) {
                                System.out.println(currVer + " -> " + nextVer + ": " + g.getWeight(currVer, nextVer));
                            }
                        }
                        dijkstra(g,words[1],words[2]);
                    } else if (words[i].equals("vertex")) {
                        g.addVertex(words[1]);
                        break;
                    } else if (words[i].equals("edge")) {
                        g.addEdge(words[1], words[2], Integer.parseInt(words[3]));
                        g.addEdge(words[2], words[1], Integer.parseInt(words[3]));
                        break;
                    }
                }
            }
        }
        scan.close();
    }
}
