package com.amaresh;

import org.testng.annotations.Test;

public class GraphMatrixTest {
    
    @Test
    public void traversalTest() {
        GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        
        graph.dfs();
        
        System.out.println("Traversing all elements using dfs (stack)...");
        graph.runDfsStack(0);
        
        System.out.println("Traversing all elements using bfs (queue)...");
        graph.runBfs(0);
        
    }

}
