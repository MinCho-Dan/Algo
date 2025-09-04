import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class M_1194_달이차오른다가자_최규직 {
	
	public static class point {
		int x, y, d, k;
		
		public point(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
	}


	private static int N, M;
	private static char[][] map;
	private static boolean[][][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		int startX = 0, startY = 0;
		for (int i = 0; i < N; i++) {
			char[] tmp = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j]; // 맵 입력
				if (tmp[j]=='0') { // 시작점 찾아서 저장.
					startX = i;
					startY = j;
				}
			}
		}
		//000000 -> 000001 ~ 111111 => 64개
		// 3차원배열, 6개의 열쇠를 가지는 부분집합의 수 ->pow(2, 6)이므로 64개
		visited = new boolean[N][M][64];
		System.out.println(bfs(startX, startY)); // 시작점부터 BFS
		

	}

	private static int bfs(int x, int y) {
		
		// 큐선언하고 시작점부터 큐에 넣고 방문처리
		Queue<point> queue = new LinkedList<>();
		queue.add(new point(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while (!queue.isEmpty()) { 
			point current = queue.poll();
			
			if (map[current.x][current.y] == '1') { // 1을 만나면 거리 리턴
				return current.d; // BFS라서 그냥 최소값임.
			}
			
			for (int i = 0; i < 4; i++) { // 델타이동
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				int nd = current.d + 1; // 다음 위치로 이동 시 거리 +1
				int nk = current.k; // 열쇠
				
				// 범위 밖이거나 벽이라면 for문 처음으로.
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny]=='#') continue;
				
				char next = map[nx][ny];
				// 다음 위치가 열쇠라면
				if (next >= 'a' && next <= 'f') {
					nk |= (1 << (next - 'a')); // 비트마스킹으로 nk(열쇠소유) 갱신.
				}
				
				// 다음위치가 문이라면
				else if (next >= 'A' && next <= 'F') {
					if ((nk & (1 << (next - 'A'))) == 0) continue; // 열쇠가 없으면 for문 처음으로
				}
				
				if (!visited[nx][ny][nk]) { // 다음 위치로 갈 수 있고 방문하지 않았다면
					visited[nx][ny][nk] = true; // 방문처리하고 큐에 추가.
					queue.add(new point(nx, ny, nd, nk));
				}
			}
		}
		
		return -1; // 모든 탐색을 마쳤을때 1을 만나지 못한 경우
	}
}
