package huxley.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

    private void addDefaultVertices() {
        for (int i = 1; i <= 10; i++) {
            graph.addVertex(1);
        }
    }

    @Test
    void addVertex() {
        assertTrue(graph.edges.isEmpty(), "Grafo recém inicializado não está vazio");

        assertTrue(graph.addVertex(1), "Falhou ao tentar adicionar um novo vértice");
        assertFalse(graph.edges.isEmpty(), "Grafo continua vazio após inserir 1 elemento");

        for (int i = 2; i <= 7; i++) {
            assertTrue(graph.addVertex(i), "Falhou ao tentar adicionar um novo vértice");
        }
        assertEquals(7, graph.edges.size(), "Grafo não adicionou todos os vértices que deveria");

        assertFalse(graph.addVertex(5));
        assertEquals(7, graph.edges.size(), "Tamanho do grafo mudou ao adicionar um vértice já existente");
    }

    @Test
    void addEdge() {
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            assertThrows(NullPointerException.class, () -> graph.addEdge(rand.nextInt(), rand.nextInt(), 0),
                    "Não disparou NullPointerException ao tentar adicionar uma aresta saindo de um vértice inexistente");
        }

        addDefaultVertices();
        HashMap<Integer, Integer> emptyMap = new HashMap<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> vertex : graph.edges.entrySet()) {
            assertAll(
                    () -> assertEquals(emptyMap, vertex.getValue(), "Grafo possui aresta que não deveria existir"),

                    () -> assertDoesNotThrow(() -> this.graph.addEdge(vertex.getKey(), 1, rand.nextInt()),
                            "Disparou exceção ao tentar adicionar uma aresta com peso"),

                    () -> assertDoesNotThrow(() -> graph.addEdge(vertex.getKey(), 1, 0),
                            "Disparou exceção ao tentar adicionar uma aresta válida"),

                    () -> assertThrows(NullPointerException.class, () -> graph.addEdge(vertex.getKey(), 0, 0),
                            "Não disparou NullPointException ao tentar adicionar uma aresta com destino inválido"),

                    () -> assertThrows(NullPointerException.class, () -> graph.addEdge(0, vertex.getKey(), 0),
                            "Não disparou NullPointException ao tentar adicionar uma aresta com origem inválida")
            );
        }
    }

    @Test
    void get() {
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            assertNull(this.graph.get(rand.nextInt()));
        }
    }
}
