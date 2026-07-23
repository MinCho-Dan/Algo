import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for (int[] c : costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            
            graph[from].add(new int[] {to, cost});
            graph[to].add(new int[] {from, cost});
        }
        
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<> ( (a,b) -> a[1] - b[1] );
        pq.offer(new int[] {0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (visited[node]) continue;
            
            visited[node] = true;
            answer += cost;
            
            for (int[] next : graph[node]) {
                int nn = next[0];
                int nc = next[1];

                if (!visited[nn]) {
                    pq.offer(new int[] {nn, nc});
                }
            }
        }
        
        return answer;
    }
}