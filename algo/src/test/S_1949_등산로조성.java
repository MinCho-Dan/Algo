package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_1949_등산로조성 {
	
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static int maxLen;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1 , 1};
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= T; i++) { // 테케반복
			sb.append("#" + i + " ");
			
			String[] temp = in.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			K = Integer.parseInt(temp[1]);
			int max = Integer.MIN_VALUE;
			maxLen = 0;
			
			map = new int[N][N]; // 맵 입력
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				temp = in.readLine().split(" ");
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Integer.parseInt(temp[j2]);
					if (map[j][j2] > max) max = map[j][j2]; // 최고높이 저장
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (map[j][j2] == max) { // 최고높이를 시작점으로
						visited[j][j2] = true;
						dfs(j, j2, 1, false);
						visited[j][j2] = false;
					}
				}
			}
			
			sb.append(maxLen + "\n");	
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int len, boolean cut) {
		
		if (len > maxLen) maxLen = len; // 최대 길이 저장
		
		for (int i = 0; i < 4; i++) { // 상하좌우 판별
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && // map 범위내
				!visited[nx][ny]) { // 방문하지 않은곳
				// 안깎아도 되는 경우 바로 재귀
				if (map[nx][ny] < map[x][y]) {
					visited[nx][ny] = true;
					dfs(nx, ny, len + 1, cut);
					visited[nx][ny] = false;
				}
				
				// 깎아야 하는 경우
				else if (!cut && map[nx][ny] - K < map[x][y]) {
					int tmp = map[nx][ny];
					map[nx][ny] = map[x][y] - 1; // 깎고
					
					visited[nx][ny] = true;
					dfs(nx, ny, len + 1, true); // 재귀 돌리고
					visited[nx][ny] = false;
					
					map[nx][ny] = tmp; // 복구 (백트래킹)
				}
			}
		}
		
	}
}
