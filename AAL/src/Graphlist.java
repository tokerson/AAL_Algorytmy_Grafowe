import java.util.ArrayList;
import java.util.List;

public class Graphlist {

    private Integer[] edges;
    //neighbouring node will be a value of a particular element of that array

    public Graphlist(int size) {
        edges = new Integer[size];
    }

    public boolean isEdge(int x, int y) {
        return edges[x - 1] != null && edges[x - 1] == y;
    }

    public boolean addEdge(int x, int y) {
        if(x > 0 && edges[x - 1] == null) {
            edges[x - 1] = y;
            return true;
        }
        return false;
    }

    public void printAllNeighbours() {
        for(int i = 0; i < edges.length; ++i) {
            System.out.println(i + 1 + " said sth to " + edges[i]);
        }
    }


}
