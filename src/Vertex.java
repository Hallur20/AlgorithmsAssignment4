public class Vertex  {

    String airPortName;
    int status;
    int predecessor;
    int lenght;
    Neighbor adjList;

    public Vertex(String airPortName, Neighbor neighbors) {
        this.airPortName = airPortName;
        this.adjList = neighbors;
    }
}