package Q1;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ListGraph extends AbstractGraph {

    private List<Edge>[] edges;  //boyutu graphda kaç edge varsa o kadar
    private Point[] points;

    private boolean[] visited;



    public ListGraph(int numV, boolean isDirected) {  //Graph objeckti yaratılırken numV yollanır.
        super(numV, isDirected);
        edges = new List[numV];  //List array yaratılıyor. Herbir elamanı list olan bir array

        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();  //her bir elemanı sırasıyla edge obectlerini barındırıyor.
        }


    }

    /**
     *
     * @param points  Çizilecek vertexlerin konumlarını tutar. Graph çizileceği zaman bu array kullanılıyor.
     *
     */
    public void setPoints(Point[] points) {
        this.points = points;
    }

    public  Point[] getPoints() {
        return points;
    }

    /**
     *
     * @param edge grapha eklenecek olan edge
     * Bu edgein sourceunda belirtilen vertexin listesine bu edgei ekler.
     * Eğer graph directed ise, destinationa da ekler.
     */
    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest()].add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    /**
     * Bu edgein graph içinde olup olmadığına bakar.
     * @param source
     * @param dest
     * @return
     */
    @Override
    public boolean isEdge(int source, int dest) {
        return edges[source].contains(new Edge(source, dest));
    }

    @Override
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);

        for ( Edge edge: edges[source]) {
            if ( edge.equals(target)) {
                return edge;
            }
        }

        return target;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }


    public List<Edge>[] getEdges() {

        return edges;
    }

    /**
     * Graph içinde bir cycle olup olmadığına bakar, varsa true döndürür.
     * @return
     */
    public boolean hasCycle() {

        int previous=-1;
        for ( int i=0; i<getNumV(); i++) {  //0.noddan başlıyor. başlangıç 0,1,2 olduğundan cycle oluşuyor mu? recuresive olarka denetler.
            visited= new boolean[getNumV()];


            if ( hasCycle(previous, i)) {
                return true;
            }

        }

        return false;



    }

    /** recursive olarak graph içinde bir cycle olup olmadığına bakılıyor.
     * Depth First Search yaklaşımı ile bir cycle olup olmadığına bakıyor.
     *
     * @param previous
     * @param current
     * @return
     */
    private boolean hasCycle(int previous, int current ) {      //başlangıç nodundan
        Iterator<Edge> iter;
        Edge e;
        visited[current]=true;   //daha önce ulaştığım nodu visited olarak belirlenir.

         iter = edges[current].iterator();       //o'dan çıkan vertexleri alıyor.
        boolean hascycle=false;
        while (iter.hasNext()) {            //her bir nodda ilerliyor. Bakıp daha önce geçilmiş mi diye bakıyor.
            e= iter.next();                 //kendisine komşu olanları dolaşmaya başlıyor. source :0 destination:1
            hascycle=false;                 //hascycle var mı diye bakıyor
            if ( isDirected()) {
                if (visited[e.getDest()]) {     //hedef nodun daha önce ziyaret edilip edilmediğine bakar.
                    return true;
                } else {
                    hascycle= hasCycle(current, e.getDest());

                }
            }
            else { // undirected
                if ( e.getDest()!=previous) {
                    if (visited[e.getDest()]) {

                        return true;
                    } else {
                        hascycle= hasCycle(current, e.getDest());
                    }
                }
            }
            if ( hascycle) return true;

        }
        visited[current]=false;

        return false;
    }
}
