
import edu.princeton.cs.algs4.In;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hallur
 */
public class Dijkstra {
      public Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0.0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = minDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Double> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Double edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    //CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    Double sourceDistance = currentNode.getDistance();
                    if (sourceDistance + edgeWeigh < adjacentNode.getDistance()) {
                        adjacentNode.setDistance(sourceDistance + edgeWeigh);
                        LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
                        shortestPath.add(currentNode);
                        adjacentNode.setShortestPath(shortestPath);
                    }
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private Node minDistanceNode(Set<Node> unfineshedNodes) {
        Node lowestDistanceNode = null;
        Double lowestDistance = Double.MAX_VALUE;
        for (Node node : unfineshedNodes) {
            Double nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public void shotestDistance(Graph graph, String filePath) {
        In in2 = new In(filePath);
        String[] arr2 = in2.readAllLines();

        for (int i = 1; i < arr2.length; i++) {
            Node nodeA = new Node(arr2[i].split(";")[1]);
            Node nodeB = new Node(arr2[i].split(";")[2]);
            String distance = arr2[i].split(";")[3];
            double d = Double.parseDouble(distance);
            nodeA.addDestination(nodeB, d);
            graph.addNode(nodeA);
            graph.addNode(nodeB);
            Dijkstra dd = new Dijkstra();
            graph = dd.calculateShortestPathFromSource(graph, nodeA);
        }
    }

    public void shotestTime(Graph graph, String filePath) {
        In in2 = new In(filePath);
        String[] arr2 = in2.readAllLines();
        for (int i = 1; i < arr2.length; i++) {
            Node nodeA = new Node(arr2[i].split(";")[1]);
            Node nodeB = new Node(arr2[i].split(";")[2]);
            String distance = arr2[i].split(";")[4];
            double d = Double.parseDouble(distance);
            nodeA.addDestination(nodeB, d);
            graph.addNode(nodeA);
            graph.addNode(nodeB);
            Dijkstra dd = new Dijkstra();
            graph = dd.calculateShortestPathFromSource(graph, nodeA);
        }
    }
    
    public void printShortestPaths(Graph graph) {
        for (Node node : graph.getNodes()) {
            if (node.getDistance() == 0.0) {
                System.out.println("No path to" + node.getName());
            }
            System.out.print("from AER to " + node.getName() + " = " + node.getDistance());
            System.out.println();
        }

        for (Node node : graph.getNodes()) {
            System.out.print("shortest path to " + node.getName() + " from AER = ");
            for (Node node2 : node.getShortestPath()) {
                if (node2.getName().equals("AER")) {
                    System.out.print(node2.getName() + "->");
                } else {
                    System.out.print(node2.getName() + "(" + node2.getDistance() + ")->");
                }
            }
            System.out.print(node.getName() + "(" + node.getDistance() + ")");
            System.out.println();
        }
    }
}
