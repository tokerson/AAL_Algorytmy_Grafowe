package program;

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

    public void addEdge(Integer first, Integer second) {

        if ( first > 0  && second > 0 && second != first) {
            nodes[first - 1].addNeighbor(second);
            nodes[second - 1].addNeighbor(first);
        }
    }

    public Integer getSize() {
        return size;
    }

    public Node getNode(int index) {
        if(index > 0) {
            return nodes[index - 1];
        }
        return null;
    }

}
