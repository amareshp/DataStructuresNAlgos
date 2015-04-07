package com.amaresh.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class GraphAdjacencyListTest {

    @Test
    public void shortestPaths() {
        /**
         * 
         *     B 1 C 3 D 1 E
         *  2/       1/    \1
         * A ---2--F/ -- 20- H -1- I
         *         1\ G 
         * 
         */
        //Map<Vertex, List<Edge>>
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        Vertex i = new Vertex("I");
        
        Edge ab = new Edge(b, 2);
        a.addEdge(ab);
        Edge bc = new Edge(c, 1);
        b.addEdge(bc);
        Edge cd = new Edge(d, 3);
        c.addEdge(cd);
        Edge af = new Edge(f, 2);
        a.addEdge(af);
        Edge fd = new Edge(d, 1);
        f.addEdge(fd);
        Edge de = new Edge(e, 1);
        d.addEdge(de);
        Edge fg = new Edge(g, 1);
        f.addEdge(fg);
        Edge fh = new Edge(h, 20);
        f.addEdge(fh);
        Edge eh = new Edge(h, 1);
        e.addEdge(eh);
        Edge hi = new Edge(i, 1);
        h.addEdge(hi);
        
        Set<Vertex> vertices = new HashSet<Vertex>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);
        vertices.add(h);
        vertices.add(i);
        GraphAdjacencyList graph = new GraphAdjacencyList(vertices);
        graph.computePathsDijkstra(a);
        List<Vertex> path = graph.getShortestPathTo(d);
    }
}
