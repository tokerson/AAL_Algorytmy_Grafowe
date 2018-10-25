import java.util.Arrays;

public class Main {

    public static void main(String[] args){

//        Graph graph = new Graph(5);
//
//        graph.addEdge(1,4);
//        graph.addEdge(4,3);
//        graph.addEdge(3,1);
//        graph.addEdge(2,3);
//        graph.addEdge(5,2);

//        Graph graph = new Graph(6);
//
//        graph.addEdge(1,3);
//        graph.addEdge(3,5);
//        graph.addEdge(4,2);
//        graph.addEdge(2,6);

        Graph graph = new Graph(4);

        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(3,2);
        graph.addEdge(4,2);

        graph.printEdges();

        System.out.println(howManyScouts(graph));
    }

    public static void DFS(Graph graph,boolean[] visited,int v) {
        visited[v] = true;
        for( int i = 0; i < graph.getSize() ; ++i) {
            if( graph.areNodesConnected(v + 1, i + 1) && visited[i] == false ) {
                DFS(graph,visited,i);
            }
        }
    }

    public static int howManyScouts(Graph graph) {
        int scouts = 0;
        int size = graph.getSize();
        boolean[] visited = new boolean[size];

        for(int i = 0 ; i < size ; ++i) {
            if(visited[i] == false) {
                ++scouts;
                DFS(graph,visited,i);
            }
        }
        return scouts;
    }

}


