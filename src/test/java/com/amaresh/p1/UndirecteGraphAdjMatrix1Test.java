package com.amaresh.p1;

import org.testng.annotations.Test;

public class UndirecteGraphAdjMatrix1Test {

    @Test
    public void testDfs() {
        UndirecteGraphAdjMatrix1 graph = new UndirecteGraphAdjMatrix1();
        int[] state = new int[] {0, 0, 0, 0, 0};
        System.out.println("DFS traversal...");
        graph.dfs(0, state);
        state = new int[] {0, 0, 0, 0, 0};
        System.out.println("BFS traversal...");
        graph.bfs(0, state);
    }
}
