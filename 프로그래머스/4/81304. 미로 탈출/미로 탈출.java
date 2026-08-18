import java.util.*;

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<int[]>[] graph = new ArrayList[n + 1];
        List<int[]>[] reverse = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int from = road[0], to = road[1], cost = road[2];
            graph[from].add(new int[]{to, cost});
            reverse[to].add(new int[]{from, cost});
        }

        int[] trap = new int[n + 1];
        for (int i = 0; i < traps.length; i++)
            trap[traps[i]] = 1 << i;

        int[][] dist = new int[n + 1][1 << traps.length];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        dist[start][0] = 0;
        pq.offer(new int[]{start, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], state = cur[1], cost = cur[2];

            if (cost != dist[node][state]) continue;
            if (node == end) return cost;

            boolean curOn = (state & trap[node]) != 0;

            for (int dir = 0; dir < 2; dir++) {
                List<int[]> edges = dir == 0 ? graph[node] : reverse[node];

                for (int[] edge : edges) {
                    int next = edge[0];
                    int nextCost = cost + edge[1];
                    boolean nextOn = (state & trap[next]) != 0;

                    if ((curOn == nextOn) != (dir == 0)) continue;

                    int nextState = state ^ trap[next];

                    if (nextCost < dist[next][nextState]) {
                        dist[next][nextState] = nextCost;
                        pq.offer(new int[]{next, nextState, nextCost});
                    }
                }
            }
        }

        return -1;
    }
}