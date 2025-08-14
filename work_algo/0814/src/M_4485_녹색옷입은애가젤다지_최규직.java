import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class M_4485_녹색옷입은애가젤다지_최규직 {
	
	public static class rupee{
		int x;
		int y;
		int weight;
		
		public rupee() {}

		public rupee(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
	}
	
	
	private static int N, result;
	private static int[][] map, visited;
    private static int[] dx = {-1, 1, 0, 0}; // 상하좌우 순서로
    private static int[] dy = {0, 0, -1, 1}; // 상하좌우 순서로
    
	public static void main(String[] args) throws Exception {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	    N = Integer.parseInt(in.readLine()); 
	    map = new int[N][N];
	    visited = new int[N][N];
	    result = Integer.MAX_VALUE;

	    for (int i = 0; i < N; i++) {
	    	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    bfs(0,0);
	    System.out.println(result);
        
    }

	private static int bfs(int x, int y) {
		int[][] min = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		
		
		min[0][0] = 0;
		
		Queue<Integer> pQueue = new PriorityQueue<>();
		
		// 첫번째 정점 방문 예약
		pQueue.offer(0);
		pQueue.offer(0);
		visited[x][y] = 1; // 방문 예약시 방문처리
		
		int temp = map[x][y];
		
		while (!pQueue.isEmpty()) {
			
			// 방문예약 한 것 중 맨 앞에 있는 정점
			x = pQueue.poll();
			y = pQueue.poll();
			
			// 방문한 정점에서 해야할 일 처리
			
			if (x==N && y==N && result > min[N][N])
				result = min[N][N];
				
			
			for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (nx >= 0 && nx < N && ny >= 0 && ny < N && // 동굴 범위 내
	            	visited[nx][ny] == 0) { // 방문여부 체크
	            		
						
						// 다음 정점을 방문예약.
						pQueue.offer(nx);
						pQueue.offer(ny);
						visited[nx][ny] = 1; // 첫정점과 마찬가지로 방문예약시 방문처리
						temp += map[x][y];
				}
			}

		}
		return -1;
	}
}

/*
 * N*N 크기의 동굴에 (0,0)에서 (N-1,N-1) 지점까지 최소로 돈을 잃고 도착하는 방법.
 * -> 최소 경로니까 다익스트라로 풀면 될거같다.
 * -> PQ써서 BFS처럼 스윽?
 * 
 */

