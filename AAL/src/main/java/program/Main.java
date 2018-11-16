package program;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args){

        Graph graph = createGraph();

        int scouts;

        assert graph != null;
        scouts = howManyScouts(graph,Main::DFS_Recursive);
        System.out.println("Recursive algoritm calculated that your Majesty shall ask " + scouts + " scouts");
        scouts = howManyScouts(graph,Main::DFS_Stack);
        System.out.println("Iterative algoritm calculated that your Majesty shall ask " + scouts + " scouts");
    }

    public static void DFS_Recursive(Graph graph, boolean[] visited, int v) {
        visited[v] = true;
        Integer[] neighbors = graph.getNode(v + 1).getNeighbors();
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor - 1]) {
                DFS_Recursive(graph, visited, neighbor - 1);
            }
        }
    }


    public static void DFS_Stack(Graph graph, boolean[] visited, int node) {

        Stack<Integer> stack = new Stack<>();

        stack.push(node);
        visited[node] = true;

        while(!stack.empty()) {
            node = stack.pop();

            Integer[] neighbors = graph.getNode(node + 1).getNeighbors();

            for (Integer neighbor : neighbors) {
                if (!visited[neighbor - 1]) {
                    visited[neighbor - 1] = true;
                    stack.push(neighbor - 1);
                }
            }
        }
    }

    public static int howManyScouts(Graph graph, DFS function) {
        int scouts = 0;
        int size = graph.getSize();
        boolean[] visited = new boolean[size];

        for(int i = 0 ; i < size ; ++i) {
            if(!visited[i]) {
                ++scouts;
                try {
                    function.DFS(graph,visited,i);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    System.out.println("Your graph is too big :/ ");
                }
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


    public static Graph createGraph(String filename) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

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


