// Bellman Ford's Algorithm
public class Graph
{
    class Edge
    {
        int weight; // weight of the edge
        int start; // source node of the edge
        int end; // destination node of the edge
        Edge()
        {
            weight=0;
            start=0;
            end =0;
        }
    }

    Edge edge[];
    int V,E; // total vertices and Edges of the graph

    Graph(int vertices, int edges) // create a graph
    {
        V = vertices;
        E = edges;
        edge = new Edge[E];
        for(int i=0; i<E;i++)
        {
            edge[i] = new Edge();
        }
    }

    void BellmanFord(int start,Graph g)
    {
        int E = g.E;
        int V = g.V;
        int dist[] = new int[V];

        // initialize distances from source node to all the other nodes as Infinity.
        for(int i=0;i<V;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0; // initialize distance of start node to itself as zero.

        for(int i=0;i<V-1;i++) // V-1 iterations for V vertices
        {
            for(int j=0;j<E;j++)
            {
                int weight = g.edge[j].weight;
                int s = g.edge[j].start;
                int e = g.edge[j].end;
                if((dist[e] > dist[s] + weight) && (dist[s] != Integer.MAX_VALUE))
                {
                    dist[e] = dist[s] + weight;
                }

            }
        }

        // One more iteration to check for negative cycles.
        for(int j=0;j<E;j++)
        {
            int weight = g.edge[j].weight;
            int s = g.edge[j].start;
            int e = g.edge[j].end;
            if((dist[e] > dist[s] + weight) && (dist[s] != Integer.MAX_VALUE))
            {
                System.out.println("The Graph has negative cycle.");
            }

        }

        //print result
        //System.out.println("\nNo.    Vertex   Distance");
        System.out.println("\nNo.  Vertex  Distance");
        String names[] = {"s","t","x","y","z"};
        //String names[] = {"a","b","c","d","e"};
        for(int i=0; i<V;i++) {
            System.out.println(i + "  --  " + names[i]+"   --  "+ dist[i]);
        }
    }

    public static void main(String args[])
    {
        int vertices = 5;  // Number of vertices in graph
        int edges = 10;  // Number of edges in graph

        Graph graph = new Graph(vertices, edges);

        //*****************************************

        //s-->t : 6
        graph.edge[0].start = 0;
        graph.edge[0].end = 1;
        graph.edge[0].weight = 6;

        //s-->y : 7
        graph.edge[1].start = 0;
        graph.edge[1].end = 3;
        graph.edge[1].weight = 7;

        //t-->x : 5
        graph.edge[2].start = 1;
        graph.edge[2].end = 2;
        graph.edge[2].weight = 5;

        //t-->y : 8
        graph.edge[3].start = 1;
        graph.edge[3].end = 3;
        graph.edge[3].weight = 8;

        //t-->z : -5
        graph.edge[4].start = 1;
        graph.edge[4].end = 4;
        graph.edge[4].weight = -5;

        //x-->t : -2
        graph.edge[5].start = 2;
        graph.edge[5].end = 1;
        graph.edge[5].weight = -2;

        //y-->x : -3
        graph.edge[6].start = 3;
        graph.edge[6].end = 2;
        graph.edge[6].weight = -3;

        //y-->z : 9
        graph.edge[7].start = 3;
        graph.edge[7].end = 4;
        graph.edge[7].weight = 9;

        //z-->x : 7
        graph.edge[8].start = 4;
        graph.edge[8].end = 2;
        graph.edge[8].weight = 7;

        //z-->s : 2
        graph.edge[9].start = 4;
        graph.edge[9].end = 0;
        graph.edge[9].weight = 2;

        System.out.println("Part I :");
        graph.BellmanFord(0,graph);

        System.out.println("*****************************************");

        System.out.println("Part II : y-->x : -2");
        //y-->x : -3
        graph.edge[6].start = 3;
        graph.edge[6].end = 2;
        graph.edge[6].weight = -2;

        graph.BellmanFord(0,graph);

        System.out.println("\nEXECUTION COMPLETED");
    }
}
