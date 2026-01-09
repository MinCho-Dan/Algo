import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class M_17070_파이프옮기기1_최규직 {
	
	static int[][] map;
	static int N, cnt;
	static int[] dx = {0, 1, 1}; // 우 대각 하
	static int[] dy = {1, 1, 0};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		cnt = 0;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N]; // 맵 입력
		for (int i = 0; i < N; i++) {
			String[] temp = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		bfs();
		
		System.out.println(cnt);
		
	}


	private static void bfs() {
		int cx = 0;
		int cy = 1;
		int dir = 0; // 가로 대각 세로 순서
		
		// (0, 1, 가로방향) 시작으로 큐에 넣고 while문 bfs 시작.
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(cx);
		queue.offer(cy);
		queue.offer(dir);
		
		// 모든 경우의 수를 보는 것이므로 visited 배열 불필요.
		
		while (!queue.isEmpty()) {
			cx = queue.poll();
			cy = queue.poll();
			dir = queue.poll();
			
			if (cx == N - 1 && cy == N - 1) { // 도착점 도달 시 cnt 증가
				cnt++;
				continue;
			}
			
			for (int i = 0; i < 3; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (dir==0 && i==2) continue; // 가로일때 하단 불가
				if (dir==2 && i==0) continue; // 세로일때 우측 불가
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) { //  범위내
					if (map[nx][ny] == 0) {// 벽이 아니고 방문하지 않았다면
						// 대각선 이동할때, 우측과 하단도 0이여야 이동이 가능함.
						if (i == 1) {
							if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
								queue.offer(nx);
								queue.offer(ny);
								queue.offer(i);
							}
						}
						else { // 대각선이 아닌경우
							queue.offer(nx);
							queue.offer(ny);
							queue.offer(i);
						}
					}
				}
			}
		}
		
	}
	
}
