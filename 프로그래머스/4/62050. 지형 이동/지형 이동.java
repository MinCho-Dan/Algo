import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // int[]에는 r,c,cost 순으로 넣음 (cost는 pq에만)
        ArrayDeque<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2];
        });
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        q.offer(new int[] {0, 0});
        while (true) {
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                
                for (int i = 0;i < 4;i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc])
                        continue;
                    
                    if (Math.abs(land[r][c] - land[nr][nc]) > height) { // 사다리가 필요하면 pq에
                        pq.offer(new int[] {nr, nc, Math.abs(land[r][c] - land[nr][nc])});
                    } else { // 사다리 필요없으면 이동
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
            
            // 이미 방문한 후보 제거
            while (!pq.isEmpty() && visited[pq.peek()[0]][pq.peek()[1]])
                pq.poll();
            
            // 모든 칸 방문 완료
            if (pq.isEmpty())
                break;
            
            // 최소비용 사다리 선택
            int[] next = pq.poll();

            answer += next[2];

            visited[next[0]][next[1]] = true;
            q.offer(new int[] {next[0], next[1]});
        }
        
        return answer;
    }
}