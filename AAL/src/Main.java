import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args){

        Graph graph = createGraph();

//        graph.printEdges();
        int scouts;
        long startTime = System.nanoTime();
        scouts = howManyScouts(graph);
        long endTime = System.nanoTime();
        System.out.println(scouts);
        System.out.println("Your time is " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        scouts = howManyScouts2(graph);
        endTime = System.nanoTime();
        System.out.println(scouts);
        System.out.println("Your time is " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        scouts = howManyScouts3(graph);
        endTime = System.nanoTime();
        System.out.println(scouts);
        System.out.println("Your time is " + (endTime - startTime) + " ns");
    }

    public static void DFS_Recursive(Graph graph, boolean[] visited, int v) {
        visited[v] = true;
        for( int i = 0; i < graph.getSize() ; ++i) {
            if( graph.areNodesConnected(v + 1, i + 1) && visited[i] == false ) {
                DFS_Recursive(graph,visited,i);
            }
        }
    }

    public static void DFS_Recursive2(Graph graph, boolean[] visited, int v) {
        visited[v] = true;
        Integer[] neighbors = graph.getNode(v + 1).getNeighbors();
        for( int i = 0; i < neighbors.length ; ++i) {
            if( visited[neighbors[i] - 1] == false ) {
                DFS_Recursive2(graph,visited,neighbors[i] - 1);
            }
        }
    }


    public static void DFS_Stack(Graph graph,boolean[] visited,int node) {
        int size = graph.getSize();

        Stack stack = new Stack();

        stack.push(node);
        visited[node] = true;

        while(!stack.empty()) {
            node = (int) stack.pop();

            Integer[] neighbors = graph.getNode(node + 1).getNeighbors();

            for( int i = 0; i < neighbors.length ; ++i) {
                if( visited[neighbors[i] - 1] == false ) {
                    visited[neighbors[i] - 1] = true;
                    stack.push(neighbors[i] - 1);
                }
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
                DFS_Recursive(graph,visited,i);
            }
        }
        return scouts;
    }


    public static int howManyScouts2(Graph graph) {
        int scouts = 0;
        int size = graph.getSize();
        boolean[] visited = new boolean[size];

        for(int i = 0 ; i < size ; ++i) {
            if(visited[i] == false) {
                ++scouts;
                DFS_Recursive2(graph,visited,i);
            }
        }
        return scouts;
    }

    public static int howManyScouts3(Graph graph) {
        int scouts = 0;
        int size = graph.getSize();
        boolean[] visited = new boolean[size];

        for(int i = 0 ; i < size ; ++i) {
            if(visited[i] == false) {
                ++scouts;
                DFS_Stack(graph,visited,i);
            }
        }
        return scouts;
    }

    public static Graph createGraph() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String str = bufferedReader.readLine();

            Graph graph = new Graph(Integer.parseInt(str));

            while((str = bufferedReader.readLine()) != null) {
                String[] numbers = (str.split("\\s+"));
                graph.addEdge(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]));
            }

            bufferedReader.close();
            return graph;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}


