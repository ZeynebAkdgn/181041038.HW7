package Q1;

import java.util.ArrayList;
import java.util.List;

public class ShortestPath {

    private ListGraph graph;
    private ArrayList<Vertex> vertices;
    private   List<Edge>[] edges;

    public ShortestPath(ListGraph graph) {
        this.graph = graph;
        edges = graph.getEdges();

        vertices = new ArrayList<>();


    }

    public ArrayList<Integer> getPath(int v1, int v2) {
        vertices.clear();
        for (int i = 0; i < graph.getNumV(); i++) {
            vertices.add(new Vertex(i, Double.MAX_VALUE));
        }
        vertices.get(v1).setDistance(0);
        shortestpath(v1);
        Vertex c;

        ArrayList<Integer> reversepath= new ArrayList<>();

        if ( vertices.get(v2).isKnown()) {
            reversepath.add(v2);
            c= vertices.get(v2);
            while ( c.getPreceding()!= v1) {
                c= vertices.get(c.getPreceding());
                reversepath.add(c.getNo());
            }
            reversepath.add(v1);

            ArrayList<Integer> path= new ArrayList<>();
            for( int i=reversepath.size()-1; i>=0; i--) {
                path.add(reversepath.get(i));
            }

            return  path;
        }
        else {
            return null;
        }


    }

    private void shortestpath(int v1) {

        Vertex v = vertices.get(v1);
        v.setKnown(true);
        if ( edges[v1].size()<0) {
            return;
        }
        for (Edge e : edges[v.getNo()]) {

            if (v.getDistance() + e.getWeight() < vertices.get(e.getDest()).getDistance()) {
                vertices.get(e.getDest()).setDistance(v.getDistance() + e.getWeight());
                vertices.get(e.getDest()).setPreceding(v.getNo());
            }
        }
        for ( Edge e: edges[v.getNo()] ) {
            if ( !vertices.get(e.getDest()).isKnown()) {
                shortestpath(e.getDest());
            }

        }
    }


}
