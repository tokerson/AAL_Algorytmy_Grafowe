import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

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

//        Graph graph = new Graph(4);
//
//        graph.addEdge(1,2);
//        graph.addEdge(2,1);
//        graph.addEdge(3,2);
//        graph.addEdge(4,2);
//
//        graph.printEdges();
//
//        System.out.println(howManyScouts(graph));



        Graph graph = createGraphFromFile("in.txt");
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

    public static Graph createGraphFromFile(String filename) {

        File file = new File(filename);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String str = bufferedReader.readLine();
//            System.out.println(str);

            Graph graph = new Graph(Integer.parseInt(str));

            while((str = bufferedReader.readLine()) != null) {
//                System.out.println(str);
                String[] numbers = (str.split("\\s+"));
                graph.addEdge(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]));
            }

            bufferedReader.close();
            return graph;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }

}


