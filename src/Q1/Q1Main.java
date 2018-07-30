package Q1;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Q1Main {
    public static Random generator;
    public static void main(String[] args) {
	// write your code here
        generator = new Random();
        //test1();

        ListGraph graph = CreateDirectedAcyclicGraph();
        FrmGraph frm = new FrmGraph(graph,70);

        if ( is_undirected(graph)) {
            System.out.println("Graph is undirected");
        }
        else  {
            System.out.println("Graph is directed");
        }

        if ( is_acyclic_graph(graph)) {
            System.out.println("Graph is acyclic");
        }
        else {
            System.out.println("Graph is cyclic");
        }
        ShortestPath s= new ShortestPath(graph);
        ArrayList<Integer> path;

        path= s.getPath(0,9);
        System.out.println("Shortest PAth from 0 to 9");
        printPath(graph, path);

        path= s.getPath(3,9);
        System.out.println("Shortest PAth from 3 to 9");
        printPath(graph, path);


        path= s.getPath(3,8);
        System.out.println("Shortest PAth from 3 to 8");
        printPath(graph, path);


    }

    public static void printPath(ListGraph graph , ArrayList<Integer> path) {
        int source;
        int dest;
        List<Edge>[] edges = graph.getEdges();

        if ( path!=null) {
            for (int i=0; i<path.size()-1; i++) {
                source = path.get(i);
                dest = path.get(i+1);

                for ( Edge e : edges[source]) {
                    if ( e.getDest()== dest) {
                        System.out.println( "("+ source+ " , " +dest+")    w: " +   e.getWeight());
                    }
                }
            }
        }
    }

    public static void test1() {
        String type = "List" ;  // ""Matrix"
        boolean isDirected = true;
        ListGraph g;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of Vertices : ");
            g =(ListGraph) AbstractGraph.createGraph(scanner, isDirected, type);
            g.insert(new Edge(1,2));
            g.insert(new Edge(1,3));
            g.insert(new Edge(1,5));
            g.insert(new Edge(2,5));
            g.insert(new Edge(3,5));

            Iterator<Edge> iter = g.edgeIterator(1);
            Edge e;
            while ( iter.hasNext()) {
                e = iter.next();
                System.out.println(e);
            }
        }
        catch ( IOException exp) {
            System.out.println(exp.getMessage());
        }

    }

    public static ListGraph CreateDirectedAcyclicGraph() {
        String type = "List" ;  // ""Matrix"
        boolean isDirected = true;
        ListGraph graph=null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of Vertices ( enter 10 for test) : ");
            graph =(ListGraph) AbstractGraph.createGraph(scanner, isDirected, type);
            graph.insert(new Edge(0,1, 1+generator.nextInt(100)));
            graph.insert(new Edge(0,2,1+generator.nextInt(100)));
            graph.insert(new Edge(0,4,1+generator.nextInt(100)));
            graph.insert(new Edge(0,6,1+generator.nextInt(100)));
            graph.insert(new Edge(1,2,1+generator.nextInt(100)));

            graph.insert(new Edge(1,4,1+generator.nextInt(100)));
            graph.insert(new Edge(1,5,1+generator.nextInt(100)));
            graph.insert(new Edge(2,4,1+generator.nextInt(100)));
            graph.insert(new Edge(2,6,1+generator.nextInt(100)));
            graph.insert(new Edge(2,5,1+generator.nextInt(100)));

            graph.insert(new Edge(3,5,1+generator.nextInt(100)));
            graph.insert(new Edge(3,9,1+generator.nextInt(100)));
            graph.insert(new Edge(4,6,1+generator.nextInt(100)));
            graph.insert(new Edge(4,8,1+generator.nextInt(100)));
            graph.insert(new Edge(5,6,1+generator.nextInt(100)));

            graph.insert(new Edge(5,9,1+generator.nextInt(100)));
            graph.insert(new Edge(6,7,1+generator.nextInt(100)));
            graph.insert(new Edge(6,8,1+generator.nextInt(100)));
            graph.insert(new Edge(7,8,1+generator.nextInt(100)));
            graph.insert(new Edge(8,9,1+generator.nextInt(100)));


            Point[] points= new Point[graph.getNumV()];
            points[0] = new Point(10,150);
            points[1] = new Point(100,50);
            points[2] = new Point(100,175);
            points[3] = new Point(100,300);
            points[4] = new Point(200,75);
            points[5] = new Point(200,150);
            points[6] = new Point(175,250);
            points[7] = new Point(300,50);
            points[8] = new Point(300,125);
            points[9] = new Point(300,250);
            graph.setPoints(points);

            Iterator<Edge> iter;
            Edge e;
            System.out.println("List of Edges");
            for ( int i=0; i<10; i++) {
                System.out.println("from Source " + i  );
                iter = graph.edgeIterator(i);
                while ( iter.hasNext()) {
                    e = iter.next();
                    System.out.println(e);
                }
                System.out.println();

            }

        }
        catch ( IOException exp) {
            System.out.println(exp.getMessage());
        }
        return graph;
    }

    public static boolean is_undirected(ListGraph graph) {

        List<Edge>[] edges = graph.getEdges();
        Iterator<Edge> iter1 , iter2;
        Edge e1, e2;
        boolean bidirected=false;

        for ( int i=0; i<edges.length; i++) {

            iter1 = edges[i].iterator();
            while( iter1.hasNext()) {
                e1= iter1.next();
                iter2 = edges[e1.getDest()].iterator();
                bidirected=false;
                while (iter2.hasNext()) {
                    e2=iter2.next();

                    if ( e1.getSource()== e2.getDest()) {
                        bidirected=true;
                    }
                    if ( bidirected && e1.getWeight() != e2.getWeight()) {
                        return false;
                    }
                }
                if ( !bidirected) {
                    return  false;
                }

            }
        }

        return true;

    }


    public static boolean is_acyclic_graph(ListGraph graph) {

        return !graph.hasCycle();
    }


}
