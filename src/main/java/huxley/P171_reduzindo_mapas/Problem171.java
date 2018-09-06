package huxley.P171_reduzindo_mapas;

import huxley.util.Graph;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem171 {
    private static Graph<Integer, Integer> graph;
    private static boolean[] visited;
    private static PriorityQueue<Entry> priorityQueue;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();

        graph = new Graph<>();
        visited = new boolean[n];
        priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            graph.addVertex(i + 1);
            visited[i] = false;
        }

        for (int i = 0; i < m; i++) {
            int u = scan.nextInt(), v = scan.nextInt(), cost = scan.nextInt();
            graph.addEdge(u, v, cost);
            graph.addEdge(v, u, cost);
        }

        process(1);
        int mstCost = 0;
        while (!priorityQueue.isEmpty()) {
            Entry front = priorityQueue.remove();
            if (!visited[front.key - 1]){
                mstCost += front.value;
                process(front.key);
            }
        }

        System.out.print(mstCost);
    }

    public static void process(int vertex) {
        if (vertex <= visited.length) {
            visited[vertex - 1] = true;

            for (Map.Entry<Integer, Integer> pair : graph.get(vertex).entrySet()) {
                if (!visited[pair.getKey() - 1]) {
                    priorityQueue.add(new Entry(pair.getKey(), pair.getValue()));
                }
            }
        }
    }

    public static class Entry implements Comparable<Entry> {
        Integer key;
        Integer value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry other) {
            return this.value.compareTo(other.value);
        }
    }
}
