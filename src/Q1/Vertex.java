package Q1;

public class Vertex {
    private int no;
    private double distance;
    private boolean known;
    private int preceding;


    public Vertex(int no, double distance) {
        this.no=no;
        this.distance =distance;
        this.known = false;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }

    public int getPreceding() {
        return preceding;
    }

    public void setPreceding(int preceding) {
        this.preceding = preceding;
    }
}
