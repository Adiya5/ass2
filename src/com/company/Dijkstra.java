package com.company;

import java.util.*;

public class Dijkstra<Vertex> {
    protected Set<Vertex> m;
    protected Map<Vertex, Vertex> e;
    private Map<Vertex, Double> dist;
    private WeightedGraph<Vertex> g;
    protected final Vertex start;

    public Dijkstra(WeightedGraph<Vertex> g, Vertex start) {
        this.start = start;
        this.g = g;
        process();
    }
}
