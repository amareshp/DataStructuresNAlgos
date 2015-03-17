package com.amaresh;

import java.util.AbstractQueue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * http://www.algolist.net/Data_structures/Graph
 * http://www.algolist.net/Data_structures/Graph/Internal_representation
 * http://www.algolist.net/Algorithms/Graph/Undirected/Depth-first_search
 * 
 * @author apatta2
 *
 */
public class GraphMatrix {
    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public GraphMatrix(int vertexCount) {
          this.vertexCount = vertexCount;
          adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
          if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
                adjacencyMatrix[i][j] = true;
                adjacencyMatrix[j][i] = true;
          }
    }

    public void removeEdge(int i, int j) {
          if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
                adjacencyMatrix[i][j] = false;
                adjacencyMatrix[j][i] = false;
          }
    }

    public boolean isEdge(int i, int j) {
          if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount)
                return adjacencyMatrix[i][j];
          else
                return false;
    }
    
    public void dfs() {
        // false = not visited. true = visited. all vertices are unvisited at first.
        boolean[] visited = new boolean[vertexCount];
        runDfs(0, visited);
    }
    
    public void runDfs(int u, boolean[] visited) {
        visited[u] = true;
        for(int v = 0; v < vertexCount; v++) {
            if(isEdge(u, v) && visited[v] == false) {
                System.out.println("edge: (" + u + "," + v + ")");
                runDfs(v, visited);
            }
        }
    }
    
    public void runDfsStack(int u) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(u);
        boolean[] visited = new boolean[vertexCount];
        
        while( !stack.empty() ) {
            int top = stack.pop();
            if(visited[top]) {
                continue;
            }
            visited[top] = true;
            System.out.println("node: " + top);
            for(int v = 0; v < vertexCount; v++) {
                if( isEdge(top, v) && visited[v] == false ) {
                    stack.push(v);
                }
            }
        }
    }

    public void runBfs(int u) {
        AbstractQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
        queue.add(u);
        boolean[] visited = new boolean[vertexCount];
        
        while( !queue.isEmpty() ) {
            int top = queue.poll();
            if(visited[top]) {
                continue;
            }
            visited[top] = true;
            System.out.println("node: " + top);
            for(int v = 0; v < vertexCount; v++) {
                if( isEdge(top, v) && visited[v] == false ) {
                    queue.add(v);
                }
            }
        }
    }
    
}