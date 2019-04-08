public class GraphMST {

    public final int max_vertics = 30;

    int n;
    int e;
    int [] [] adj;
    Vertex [] listOfVertex;



    public GraphMST(String[] lines, String[] airport) {
        this.listOfVertex = new Vertex[airport.length];
        for (int v = 1; v < airport.length; v++)
        {

            if(airport.length > v) {
                Vertex vertexObject = new Vertex(airport[v].split(";")[0], null);
                listOfVertex[v] = vertexObject;
            }

        }
        for(int v = 1; v < airport.length; v++)
        {
            adj[indexForName(lines[v].split(";")[1])][indexForName(lines[v].split(";")[2])] = indexForName(lines[v].split(";")[4]);

        }
    }

    int indexForName(String a) {
        for (int v=1; v < listOfVertex.length; v++) {
            if (listOfVertex[v].airPortName.equals(a)) {
                return v;
            }
        }
        return -1;
    }



}
