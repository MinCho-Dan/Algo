package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_1600_말이되고픈원숭이 {
	
	static int K, r, c;
	static int[][] map;
	static int[][][] visited;
	static int minLen;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1 , 1};
	static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static class Monkey {
        int x, y, k, dist;

        public Monkey(int x, int y, int k, int dist) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = dist;
        }
    }
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		K = Integer.parseInt(in.readLine());

		String[] temp = in.readLine().split(" ");
		c = Integer.parseInt(temp[0]);
		r = Integer.parseInt(temp[1]);
		minLen = Integer.MAX_VALUE;
		
		map = new int[r][c]; // 맵 입력
		visited = new int[r][c][K + 1];
		for (int j = 0; j < r; j++) {
			temp = in.readLine().split(" ");
			for (int j2 = 0; j2 < c; j2++) {
				map[j][j2] = Integer.parseInt(temp[j2]);
			}
		}
		

		sb.append(bfs());

		System.out.println(sb);
	}
	
	public static int bfs() {
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, K, 0));
        visited[0][0][K] = 1;

        while (!q.isEmpty()) {
            Monkey current = q.poll();

            // 목표 지점에 도착한 경우
            if (current.x == r - 1 && current.y == c - 1) {
                return current.dist;
            }

            // 1. 원숭이의 일반적인 4방향 이동
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 0 && visited[nx][ny][current.k] == 0) {
                    visited[nx][ny][current.k] = 1;
                    q.add(new Monkey(nx, ny, current.k, current.dist + 1));
                }
            }

            // 2. 말의 8방향 점프 이동
            if (current.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + hdx[i];
                    int ny = current.y + hdy[i];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 0 && visited[nx][ny][current.k - 1] == 0) {
                        visited[nx][ny][current.k - 1] = 1;
                        q.add(new Monkey(nx, ny, current.k - 1, current.dist + 1));
                    }
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없는 경우
    }

}
