public class Main {

    public static void main(String[] args){

//        GraphMatrix graphMatrix = new GraphMatrix(5);
//        graphMatrix.addEdge(1, 1);
//        System.out.println(graphMatrix.isEdge(1,1));

        Graphlist graphlist = new Graphlist(4);
        graphlist.addEdge(1,2);
        graphlist.addEdge(2,3);
        graphlist.addEdge(3,4);
        graphlist.addEdge(4,2);
        graphlist.printAllNeighbours();
    }
}
