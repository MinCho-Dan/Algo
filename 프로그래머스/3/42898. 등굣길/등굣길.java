class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int [n + 1][m + 1];
        dp[1][1] = 1;
        
        boolean[][] puddle = new boolean[n + 1][m + 1];
        for (int[] p : puddles)
            puddle[p[1]][p[0]] = true;;
        
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= m;j++) {
                if (i == 1 && j == 1)
                    continue;
                
                if (puddle[i][j])
                    continue;
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        
        return dp[n][m];
    }
}