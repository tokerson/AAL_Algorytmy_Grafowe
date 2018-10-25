import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Integer> neighbors = new ArrayList<Integer>();

    public void addNeighbor(int neighbor) {
        neighbors.add(neighbor);
    }

    public Integer[] getNeighbours() {
        return neighbors.toArray(new Integer[neighbors.size()]);
    }
}
