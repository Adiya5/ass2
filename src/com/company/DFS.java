package com.company;

import java.util.*;

public class DFS<Vertex> {
    protected Set<Vertex> m;
    protected Map<Vertex, Vertex> e;
    protected final Vertex start;
    private MyGraph<Vertex> graph;

    public DFS(MyGraph<Vertex> graph, Vertex start) {
        this.start = start;
        m = new HashSet<>();
        e = new HashMap<>();
        process(graph, start);
    }

}
