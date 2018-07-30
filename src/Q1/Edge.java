// Insert solution to programming exercise 1, section 2, chapter 10 here

package  Q1;

public class Edge {


    private int dest;
    private int source;
    private double weight;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }

    public int getDest() {
        return dest;
    }



    public int getSource() {
        return source;
    }


    public double getWeight() {
        return weight;
    }


    @Override
    public boolean equals(Object obj) {
        if (!  (obj instanceof  Edge)) {
            return false;
        }
        Edge other = (Edge)obj;
        if ( this.dest== other.dest && this.source== other.source ) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public String toString() {
        return source + " - " + dest + " w: " + weight ;
    }
}