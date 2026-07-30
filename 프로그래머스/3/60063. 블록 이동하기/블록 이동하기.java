import java.util.*;

class Solution {
    
    // 가로든 세로든 r,c를 로봇의 좌상단으로 가정
    static class Robot {
        int r;
        int c;
        int dir;
        int dist;
        
        public Robot(int r, int c, int dir, int dist){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.dist = dist;
        }
    }
    
    int N;
    int map[][];
    boolean[][][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] board) {

        N = board.length;
        map = new int[N + 2][N + 2];
        
        for (int i = 0; i < N + 2; i++)
            Arrays.fill(map[i], 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i + 1][j + 1] = board[i][j];
        }
        
        visited = new boolean[N + 2][N + 2][2];
        ArrayDeque<Robot> q = new ArrayDeque<>();
        q.offer(new Robot(1, 1, 0, 0));
        visited[1][1][0] = true;
        
        while (!q.isEmpty()) {
            Robot cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            
            // 도착
            if (cur.dir == 0) {
                if (r == N && c + 1 == N)
                    return cur.dist;
            } else {
                if (r + 1 == N && c == N)
                    return cur.dist;
            }
            
            for(Robot next : nextRobot(cur)){
                if (visited[next.r][next.c][next.dir])
                    continue;
                
                visited[next.r][next.c][next.dir] = true;
                q.offer(next);
            }
        }
        
        return -1;
    }
    
    // 현재위치에서 평행이동/회전하여 다음번에 큐에 들어갈 리스트 반환 
    public List<Robot> nextRobot(Robot cur) {
        List<Robot> list = new ArrayList<>();
        
        move(cur, list);
        rotate(cur, list);
        
        return list;
    }
    
    // 상하좌우 평행이동
    public void move(Robot cur, List<Robot> list) {
        
        for (int i = 0;i < 4;i++) {
            int nr = cur.r + dr[i];
            int nc = cur.c + dc[i];
            
            if (cur.dir == 0) { // 가로인경우
                if (map[nr][nc] == 0 &&
                    map[nr][nc + 1] == 0)
                    list.add(new Robot(nr, nc, 0, cur.dist + 1));
            } else { // 세로인경우
                if (map[nr][nc] == 0 &&
                    map[nr + 1][nc] == 0)
                    list.add(new Robot(nr, nc, 1, cur.dist + 1));
            }
        }
    }
    
    // 회전
    public void rotate(Robot cur, List<Robot> list) {
        if (cur.dir == 0) { // 가로를 세로로
            for (int i : new int[]{-1, 1}) {
                if (map[cur.r + i][cur.c] == 0 &
                    map[cur.r + i][cur.c + 1] == 0) {
                    if (i == -1) { // 위로 회전
                        list.add(new Robot(cur.r - 1, cur.c, 1, cur.dist + 1));
                        list.add(new Robot(cur.r - 1, cur.c + 1, 1, cur.dist + 1));
                    } else { // 아래로 회전
                        list.add(new Robot(cur.r, cur.c, 1, cur.dist + 1));
                        list.add(new Robot(cur.r, cur.c + 1, 1, cur.dist + 1));
                    }
                }
            }
        } else { // 세로를 가로로
            for (int i : new int[]{-1, 1}) {
                if (map[cur.r][cur.c + i] == 0 &
                    map[cur.r + 1][cur.c + i] == 0) {
                    if (i == -1) { // 왼쪽으로 회전
                        list.add(new Robot(cur.r, cur.c - 1, 0, cur.dist + 1));
                        list.add(new Robot(cur.r + 1, cur.c - 1, 0, cur.dist + 1));
                    } else { // 오른쪽으로 회전
                        list.add(new Robot(cur.r, cur.c, 0, cur.dist + 1));
                        list.add(new Robot(cur.r + 1, cur.c, 0, cur.dist + 1));
                    }
                }
            }
        }
    }
    
}