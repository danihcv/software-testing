package huxley.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph<Integer, Integer> graph;

    @BeforeEach
    void initializeGraph() {
        graph = new Graph<>();
    }

    @AfterEach
    void destroyGraph() {
        graph = null;
    }

    void addDefaultVertices() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(10);
    }

    @Test
    void addVertex() {
        assertTrue(graph.edges.isEmpty(), "Grafo recém inicializado não está vazio");

        graph.addVertex(1);
        assertFalse(graph.edges.isEmpty(), "Grafo continua vazio após inserir 1 elemento");

        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        assertEquals(7, graph.edges.size(), "Grafo não adicionou todos os vértices que deveria");

        graph.addVertex(5);
        assertEquals(7, graph.edges.size(), "Tamanho do grafo mudou ao adicionar um vértice já existente");
    }

    @Test
    void addEdge() {
        addDefaultVertices();

        HashMap<Integer, Integer> emptyMap = new HashMap<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> vertex : graph.edges.entrySet()) {
            assertEquals(emptyMap, vertex.getValue(), "Grafo possui aresta que não deveria existir");
        }


    }
}
