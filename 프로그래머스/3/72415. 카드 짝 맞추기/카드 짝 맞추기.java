import java.util.*;

class Solution {
    static class Point {
        int r, c, cost;
        public Point(int r, int c, int cost) {
            this.r = r; 
            this.c = c; 
            this.cost = cost;
        }
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int minCost = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        boolean[] exist = new boolean[7];
        int cardCount = 0;
        
        // 카드 계산
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    exist[board[i][j]] = true;
                    cardCount++;
                }
            }
        }
        cardCount /= 2; // 카드쌍

        // 탐색 시작 (초기 선택 0개, 총 쌍의 개수, 시작점, 보드, 누적 조작, 카드 존재 여부)
        permutation(0, cardCount, r, c, board, 0, exist);
        
        return minCost;
    }

    // 카드 순열 구하기 일종의 거시적 DFS로 이해
    private void permutation(int depth, int maxDepth, int r, int c, int[][] board, int cost, boolean[] exist) {
        // 백트래킹 가지치기
        if (cost >= minCost) return;
        
        // 모두 제거하고 최소비용 갱신
        if (depth == maxDepth) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int k = 1; k <= 6; k++) {
            if (exist[k]) {
                exist[k] = false; // 카드 사용 처리
                
                // k번 카드의 두 좌표 찾기
                List<Point> pos = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (board[i][j] == k) {
                            pos.add(new Point(i, j, 0));
                        }
                    }
                }

                Point A = pos.get(0);
                Point B = pos.get(1);

                // 현재 위치 -> A -> B (각각 엔터키 누르는 횟수 +2)
                int cost1 = bfs(r, c, A.r, A.c, board) + bfs(A.r, A.c, B.r, B.c, board) + 2;
                int cost2 = bfs(r, c, B.r, B.c, board) + bfs(B.r, B.c, A.r, A.c, board) + 2;

                // 맞춰진 카드 보드에서 제거
                board[A.r][A.c] = 0;
                board[B.r][B.c] = 0;

                // 재귀로 깊이 우선 탐색
                permutation(depth + 1, maxDepth, B.r, B.c, board, cost + cost1, exist);
                permutation(depth + 1, maxDepth, A.r, A.c, board, cost + cost2, exist);

                // 백트래킹(복구)
                board[A.r][A.c] = k;
                board[B.r][B.c] = k;
                exist[k] = true;
            }
        }
    }

    // BFS로 출발지(sr, sc)에서 도착지(er, ec)까지
    private int bfs(int sr, int sc, int er, int ec, int[][] board) {
        if (sr == er && sc == ec)
            return 0;
        
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[4][4];
        
        q.offer(new Point(sr, sc, 0));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            if (cur.r == er && cur.c == ec)
                return cur.cost;

            for (int d = 0; d < 4; d++) {
                // 일반 이동
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new Point(nr, nc, cur.cost + 1));
                    }
                }

                // Ctrl + 이동
                nr = cur.r;
                nc = cur.c;
                while (true) {
                    nr += dr[d];
                    nc += dc[d];
                    
                    if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {
                        nr -= dr[d];
                        nc -= dc[d];
                        break;
                    }

                    if (board[nr][nc] != 0) {
                        break;
                    }
                }
                
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, cur.cost + 1));
                }
            }
        }
        return 0; 
    }
}