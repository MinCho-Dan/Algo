import java.util.Arrays;

class Solution {
    static final int INF = 1_000_000;
    public int solution(int[][] info, int n, int m) {
        // dp[a] = A 흔적이 a일 때의 최소 B 흔적
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];

            int[] next = new int[n];
            Arrays.fill(next, INF);

            for (int a = 0; a < n; a++) {
                if (dp[a] == INF) continue;

                // A가 훔치는 경우
                if (a + aCost < n) 
                    next[a + aCost] = Math.min(next[a + aCost], dp[a]);

                // B가 훔치는 경우
                if (dp[a] + bCost < m) 
                    next[a] = Math.min(next[a], dp[a] + bCost);
            }

            dp = next;
        }

        for (int a = 0; a < n; a++) {
            if (dp[a] < m) 
                return a;
        }

        return -1;
    }
}