package program;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private Integer size;

    public List<Integer> adjList[];

    public Graph(int size) {
        this.size = size;
        adjList = new ArrayList[size];

        for(int i = 0 ; i < size ; i++ ) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int first, int second) {
        adjList[first - 1].add(second - 1);
        adjList[second - 1].add(first - 1);
    }

    public List<Integer> getNeighbors(int node) {
        return adjList[node];
    }

    public Integer getSize() {
        return size;
    }

}
