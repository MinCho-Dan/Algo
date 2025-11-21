package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21736 {
	
	static int cnt, N, M;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cnt = 0;
		int x = -1, y = -1;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		dfs(x, y);

		if (cnt == 0)
			System.out.println("TT");
		else
			System.out.println(cnt);
	}

	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		if (arr[x][y] == 'P')
			cnt++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 'X') 
				continue;
			
			dfs(nx, ny);
			
		}
		
	}
}