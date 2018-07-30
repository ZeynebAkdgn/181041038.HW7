// Insert solution to programming project 1, chapter -1 here

package  Q1;


import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {

    double[][] edges;

    public  MatrixGraph(int numV, boolean isDirected) {
        super(numV, isDirected);

    }


    @Override
    public void insert(Edge edge) {

    }

    @Override
    public boolean isEdge(int source, int dest) {
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }



}