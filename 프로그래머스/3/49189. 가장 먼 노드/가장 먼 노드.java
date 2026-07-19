import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // BFS
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                q.offer(next);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(max, dist[i]);

        int answer = 0;
        for (int i : dist)
            if (i == max) answer++;

        return answer;
    }
}