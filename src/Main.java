
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

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
        In in = new In("Files/routes.txt");

        String[] fileArr = in.readAllLines();
        String[] airPorts = new In("Files/airports.txt").readAllLines();
        StdOut.println(fileArr[0]);

        //LETS SEE IF : POR AIRPORT CAN BE REACHED BY USING AIRLINE : 2N FROM ARN.
        //breadthFirstSearchV1("2N", "ARN", "POR", fileArr);
        //OR IS THE TASK TO FIND THE AIRPORTS WHERE ONLY A SINGLE AIRLINE CAN GO?
        breadthFirstSearchV2(fileArr);

    }

    static void breadthFirstSearchV1(String airlineCode, String sourceCode, String desinationCode, String[] fileArr) {
        Queue<String> q = new Queue<>();
        for (int i = 0; i < fileArr.length; i++) {
            String airline_code = fileArr[i].split(";")[0];
            String source_code = fileArr[i].split(";")[1];
            /*String destination_code = fileArr[i].split(";")[2];
            String distance = fileArr[i].split(";")[3];
            String time = fileArr[i].split(";")[4];*/
            if (airline_code.equals(airlineCode) && source_code.equals(sourceCode)) {
                System.out.println("yes. we can go to: " + fileArr[i].split(";")[2]);

                q.enqueue(fileArr[i].split(";")[2]);
            }
        }
        System.out.println(q.size());
        int queueSize = q.size();
        for (int i = 0; i < queueSize; i++) {
            String dest = q.dequeue();
            if (dest.equals(desinationCode)) {
                System.out.println("YES! the airport: '" + dest + "' can be reached from '" + sourceCode + "' using the single airline: '" + airlineCode + "'");
                return;
            }
        }
        System.out.println("NO! the airport: '" + desinationCode + "' cannot be reached from '" + sourceCode + "' using the single airline: '" + airlineCode + "'");
    }

    static void breadthFirstSearchV2(String[] fileArr) {
        Queue<String> q = new Queue(); //enqueue airports that are being touched, dequeue when we move on to next root airport
        ArrayList<String> airportsVisited = new ArrayList<>(); //save which ones have been visited

        q.enqueue(fileArr[1].split(";")[2]);
        String source_airport_pointer;
        for (int i = 1; i < fileArr.length; i++) {
            if(airportsVisited.contains(fileArr[i].split(";")[1])){
                System.out.println("already done it lol");
                continue;
            }
            source_airport_pointer = fileArr[i].split(";")[1];
            airportsVisited.add(source_airport_pointer);
            //lets enqueue the connections...
            for (int j = 0; j < fileArr.length; j++) {
                if(fileArr[j].split(";")[1].equals(source_airport_pointer)){
                    System.out.println(source_airport_pointer + " to " + fileArr[j].split(";")[2]);
                    q.enqueue(fileArr[j].split(";")[2]);
                }
            }
            //now... does the enqued airports have connections to unvisited airports?
            //if so, update pointer to the first one to be dequeued in the queue.
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                //lets test the queued childs...
                String testAirport = q.dequeue();
                for (int k = 1; k < fileArr.length; k++) {
                    if(fileArr[k].split(";")[1].equals(testAirport) && !airportsVisited.contains(fileArr[k].split(";")[2])){
                        System.out.println("queued airport: " + testAirport + " goes to " + fileArr[k].split(";")[2]);
                        //til i morgen... pointer skal være fileArr[k].split(";")[2]) i stedet og dens connections skal tilføjes til queue.
                    }
                    /*if(airportsVisited.contains(fileArr[k].split(";")[2]) == true){
                        System.out.println(fileArr[k].split(";")[2] + " has already been visited");
                    }*/
                    
                }
            }
            
        }
    }
}
