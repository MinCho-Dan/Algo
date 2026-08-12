class Solution {
    int[][] map;
    int[] dr = {-1, 1, 0, 0, 0};
    int[] dc = {0, 0, -1, 1, 0};
    int n;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] clockHands) {
        n = clockHands.length;
        map = clockHands;

        dfs(0, 0);

        return answer;
    }

    // 첫 번째 행 결정
    void dfs(int col, int count) {
        if (col == n) {
            solve(count);
            return;
        }

        // 현재 칸을 0, 1, 2, 3번 눌러본다
        for (int press = 0; press < 4; press++) {
            for (int i = 0; i < press; i++)
                work(0, col);
            // 다음 칸 결정
            dfs(col + 1, count + press);
            // 현재 칸 원상복구
            for (int i = 0; i < (4 - press) % 4; i++)
                work(0, col);
        }
    }

    // 2번째 행부터 전체 보기
    void solve(int count) {
        int[][] backup = new int[n][n];
        for (int i = 0; i < n; i++)
            backup[i] = map[i].clone();

        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < n; col++) {
                int press = (4 - map[row][col]) % 4;
                for (int i = 0; i < press; i++)
                    work(row + 1, col);
                count += press;
            }
        }

        // 마지막 행이 전부 0인지 확인
        for (int col = 0; col < n; col++) {
            if (map[n - 1][col] != 0) {
                restore(backup);
                return;
            }
        }

        answer = Math.min(answer, count);
        restore(backup);
    }

    // 실제로 시계를 돌림
    void work(int row, int col) {
        for (int i = 0; i < 5; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                continue;

            map[nr][nc] = (map[nr][nc] + 1) % 4;
        }
    }

    void restore(int[][] backup) {
        for (int i = 0; i < n; i++)
            map[i] = backup[i].clone();
    }
}