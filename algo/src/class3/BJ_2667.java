package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2667 {
	
	static int[][] arr;
    static boolean[][] visited;
    static int N, depth, cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static ArrayList<Integer> resultList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(tmp[j]);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false && arr[i][j] == 1) {
					depth = 0;
					dfs(i, j);
					cnt++;
					resultList.add(depth);
				}
			}
		}
		
		Collections.sort(resultList);
		
		sb.append(resultList.size() + "\n");
		
		for (int num : resultList) {
            sb.append(num + "\n");
        }
        
        System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		depth++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N ||
				visited[nx][ny] || arr[nx][ny] == 0)
				continue;
			
			dfs(nx,ny);
		}
	}

}
