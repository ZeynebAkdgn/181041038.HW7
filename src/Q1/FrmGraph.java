package Q1;

import javax.swing.*;

public class FrmGraph  extends JFrame {

    private  GraphPanel panel;
    private ListGraph graph;

    public FrmGraph() {

        panel = new GraphPanel();

        this.setTitle("Graph");
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.getContentPane().add(panel);

    }

    public FrmGraph(ListGraph graph,int gap) {

        panel = new GraphPanel(graph,gap);
        this.setTitle("Graph");
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.getContentPane().add(panel);    //framin içeriği gösterilir.

    }
    public void setGraph(ListGraph graph) {
        this.graph = graph;
        panel.setGraph(graph);

    }
    public void setGap(int gap) {

        panel.setGap(gap);
    }

}
