class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        int rowLen = target.length;
        int colLen = target[0].length;
        int[][] map = new int[rowLen][colLen];
        
        for (int i = 0;i < rowLen;i++) {
            for (int j = 0;j < colLen;j++) {
                if (target[i][j] == beginning[i][j])
                    map[i][j] = 0;
                else
                    map[i][j] = 1;
            }
        }
        
        int ans1 = check(map, false);
        int ans2 = check(map, true);

        if (ans1 == -1 && ans2 == -1) return -1;
        if (ans1 == -1) return ans2;
        if (ans2 == -1) return ans1;
        return Math.min(ans1, ans2);
    }
    
    public int check(int[][] map, boolean firstFlip) {
        int n = map.length;
        int m = map[0].length;
        boolean[] colFlip = new boolean[m];
        int cnt = 0;
        
        // 첫 행 뒤집는지 아닌지
        if (firstFlip)
            cnt++;
        
        // 첫 행을 기준으로 열 결정
        for (int j = 0; j < m; j++) {
            int value = map[0][j];

            if (firstFlip)
                value ^= 1;

            if (value == 1) {
                colFlip[j] = true;
                cnt++;
            }
        }
        
        // 모든 행 검사
        for (int i = 1; i < n; i++) {

            // 첫 번째 열만 보고 이 행을 뒤집을지 결정
            int firstCol = map[i][0];

            if (colFlip[0])
                firstCol ^= 1;

            boolean rowFlip = (firstCol == 1);

            if (rowFlip)
                cnt++;

            // 행 전체가 전부 0이 되는지 확인
            for (int j = 0; j < m; j++) {

                int value = map[i][j];

                if (colFlip[j])
                    value ^= 1;

                if (rowFlip)
                    value ^= 1;

                if (value != 0)
                    return -1;
            }
        }
        
        return cnt;
    }
}