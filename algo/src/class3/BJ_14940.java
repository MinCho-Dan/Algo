package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14940 {
	
	static int N, M;
	static int[][] map, dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int startx = -1;
		int starty = -1;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(tmp[j]);
				map[i][j] = a;
				if (a == 2) {
					startx = i;
					starty = j;
				}
			}
		}
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
		
        
        bfs(startx, starty);
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==0) sb.append(0 + " ");
				else sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
        
        System.out.println(sb);

	}

	private static void bfs(int startX, int startY) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX, startY});
		dist[startX][startY] = 0;
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M &&
					dist[nx][ny] == -1 && map[nx][ny] != 0) {
					q.offer(new int[] {nx, ny});
					dist[nx][ny] = dist[x][y] + 1;
				}
				
			}
			
		}
		
	}



}
