/*
=====================================================================================================
AUTHOR:        ALEJANDRO PANTOJA-ZURITA
COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
COURSE:        CIS 211: DATA STRUCTURES
INSTRUCTOR:    JIN AN
DATE:          APRIL 22, 2026
PROJECT:       MODULE 11 - LAB 1: GRAPH
NOTES:         PROGRAM CREATED TO BECOME FAMILIAR WITH GRAPHS AS A DATA STRUCTURE.

I WROTE ALL THE CODE SUBMITTED OR HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
=====================================================================================================
*/

public class Main
{
    public static void main(String[] args)
    {
        // Constructor initializes the graph with number of vertices.
        // Size may not be required depending on your chosen implementation.

        UndirectedUnweightedGraph<String> airports = new UndirectedUnweightedGraph<>();

        airports.addVertex("JFK");
        airports.addVertex("IAD");
        airports.addVertex("ILG");
        airports.addVertex("PHL");
        airports.addVertex("EWR");
        airports.addVertex("WIL");

        airports.addEdge("JFK", "IAD");
        airports.addEdge("IAD", "ILG");
        airports.addEdge("ILG", "PHL");
        airports.addEdge("IAD", "PHL");
        airports.addEdge("IAD", "EWR");
        airports.addEdge("PHL", "EWR");

        // Print the adjacency of selected airport.
        System.out.println(airports.getAdjacent("PHL")); // This should print output EWR, ILG, and IAD
        System.out.println(airports.getAdjacent("JFK")); // This should print output IAD
        System.out.println(airports.getAdjacent("IAD")); // This should print output EWR, PHL, ILG, JFK
        System.out.println(airports.getAdjacent("ILG")); // This should print output IAD, PHL
        System.out.println(airports.getAdjacent("EWR")); // This should print output IAD, PHL
        System.out.println(airports.getAdjacent("WIL"));
    }
}
