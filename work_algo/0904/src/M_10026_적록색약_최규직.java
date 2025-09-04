import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class M_10026_적록색약_최규직 {


	private static int N, cnt;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 변수 초기화
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		cnt = 0;
		
		// 입력
		for (int i = 0; i < N; i++) {
			char[] tmp = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j];
			}
		}
		
		// 전범위 방문.
		// 이미 방문한 구역은 visited가 true가 되어서 방문 안함.
		// visited가 false라는것은 방문하지않은 구역을 발견했다는 소리이므로
		// dfs 돌리기 + 카운트 증가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		int result1 = cnt;
		
		
		// 색약자 탐색을 위한 초기화
		visited = new boolean[N][N];
		cnt = 0;
		
		// 위와 동일, dfs2메서드는 Blue지역과 나머지 지역으로 나눠서 봄.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					dfs2(i, j);
					cnt++;
				}
			}
		}
		int result2 = cnt;
		
		System.out.println(result1 + " " + result2);
	}



	private static void dfs(int r, int c) {
		
		//방문처리
		visited[r][c] = true;
		
		//델타이동
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			// 다음 위치가 행렬의 범위내이고, 방문 안했고, 현재와 동일한 색이라면 -> dfs 재귀
			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC] &&
				map[nextR][nextC] == map[r][c]) {
				dfs(nextR,nextC);
			}
		}
	}
	
	private static void dfs2(int r, int c) {
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			// blue인경우, 동일하게 blue이면 방문
			if (map[r][c]=='B') {
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC] &&
					map[nextR][nextC] == map[r][c]) {
					dfs2(nextR,nextC);
				}
			}
			else { // 블루가 아니라면, 블루가 아닌 곳 방문
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC] &&
					map[nextR][nextC] != 'B') {
					dfs2(nextR,nextC);
				}
			}
		}
	}

}


