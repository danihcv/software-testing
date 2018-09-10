package huxley.P562_pizzaria;

import huxley.P171_reduzindo_mapas.Problem171;
import huxley.util.Graph;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem562 {
    private static void dijkstra(Graph<Integer, Integer> grafo, int[] costs, int s) {
        int[] visitados = new int[grafo.size()];
        for (int i = 0; i < grafo.size(); i++) {
            visitados[i] = 0;
        }

        PriorityQueue<Problem171.Entry> pq = new PriorityQueue<>();
        pq.add(new Problem171.Entry(costs[s], s));

        while(!pq.isEmpty()) {
            Problem171.Entry pop = pq.remove();
            int curIdx = pop.value;
            int curCost = pop.key;

            if (visitados[curIdx] == 0) {
                visitados[curIdx] = 1;
                Map<Integer, Integer> vizinhos = grafo.get(curIdx);
                for (Map.Entry<Integer, Integer> node : vizinhos.entrySet()) {
                    if (costs[curIdx] + node.getValue() < costs[node.getKey()]) {
                        costs[node.getKey()] = costs[curIdx] + node.getValue();
                        pq.add(new Problem171.Entry(costs[node.getKey()], node.getKey()));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testes = scan.nextInt();

        for (int t = 0; t < testes; t++) {
            int n = scan.nextInt(), m = scan.nextInt();

            Graph<Integer, Integer> graph = new Graph<>();
            int[] costs = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                costs[i] = Integer.MAX_VALUE;
                graph.addVertex(i);
            }

            for (int i = 0; i < m; i++) {
                int u = scan.nextInt(), v = scan.nextInt(), c = scan.nextInt();
                graph.addEdge(u, v, c);
                graph.addEdge(v, u, c);
            }
            costs[1] = 0;

            int k = scan.nextInt();
            scan.nextLine();
            String[] pedidosStr = scan.nextLine().split(" ");
            int[] pedidos = new int[pedidosStr.length];
            for (int i = 0; i < pedidosStr.length; i++){
                pedidos[i] = Integer.parseInt(pedidosStr[i]);
            }

            dijkstra(graph, costs, 1);
            int custo = 0;
            for (int i = 0; i < k; i++) {
                custo += costs[pedidos[i]] * 2;
            }
            System.out.printf("caso %d: %d" + System.lineSeparator(), t + 1, custo);
        }
    }
}
