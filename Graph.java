/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectivityanalyzer;

/**
 *
 * @author user
 */
public class Graph {
    private static boolean[] visitedNodes;
    private static int[] adjacency;
    private static int nodeCount;
    public static boolean analyzeGraph(int size, int[] matrix) {
        
        // setting up
        adjacency = matrix;
        nodeCount = size;
        
        // new lines
        System.out.printf("\n\n");
        
        for (int i = 0; i < nodeCount; i++) {
            
            // clears the visited nodes from last time
            visitedNodes = new boolean[size];
            
            // calls the function that does things, see if node i is connected to all other nodes
            depthFirstSearch(i);

            // basically for debugging purposes
            for (boolean b : visitedNodes)
                System.out.print(b + " ");
            System.out.printf("\n\n");

            // checks if all nodes have been visited
            for (boolean b :visitedNodes)
                if (!b) return false;
        }
        return true;
    }
    
    public static void depthFirstSearch(int node) {
        
        // "depthFirstSearch was here"
        visitedNodes[node] = true; 

        // helpful for debugging
        System.out.println("Visited node " + (node + 1));
        
        // goes through the nodes all other nodes
        for (int adjacentNode = 0; adjacentNode < nodeCount; adjacentNode++ )
        {
            System.out.println("Paths from " + (node + 1) + " to " + (adjacentNode + 1) + ": " + adjacency[(node * nodeCount) + adjacentNode]);
            
            // checks if there is a path from the node to the other node and that it hasn't been visited yet
            if (adjacency[((node * nodeCount) + adjacentNode)] > 0 && !visitedNodes[adjacentNode]) 
                
                // goes to node
                depthFirstSearch(adjacentNode);
        }
    }
}
