import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graphlist {

    private int[] edges;
    //neighbouring node will be a value of a particular element of that array

    public Graphlist(int size) {
        edges = new int[size];
    }

    public boolean isEdge(int x, int y) {
        return edges[x - 1] != 0 && edges[x - 1] == y;
    }

    public boolean addEdge(int x, int y) {
        if(x > 0 && edges[x - 1] == 0) {
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

    public int size() {
        return edges.length;
    }

    public int whoIsTheNeighbourOf(int x) {
        return edges[x -1];
    }

}
