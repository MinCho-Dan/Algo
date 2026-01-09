import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Point {
    int x, y, z;

    public Point(int z, int x, int y) {
    	this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class BJ_7569 {
	static int M, N, H;
    static int[][][] map;
    // 3차원 6방향
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static ArrayDeque<Point> queue = new ArrayDeque<>();
    
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    // 익은 토마토(1)는 시작점이므로 큐에 바로 삽입
                    if (map[i][j][k] == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }
        
        bfs();
        
        int maxDays = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxDays = Math.max(maxDays, map[i][j][k]);
                }
            }
        }

        System.out.println(maxDays - 1);
        
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nz][nx][ny] == 0) {
                        // 이전 토마토 값에 +1해서 날짜 누적
                        map[nz][nx][ny] = map[current.z][current.x][current.y] + 1;
                        queue.add(new Point(nz, nx, ny));
                    }
                }
            }
        }
	}

}
