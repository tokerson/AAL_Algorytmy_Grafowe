package program;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Integer> neighbors = new ArrayList<Integer>();

    public void addNeighbor(int neighbor) {
        if(!isNeighbor(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public Integer[] getNeighbors() {
        return neighbors.toArray(new Integer[neighbors.size()]);
    }

    public boolean isNeighbor(int neighbor) {
        return neighbors.indexOf(neighbor) != -1;
    }
}
