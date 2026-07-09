class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = board[0].length;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (board[i][j] == 1) {
                    for (int k = 0;k < 8;k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] != 0)
                            continue;
                        board[nx][ny] = 2;
                    }
                }
            }
        }

        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (board[i][j] == 0)
                    answer++;
            }
        }
        
        return answer;
    }
}