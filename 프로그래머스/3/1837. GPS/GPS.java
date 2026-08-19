import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1;i <= n;i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(i); // 이동하지않았을때
        }
        
        for (int[] e : edge_list) {
            int from = e[0];
            int to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int INF = 1_000_000;
        int[][] dp = new int[gps_log.length][n + 1];
        
        for (int[] r : dp) 
            Arrays.fill(r, INF);
        
        // 시작점
        dp[0][gps_log[0]] = 0;
        
        for (int t = 1; t < gps_log.length; t++) {
            for (int cur = 1;cur <= n;cur++) {
                if (dp[t - 1][cur] == INF)
                    continue;
                
                for (int next : graph[cur]) {
                    int cost = (next == gps_log[t]) ? 0 : 1;

                    dp[t][next] = Math.min(dp[t][next], dp[t - 1][cur] + cost);
                }
            }
        }
        int answer = dp[k - 1][gps_log[k - 1]];
        return answer == INF ? -1 : answer;
    }
}