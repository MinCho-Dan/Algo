class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean [n + 1][n + 1];
        boolean[][] lose = new boolean [n + 1][n + 1];
        for (int[] r : results) {
            win[r[0]][r[1]] = true;
            lose[r[1]][r[0]] = true;
        }
        
        // 플로이드-워셜 i->k->j
        // win의 경우 : i가 k이김. k가 j이김. => i는 j를 이김.
        for (int k = 1;k < n + 1;k++) {
            for (int i = 1;i < n + 1;i++) {
                for (int j = 1;j < n + 1;j++) {
                    if (win[i][k] && win[k][j])
                        win[i][j] = true;
                    if (lose[i][k] && lose[k][j])
                        lose[i][j] = true;
                }
            }
        }
        
        // true의 개수가 n-1개라면 순위를 알 수 있음
        for (int i = 1;i < n + 1;i++) {
            int cnt = 0;
            for (int j = 1;j < n + 1;j++)
                if (win[i][j] || lose[i][j])
                    cnt++;
            if (cnt == n - 1)
                answer++;
        }
        
        return answer;
    }
}