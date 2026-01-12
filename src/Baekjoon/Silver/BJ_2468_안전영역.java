import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;


public class BJ_2468_안전영역 {
	
	static int N, cnt;
	static boolean[][] visited;
	static int[][] map;
	public static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	public static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		// 초기화
		map = new int[N][N];
		int res = 1; // h = 0일때 1임
		int max = -1;
		
		// 맵 입력
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(tmp[j]);
				map[i][j] = a;
				if (a > max) max = a; // 맵 최대높이 저장
			}
		}
		
		for (int H = 1;  H < max ; H++) { // 높이에 따른 반복
			visited = new boolean[N][N]; // 높이 바뀔때마다 초기화
			cnt = 0;
			for (int i = 0; i < N; i++) { // 이중포문으로
				for (int j = 0; j < N; j++) { // 모든 시작점 dfs 돌리기
					if (map[i][j] > H && !visited[i][j]) {
						cnt++;
						dfs(i, j, H);
					}
				}
			}
			if (cnt > res) res = cnt;
		}
		System.out.println(res);
	}

	private static void dfs(int x, int y, int H) {
		
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) { // 델타 범위 확인
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && // 맵 내부이고
				!visited[nx][ny] && // 방문하지 않았고
				map[nx][ny] > H) { // 물 높이 이상일때만 방문
				dfs(nx, ny, H);
			}
		}
	}

}
