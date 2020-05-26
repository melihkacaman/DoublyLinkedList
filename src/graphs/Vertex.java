package graphs;


import java.util.LinkedList;
import java.util.Objects;

class Vertex<T> {
    boolean visited;
    T data;
    private LinkedList<Vertex<T>> neighbours;

    public Vertex(T data) {
        this.data = data;
        this.neighbours= new LinkedList<>();
        this.visited = false;
    }

    void addNeighbour(Vertex<T> v){
        this.neighbours.add(v);
    }

    LinkedList<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        return this.data == ((Vertex)o).data;
    }
}
