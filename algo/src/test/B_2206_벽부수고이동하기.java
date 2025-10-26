package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_2206_벽부수고이동하기 {
	public static int N;
	public static int M;
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	public static int[] dy = {0, 0, 1, -1};
	public static boolean[][][] visited;
	
    public static void main(String[] maps) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = in.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        
        map = new int[N][M];
        visited = new boolean[N][M][2];
        
        // 행렬 입력
        for (int i = 0; i < N; i++) {
        	String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
        
        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // {행, 열, 거리, 벽 파괴 여부}
        queue.add(new int[]{0, 0, 1, 0}); 
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            int wallBroken = current[3];

            if (r == N - 1 && c == M - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = r + dx[i];
                int nextC = c + dy[i];

                // 맵 범위 체크
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
                    // 다음 위치가 빈 공간일 경우
                    if (map[nextR][nextC] == 0) {
                        if (!visited[nextR][nextC][wallBroken]) {
                            visited[nextR][nextC][wallBroken] = true;
                            queue.add(new int[]{nextR, nextC, dist + 1, wallBroken});
                        }
                    }
                    // 다음 위치가 벽일 경우
                    else { // map[nextR][nextC] == 1
                        if (wallBroken == 0 && !visited[nextR][nextC][1]) {
                            visited[nextR][nextC][1] = true;
                            queue.add(new int[]{nextR, nextC, dist + 1, 1});
                        }
                    }
                }
            }
        }
        return -1; // 목적지 도달 불가
    }
}