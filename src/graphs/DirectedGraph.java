package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraph<T> {
    private LinkedList<Vertex<T>> vertices;

    public DirectedGraph() {
        this.vertices = new LinkedList<>();
    }

    boolean addVertex(Vertex<T> v) {
        if (vertices.contains(v))
            return false;

        return this.vertices.add(v);
    }

    void addEdge(T from, T to) {
        Vertex<T> f = new Vertex<>(from);
        Vertex<T> t = new Vertex<>(to);

        if (!vertices.contains(f))
            vertices.add(f);
        if (!vertices.contains(t))
            vertices.add(t);

        f = vertices.get(vertices.indexOf(f));
        t = vertices.get(vertices.indexOf(t));

        f.addNeighbour(t);
    }


    void bfsTraversal(Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList();
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> removedVertex = queue.remove();
            System.out.print(removedVertex.data + " ");
            LinkedList<Vertex<T>> neighbours = removedVertex.getNeighbours();

            for (Vertex<T> vertex : neighbours) {
                if (!vertex.visited) {
                    queue.add(vertex);
                    vertex.visited = true;
                }
            }
        }
        System.out.println();
    }

    void dfsRecursive(Vertex<T> v) {
        System.out.println(v.data + " ");
        v.visited = true;

        for (Vertex<T> vertex : v.getNeighbours()) {
            if (!vertex.visited)
                dfsRecursive(vertex);
        }
    }
}
