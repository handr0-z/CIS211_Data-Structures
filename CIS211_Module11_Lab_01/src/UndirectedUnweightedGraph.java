import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class UndirectedUnweightedGraph<T>
{
    // Generic Adjacent List
    // Undirected & Unweighted Graph

    private Map<T, LinkedList<T>> graph = new HashMap<>();

    private class Entry
    {
        T destination;
        public Entry(T destination, boolean connected) {this.destination = destination;}
    }

    // Constructor
    public UndirectedUnweightedGraph() {};

    // Method used to add vertex.
    public void addVertex(T vertex)
    {
        graph.put(vertex, new LinkedList<>());
    }

    // Method used to add edge between two Vertices.
    public void addEdge(T source, T destination)
    {
        // Add Edge to source list
        LinkedList<T> neighbors = graph.get(source);
        if(!neighbors.contains(destination)){neighbors.add(destination);}
        

        // Add Edge to destination list.
        LinkedList<T> adjacents = graph.get(destination);
        if(!adjacents.contains(source)){adjacents.add(source);}
    }

    // Method used to get the adjacent vertices.
    public String getAdjacent(T source)
    {
        StringBuilder text = new StringBuilder();

        // iterate through graph to get adjacent vertices.
        LinkedList<T> neighbors = graph.get(source);
        for(T neighbor : neighbors)
        {
            // Add edge to list
            text.append(source.toString()).append(" ------- ").append(neighbor.toString()).append("\n");
        }

        return text.toString();
    }

    // Method used to see if edge exists.
    public boolean hasEdge(T source, T destination) {return false;}
}
