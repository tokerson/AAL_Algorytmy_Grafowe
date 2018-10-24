public class GraphMatrix {

    private boolean[][] edges ;

    public GraphMatrix(int V) {
        edges = new boolean[V][V];
    }

    public boolean isEdge(int x, int y) {
        return edges[x][y] || edges[y][x];
    }

    public void addEdge(int x, int y) {
        edges[x][y] = true;
        edges[y][x] = true;
    }


}
