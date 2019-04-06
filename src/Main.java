
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import models.Graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hallur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
      String filePath = "C:\\Users\\MoK\\Desktop\\MakeDijkstraWork\\src\\makedjkstrawork\\routes.txt";
        Graph graph = new Graph();
        Dijkstra dj = new Dijkstra();
        //dj.shotestDistance(graph);
        dj.shotestTime(graph,filePath);
        dj.printShortestPaths(graph);

    }
    
}
