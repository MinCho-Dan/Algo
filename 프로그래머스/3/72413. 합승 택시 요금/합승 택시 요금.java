import java.util.*;

class Solution {
    
    private static final int INF = 100_000_000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int [n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            dist[from][to] = cost;
            dist[to][from] = cost;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = INF;
        
        for (int split = 1; split <= n; split++)
            answer = Math.min(answer, dist[s][split] + dist[split][a] + dist[split][b]);
        
        return answer;
    }
}