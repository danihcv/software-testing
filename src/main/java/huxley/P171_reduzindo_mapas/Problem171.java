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
        visited = new boolean[n + 1];
        priorityQueue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            graph.addVertex(i);
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
            if (!visited[front.key]){
                mstCost += front.value;
                process(front.key);
            }
        }

        System.out.println(mstCost);
    }

    public static void process(int vertex) {
        visited[vertex] = true;

        for (Map.Entry<Integer, Integer> pair : graph.get(vertex).entrySet()) {
            if (!visited[pair.getKey()]) {
                priorityQueue.add(new Entry(pair.getKey(), pair.getValue()));
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
