package com.amaresh.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class DijVertex1 implements Comparable<DijVertex1> {
    String name;
    DijEdge1[] edges;
    DijVertex1 previous;
    double minDist = Double.POSITIVE_INFINITY;
    
    public DijVertex1(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(DijVertex1 other) {
        return Double.compare(this.minDist, other.minDist);
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public static void dijPaths(DijVertex1 source) {
        source.minDist = 0;
        PriorityQueue<DijVertex1> q = new PriorityQueue<DijVertex1>();
        q.add(source);
        
        while( !q.isEmpty() ) {
            DijVertex1 u = q.poll();
            for(DijEdge1 e : u.edges) {
                DijVertex1 v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDist + weight;
                if(distanceThroughU < v.minDist) {
                    q.remove(v);
                    v.minDist = distanceThroughU;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }
    
    public ArrayList<DijVertex1> getShortestPath(DijVertex1 target) {
        ArrayList<DijVertex1> path = new ArrayList<DijVertex1>();
        
        while(target != null) {
            path.add(target);
            target = target.previous;
        }
        
        Collections.reverse(path);
        return path;
    }

}
