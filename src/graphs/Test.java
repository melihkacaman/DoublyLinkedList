package graphs;

public class Test {
    public static void main(String[] args) {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<>();

        directedGraph.addEdge(10,30);
        directedGraph.addEdge(10,70);

        directedGraph.addEdge(20,10);
        directedGraph.addEdge(20,30);
        directedGraph.addEdge(20,50);
        directedGraph.addEdge(20,60);

        System.out.println("Is simple : " + directedGraph.isSimple());
        System.out.println("Is balaced : " + directedGraph.isBalaced());
        Vertex<Integer> vertex = new Vertex<>(40);
        directedGraph.addVertex(vertex);
        directedGraph.addEdge(40,20);

        directedGraph.bfsTraversal(vertex);
        directedGraph.cleadVisited();
        directedGraph.dfsTraversal(vertex);
        directedGraph.cleadVisited();

        System.out.println("path(20,60):" + directedGraph.path(20,30));
        directedGraph.cleadVisited();
    }
}
