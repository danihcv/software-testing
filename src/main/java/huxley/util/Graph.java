package huxley.util;

import java.util.HashMap;
import java.util.Map;

public class Graph<K, V> {
    Map<K, Map<K, V>> edges;

    public Graph() {
        this.edges = new HashMap<>();
    }

    public boolean addVertex(K vertex) {
        if (this.edges.get(vertex) != null) {
            return false;
        }
        this.edges.put(vertex, new HashMap<>());
        return true;
    }

    public void addEdge(K origin, K destiny, V cost) throws NullPointerException {
        this.edges.get(origin).put(destiny, cost);
    }

    public Map<K, V> get(K vertex) {
        return edges.get(vertex);
    }
}
