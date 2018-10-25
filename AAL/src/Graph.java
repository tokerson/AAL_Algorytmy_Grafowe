import java.util.Arrays;

public class Graph {
    private Integer size;
    private Node[] nodes;

    public Graph(int size) {
        this.size = size;
        this.nodes = new Node[size];
        for(int i = 0 ; i < size; ++i) {
            nodes[i] = new Node();
        }
    }

    public boolean addEdge(Integer first, Integer second) {

        if ( first > 0  && second > 0 && second != first) {
            nodes[first - 1].addNeighbor(second);
            nodes[second - 1].addNeighbor(first);
            return true;
        }
        return false;
    }

    public void printEdges() {
        for( int i = 0; i < nodes.length; i++) {
            System.out.println(i + 1 + " is connected with " + Arrays.toString(nodes[i].getNeighbours()));
        }
    }
}
