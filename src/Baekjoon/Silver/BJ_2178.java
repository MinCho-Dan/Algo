import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_2178 {
	
	static int N, M;
    static int[][] maze;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];
		
		// 최단거리 2차원 배열 초기화
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        bfs(0, 0);

        System.out.println(dist[N - 1][M - 1]);
	}

	public static void bfs(int startX, int startY) {
		
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY});
        dist[startX][startY] = 1; // 방문처리 겸 depth

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue; 

                // dist 값이 0이라는건 방문 하지 않았다는 뜻.
                // 기존 dist[x][y] + 1의 값을 dist[nx][ny]에 넣어
                // 방문했음을 알림과 동시에 depth를 같이 저장함
                if (maze[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
	}
}