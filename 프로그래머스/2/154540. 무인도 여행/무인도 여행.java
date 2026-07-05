import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int xLen, yLen;
    int[][] map;
    boolean[][] visited;
    PriorityQueue<Integer> pq;
    
    public int[] solution(String[] maps) {
        xLen = maps.length;
        yLen = maps[0].length();
        
        map = new int[xLen][yLen];
        visited = new boolean[xLen][yLen];
        pq = new PriorityQueue<>();
        
        for (int i = 0;i < xLen;i++) {
            for (int j = 0;j < yLen;j++) {
                int tmp = maps[i].charAt(j) - '0';
                if (tmp >= 1 && tmp <= 9) {
                    map[i][j] = maps[i].charAt(j) - '0';
                } else {
                    map[i][j] = -1;
                }
            }
        }
        
         for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (!visited[i][j] && map[i][j] != -1) {
                    int sum = dfs(i, j);
                    pq.add(sum);
                }
            }
        }

        if (pq.isEmpty()) {
            return new int[]{-1};
        }

        int size = pq.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++)
            answer[i] = pq.poll();

        return answer;
    }

    public int dfs(int x, int y) {
        visited[x][y] = true;

        int sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= xLen || ny >= yLen)
                continue;

            if (visited[nx][ny] || map[nx][ny] == -1) {
                continue;
            }

            sum += dfs(nx, ny);
        }

        return sum;
    }
}