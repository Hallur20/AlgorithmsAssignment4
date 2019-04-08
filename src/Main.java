
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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
        In in = new In("https://raw.githubusercontent.com/datsoftlyngby/soft2019spring-algorithms/master/Weeklies/Week_11/04-assignment/Airline%20Network%20Data/routes.txt");
        String[] fileArr = in.readAllLines();

        String airportString = "https://raw.githubusercontent.com/datsoftlyngby/soft2019spring-algorithms/master/Weeklies/Week_11/04-assignment/Airline%20Network%20Data/airports.txt";

        In in2 = new In(airportString);

        String[] airport = in2.readAllLines();

        GraphDFS a = new GraphDFS(fileArr, airport);

        DepthFirstSearch b = new DepthFirstSearch();
        boolean[] Check = new boolean[fileArr.length];

        b.dfs(1, Check, a);

        //does breadfirstsearch on selected airport/airline to selected airport,
        //if there is a direct connection we get a 'yes' answer.
        //BreadthFirstSearch.breadthFirstSearchV1("2N", "ARN", "POR", fileArr);
        //(experimental) an undergoing method that tries to do the 'full' breadfirstsearch
        //, does not work fully yet but you can try it out!
        //BreadthFirstSearch.breadthFirstSearchV2(fileArr);
        Graph graph = new Graph();
        Dijkstra dj = new Dijkstra();
        //get shortest distance  starting at AER
        //dj.shotestDistance(graph, "C:\\Users\\Hallur\\Documents\\NetBeansProjects\\AlgorithmsAssignment4\\src\\Files\\routes.txt");

        //get shortest time starting at AER
        //dj.shotestTime(graph, "C:\\Users\\Hallur\\Documents\\NetBeansProjects\\AlgorithmsAssignment4\\src\\Files\\routes.txt");
        dj.printShortestPaths(graph);
    }

}
