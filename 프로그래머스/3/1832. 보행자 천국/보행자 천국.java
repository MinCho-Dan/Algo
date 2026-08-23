class Solution {
    int MOD = 20170805;
    int[][] cityMap;
    int m, n;
    int answer = 0;
    // int[] dr = {0, 1};
    // int[] dc = {1, 0};
    
    // [r][c][dir]순서이고, dir : 0 = 오른쪽으로 이동해옴, 1 = 아래로 이동해옴
    int[][][] dp;
    
    public int solution(int m, int n, int[][] cityMap) {
        
        answer = 0;
        this.m = m;
        this.n = n;
        this.cityMap = cityMap;
        // dfs(0, 0, 0);
        
        dp = new int[m][n][2];
        // (0, 1)과 (1, 0)으로 이동한 경우 추가
        if (n > 1 && cityMap[0][1] != 1)
            dp[0][1][0] = 1;
        if (m > 1 && cityMap[1][0] != 1)
            dp[1][0][1] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue; // (0, 0)은 건너뛰기
                if (cityMap[r][c] == 1) continue;
                
                // 우측 이동
                if (c + 1 < n && cityMap[r][c + 1] != 1) {
                    if (cityMap[r][c] == 2) {
                        dp[r][c + 1][0] += dp[r][c][0];
                    } else {
                        dp[r][c + 1][0] += dp[r][c][0];
                        dp[r][c + 1][0] += dp[r][c][1];
                    }
                    
                    dp[r][c + 1][0] %= MOD;
                }
                
                // 하단 이동
                if (r + 1 < m && cityMap[r + 1][c] != 1) {
                    if (cityMap[r][c] == 2) {
                        dp[r + 1][c][1] += dp[r][c][1];
                    } else {
                        dp[r + 1][c][1] += dp[r][c][0];
                        dp[r + 1][c][1] += dp[r][c][1];
                    }
                    
                    dp[r + 1][c][1] %= MOD;
                }
            }
        }
        answer = (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
        
        return answer;
    }
    
    // DFS는 시간초과 ㅠㅠ
//     public void dfs(int r, int c, int dir) {
//         if (r == m - 1 && c == n - 1)
//             answer = (answer + 1) % MOD;
        
//         for (int i = 0;i < 2;i++) {
//             if (cityMap[r][c] == 2 && dir == 1 && i == 1) continue; // 하단이동 좌회전 불가
//             if (cityMap[r][c] == 2 && dir == 2 && i == 0) continue; // 우측이동 우회전 불가
            
//             int nr = r + dr[i];
//             int nc = c + dc[i];
            
//             if (nr >= m || nc >= n || cityMap[nr][nc] == 1)
//                 continue;
            
//             int ndir = (i == 0 ? 1 : 2);
//             dfs(nr, nc, ndir);
//         }
//     }
}