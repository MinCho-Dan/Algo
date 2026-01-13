package Maraton84;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11123 {
	static int n, m, cnt;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int T = 0; T < tc; T++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) 
					arr[i][j] = str.charAt(j);
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == '#') {
						cnt++;
						dfs(i, j);
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int x, int y) {
		
		arr[x][y] = '.';
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] =='.') 
				continue;
			
			dfs(nx, ny);
		}
        
		
	}
}