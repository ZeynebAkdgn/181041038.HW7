package Q1;

import javax.swing.*;
import java.awt.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphPanel extends JPanel {

    private  ListGraph graph;
    private  int gap;

    public GraphPanel () {

        this(null,50);

    }
    public GraphPanel (ListGraph graph, int gap) {
        this.graph = graph;
        this.gap=gap;

    }

    public void setGraph(ListGraph graph) {
        this.graph = graph;
    }

    public void setGap(int gap) {
        this.gap=gap;

    }


    /**
     *
     *
     * @param graphic object
     * Panele gelen graph objectindeki bilgileri kullarak graphı görsel olarak çiziminin yapıldığı kısımdır.
     *Graphın içindeki point arrayınde yer alan değerleri kullanarak graphın vertexleri tek tek çiziliyor.
     *                Vertexler arası edgeler de bu point bilgilerini kullanarak çiziliyor.
     *
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if ( graph ==null) return;

        List<Edge>[] edges = graph.getEdges();  //Linked list arrayı
        Iterator<Edge> iter ;       //data kısmı edge olan bir iterator
        Edge e;
        g.setFont(new Font("Arial",Font.PLAIN, 20));

        int x, y;
        int x1,y1,x2,y2;
        Point[] points= graph.getPoints();
        for ( int i=0; i<edges.length; i++) {       //herbir vertex dolaşılıyor
            x = points[i].x;                    //i.vertixin konumunu (x,y) alıyoruz.
            y = points[i].y;
            g.drawString(""+i,x+8,y+23);     //vertexin labeli
            g.drawOval(x,y,30,30);     //oval çizildi

            iter = edges[i].iterator();
            while( iter.hasNext()) {        //linked list olan edges[i] iterator aracılığla erişilir. hasNext başka eleman var mı yok mu?
               e= iter.next();                 //eğer kendinden sonra edge varsa iter.next null olmaz. Konumlandığı edge objectidir.
               x1 = points[e.getSource()].x+15;
               y1 = points[e.getSource()].y+15;
               x2 = points[e.getDest()].x+10;
               y2 = points[e.getDest()].y+10;
               g.drawLine(x1,y1,x2,y2);   //source ve derstination pointlerin arasına çizgi çiziliyor.

            }
        }

    }
}
