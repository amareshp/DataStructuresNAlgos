package com.amaresh.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    public String name;
    List<Edge> edges = new ArrayList<Edge>();
    public Vertex previousV;
    public Integer minDistance = Integer.MAX_VALUE;
    
    public Vertex(String name) {
        this.name = name;
    }
    
    public void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    public String toString() {
        return name;
    }
    
    public int compareTo(Vertex other) {
        return name.compareTo(other.name);
    }
}
