package graphs;


import java.util.LinkedList;

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
}
