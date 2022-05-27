package com.company;

import java.util.*;


public class MyGraph<Vertex> {
    private boolean directed = false;
    private Map<Vertex, List<Vertex>> m = new HashMap<>();

    public MyGraph(boolean directed) {
        this.directed = directed;
    }

    public void addVertex(Vertex v) {
        m.put(v, new LinkedList<>());
    }

}
