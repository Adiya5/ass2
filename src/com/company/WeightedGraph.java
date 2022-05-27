package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<Vertex> {
    private boolean directed = false;
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public WeightedGraph() {
    }

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public WeightedGraph(boolean directed, Map<Vertex, List<Edge<Vertex>>> map) {
        this.directed = directed;
        this.map = map;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public Map<Vertex, List<Edge<Vertex>>> getMap() {
        return map;
    }

    public void setMap(Map<Vertex, List<Edge<Vertex>>> map) {
        this.map = map;
    }


    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex s, Vertex d, double w) {
        if (!hasVertex(s)) addVertex(s);
        if (!hasVertex(d)) addVertex(d);
        if (hasEdge(s, d) || s.equals(d)) return;
        map.get(s).add(new Edge<>(s, d, w));
        if (directed) map.get(d).add(new Edge<>(d, s, w));
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex s, Vertex d) {
        if (!hasVertex(s)) return false;
        if (!hasVertex(d)) return false;
        return map.get(s).contains(new Edge<>(s, d));
    }
}
