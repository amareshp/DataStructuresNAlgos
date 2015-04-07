package com.amaresh.p1;

import java.util.LinkedList;
import java.util.Queue;

public class UndirecteGraphAdjMatrix1 {

    //http://www.algolist.net/Data_structures/Graph/Internal_representation
    int[][] adjMatrix;
    public UndirecteGraphAdjMatrix1() {
        adjMatrix = new int[][] 
        {
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };
    }
    
    public void dfs(int start, int[] state) {
        state[start] = 1;
        for(int i=0; i<state.length; i++) {
            if(isEdge(start, i) && state[i] == 0) {
                state[i] = 1;
                dfs(i, state);
            }
        }
        System.out.println("Visiting node: " + start);
    }
    
    public void bfs(int start, int[] state) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while( !q.isEmpty() ) {
            int u = q.poll();
            state[u] = 1;
            System.out.println("Visiting node: " + u);
            for(int v=0; v<state.length; v++) {
                if(isEdge(u, v) && state[v] == 0) {
                    q.add(v);
                    state[v] = 1;
                }
            }
        }
    }
    
    public boolean isEdge(int i, int j) {
        if(adjMatrix[i][j] == 1) {
            return true;
        } else {
            return false;
        }
    }
    
}
