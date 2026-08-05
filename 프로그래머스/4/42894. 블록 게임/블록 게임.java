import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        // 블록 좌표를 저장할 리스트
        List<int[]>[] coords = new List[201];
        int answer = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // b = block
                int b = board[r][c];
                if (b == 0) {
                    // -1을 검은 블록으로 사용
                    board[r][c] = (r == 0 || board[r-1][c] == -1) ? -1 : 0;
                } else {
                    if (coords[b] == null) coords[b] = new ArrayList<>();
                    coords[b].add(new int[]{r, c});
                    if (coords[b].size() == 4 && canRemove(board, b, coords[b])) {
                        answer++;
                        // 삭제 되었으니 -1로 칠하기
                        for (int[] p : coords[b]) {
                            int rr = p[0], cc = p[1];
                            board[rr][cc] = (rr == 0 || board[rr-1][cc] == -1) ? -1 : 0;
                        }
                    }
                }
            }
        }
        return answer;
    }

    boolean canRemove(int[][] board, int b, List<int[]> pts) {
        int r1 = 51, r2 = -1, c1 = 51, c2 = -1;
        // 바운딩 박스 설정
        for (int[] p : pts) {
            r1 = Math.min(r1, p[0]); r2 = Math.max(r2, p[0]);
            c1 = Math.min(c1, p[1]); c2 = Math.max(c2, p[1]);
        }
        
        // 검정블록 or 본인블록 외에 다른 블록이 있다면 실패
        for (int r = r1; r <= r2; r++)
            for (int c = c1; c <= c2; c++)
                if (board[r][c] != -1 && board[r][c] != b) return false;
        return true;
    }
}