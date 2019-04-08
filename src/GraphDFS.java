

public class GraphDFS
{ Vertex[] adjLists;

    public GraphDFS(String[] lines, String[] airport)
    {
        adjLists = new Vertex[airport.length];

        for (int v = 1; v < airport.length; v++)
        {
            Vertex vertexObject = new Vertex(airport[v].split(";")[0], null);
            adjLists[v] = vertexObject;

        }

        for (int v = 1; v < lines.length; v++)
        {

            // read vertex names and translate to vertex numbers
            int v1 = indexForName(lines[v].split(";")[1]);
            int v2 = indexForName(lines[v].split(";")[2]);

            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);


        }}

    int indexForName(String a) {
        for (int v=1; v < adjLists.length; v++) {
            if (adjLists[v].airPortName.equals(a)) {
                return v;
            }
        }
        return -1;
    }
}


class Neighbor
{

    public int vertexNum;
    public Neighbor next;

    public Neighbor(int vnum, Neighbor nbor)
    {
        this.vertexNum = vnum;
        this.next = nbor;
    }
}