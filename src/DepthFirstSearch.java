import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch
{
    public static void main(String[] args) {
    }
    int counter = 0;
    public void dfs(int v, boolean[] visited, GraphDFS graph)
    {
        visited[v] = true;
        //   System.out.println("Airport visited: " + graph.adjLists[v].airPortName);
        for (Neighbor neighbor = graph.adjLists[v].adjList; neighbor != null; neighbor = neighbor.next) {



            if (!visited[neighbor.vertexNum])
            {
                System.out.println("\n"  + " Man kan komme til " + graph.adjLists[neighbor.vertexNum].airPortName + " fra " + graph.adjLists[v].airPortName);

                dfs(neighbor.vertexNum, visited, graph);

            }
        }
    }
}