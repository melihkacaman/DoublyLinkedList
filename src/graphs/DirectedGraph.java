package graphs;

import java.util.HashSet;
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

    void dfsTraversal(Vertex<T> start) {
        dfsRecursive(start);
        System.out.println();
    }

    private void dfsRecursive(Vertex<T> v) {
        System.out.print(v.data + " ");
        v.visited = true;

        for (Vertex<T> vertex : v.getNeighbours()) {
            if (!vertex.visited)
                dfsRecursive(vertex);
        }
    }

    void cleadVisited() {
        for (Vertex<T> vertex : vertices)
            vertex.visited = false;
    }

    // no loop + no more than one edge between two vertices
    boolean isSimple() {
        for (Vertex<T> vertex : this.vertices) {
            LinkedList<Vertex<T>> neighbours = vertex.getNeighbours();

            if (neighbours.contains(vertex))
                return false;

            HashSet<Vertex<T>> hashSet = new HashSet<>(neighbours);
            if (hashSet.size() != neighbours.size())
                return false;
        }

        return true;
    }

    int indegree(Vertex<T> v) {
        int count = 0;
        for (Vertex<T> vertex : vertices) {
            for (Vertex<T> neighbour : vertex.getNeighbours()) {
                if (v.equals(neighbour))
                    count++;
            }
        }
        return count;
    }

    int outdegree(Vertex<T> v) {
        return v.getNeighbours().size();
    }

    // for each vertex: indegree(vertex) = outdegree(vertex)
    boolean isBalaced() {
        for (Vertex<T> vertex : vertices) {
            if (indegree(vertex) != outdegree(vertex))
                return false;
        }

        return true;
    }

    boolean isConnected() {
        for (Vertex<T> vertex1 : vertices) {
            for (Vertex<T> vertex2 : vertices) {
                if (!path(vertex1, vertex2))
                    return false;
            }
        }
        return true;
    }

    boolean path(Vertex<T> from, Vertex<T> to) {
        Queue<Vertex<T>> queue = new LinkedList();
        queue.add(from);

        while (!queue.isEmpty()) {
            Vertex<T> removedVertex = queue.remove();
            if (removedVertex.equals(to))
                return true;

            LinkedList<Vertex<T>> neighbours = removedVertex.getNeighbours();

            for (Vertex<T> vertex : neighbours) {
                if (!vertex.visited) {
                    queue.add(vertex);
                    vertex.visited = true;
                }
            }
        }

        return false;
    }

    boolean path(T from, T to) {
        Vertex<T> f = null;
        Vertex<T> t = null;

        for (Vertex<T> vertex : vertices) {
            if (vertex.data.equals(from))
                f = vertex;
            else if (vertex.data.equals(to))
                t = vertex;
        }

        if (f != null && t != null)
            return path(f, t);
        else
            return false;
    }
}
