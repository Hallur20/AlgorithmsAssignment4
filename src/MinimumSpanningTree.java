/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hallur
 */
public class MinimumSpanningTree {

    private static final int Temprory = 1;
    private static final int Permanent = 2;
    private static final int NIL = -1;
    private static final int Infinity = 9999;

    public void mst(GraphMST graph) {
        int c, v;
        int edgesInTree = 0;
        int wtTree = 0;

        for (v = 0; v < graph.n; v++) {
            graph.listOfVertex[v].status = Temprory;
            graph.listOfVertex[v].lenght = Infinity;
            graph.listOfVertex[v].predecessor = NIL;

        }

        int root = 0;
        graph.listOfVertex[root].lenght = 0;

        while (true) {
            c = temproraryVertexMinL(graph);

            if (c == NIL) {
                if (edgesInTree == graph.n - 1) {
                    System.out.println("Weight of minimum spanning tree is:" + wtTree);
                    return;
                } else {
                    throw new RuntimeException("Graph is not connect");

                }
            }
            graph.listOfVertex[c].status = Permanent;

            if (c != root) {
                edgesInTree++;
                System.out.println("(" + graph.listOfVertex[c].predecessor + "," + c + ")");
                wtTree = wtTree + graph.adj[graph.listOfVertex[c].predecessor][c];
            }

            for (v = 0; v < graph.n; v++) {

                if (c != v && c != v && graph.listOfVertex[v].status == Temprory);
                {
                    graph.listOfVertex[v].lenght = graph.adj[c][v];
                    graph.listOfVertex[v].predecessor = c;
                }
            }

        }
    }

    private int temproraryVertexMinL(GraphMST graph) {

        int min = Infinity;
        int x = NIL;
        for (int v = 0; v < graph.n; v++) {
            if (graph.listOfVertex[v].status == Temprory && graph.listOfVertex[v].lenght < min) {
                min = graph.listOfVertex[v].lenght;
                x = v;
            }
        }

        return x;

    }
}
