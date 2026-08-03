class Solution {
    
    int N, M;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    class Result {
        boolean win;
        int move;

        Result(boolean win, int move) {
            this.win = win;
            this.move = move;
        }
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;

        return dfs(board,
                aloc[0], aloc[1],
                bloc[0], bloc[1]).move;
    }
    
    Result dfs(int[][] board, int cr, int cc, int or, int oc) {
        // 발판이 없으면 즉시 패배
        if (board[cr][cc] == 0)
            return new Result(false, 0);

        boolean canMove = false;
        boolean canWin = false;
        int winMove = Integer.MAX_VALUE;
        int loseMove = 0;

        for (int d = 0; d < 4; d++) {

            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                continue;

            if (board[nr][nc] == 0)
                continue;

            canMove = true;

            board[cr][cc] = 0;

            // 현재와 상대를 뒤집어서 호출 (턴이 넘어감)
            Result next = dfs(board, or, oc, nr, nc);

            board[cr][cc] = 1;

            // next.win == false
            // => 상대는 진다
            // => 현재의 내가 이긴다.
            if (!next.win) {
                canWin = true;
                winMove = Math.min(winMove, next.move + 1);
            } else {
                loseMove = Math.max(loseMove, next.move + 1);
            }
        }

        if (!canMove)
            return new Result(false, 0);

        if (canWin)
            return new Result(true, winMove);

        return new Result(false, loseMove);
    }
    
}