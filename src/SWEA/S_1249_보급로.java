import java.io.BufferedReader;
import java.io.InputStreamReader;


// DFS로 풀었는데.. 원래는 BFS로 푸는 문제.
// DFS 가지치기 없으면 시간초과.
// 이 코드로는 약 11초 정도 소요
// 자바 기준 20초 이내인 문제라 PASS는 되는데...


public class S_1249_보급로 {
	
	static int N, K;
	static int[][] map, dist;
	static boolean[][] visited;
	static int minLen;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1 , 1};
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= T; i++) { // 테케반복
			sb.append("#" + i + " ");
			
			N = Integer.parseInt(in.readLine());
			minLen = Integer.MAX_VALUE;
			
			map = new int[N][N]; // 맵 입력
			dist = new int[N][N]; // 거리 입력 (가지치기용)
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				char[] temp = in.readLine().toCharArray();
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Character.getNumericValue(temp[j2]);
					dist[j][j2] = Integer.MAX_VALUE;
				}
			}
			
			dfs(0, 0, 0);

			
			sb.append(minLen + "\n");	
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int len) {
		
		if (len >= minLen) return;
		
		if ((x == N - 1) && (y == N - 1)) {
			if (len < minLen) minLen = len;
			return;
		}
		
		for (int i = 0; i < 4; i++) { // 상하좌우 판별
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 행렬범위 내
				
				int newLen = len + map[nx][ny];
				if (newLen < dist[nx][ny]) {
					dist[nx][ny] = newLen;
					dfs(nx, ny, newLen);
				}
			}
		}
	}
}
