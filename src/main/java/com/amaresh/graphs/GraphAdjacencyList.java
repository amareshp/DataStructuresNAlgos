package com.amaresh.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class GraphAdjacencyList {
    Set<Vertex> vertices;
    
    public GraphAdjacencyList(Set<Vertex> vertices) {
        this.vertices = vertices;
    }
    
    public void addVertex(Vertex v) {
        vertices.remove(v);
        vertices.add(v);
    }
        
    /**
     * compute shortest paths and distances from source
     * @param source
     */
    public void computePathsDijkstra(Vertex source) {
        source.minDistance = 0;
        PriorityQueue<Vertex> priorityQ = new PriorityQueue<Vertex>();
        priorityQ.add(source);
        
        while( !priorityQ.isEmpty() ) {
            Vertex u = priorityQ.poll();
            for(Edge edge : u.edges) {
                Vertex v = edge.target;
                Integer weight = edge.weight;
                Integer distanceThroughU = u.minDistance + weight;
                if(distanceThroughU < v.minDistance) {
                    priorityQ.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previousV = u;
                    priorityQ.add(v);
                }
            }
        }
    }
    
    public List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> reverse = new ArrayList<Vertex>();
        Vertex current = target;
        reverse.add(current);
        while(current.previousV != null) {
            reverse.add(current.previousV);
            current = current.previousV;
        }
        Collections.reverse(reverse);
        String path = "";
        Integer distance = 0;
        for(Vertex vertex : reverse) {
            path += vertex.toString() + " -> ";
        }
        path = path.substring(0, (path.length() - 4) );
        System.out.println("Path to " + target.toString() + ": " + path + " Distance: " + target.minDistance);
        return reverse;
    }
}
