import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Pointt {
    int x, y;

    public Pointt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ_7576 {
	static int M, N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayDeque<Pointt> queue = new ArrayDeque<>();
    
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토(1)는 시작점이므로 큐에 바로 삽입
                if (map[i][j] == 1) {
                    queue.add(new Pointt(i, j));
                }
            }
        }
        
        bfs();
        
        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDays = Math.max(maxDays, map[i][j]);
            }
        }

        System.out.println(maxDays - 1);
        
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
            Pointt current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        // 이전 토마토 값에 +1해서 날짜 누적
                        map[nx][ny] = map[current.x][current.y] + 1;
                        queue.add(new Pointt(nx, ny));
                    }
                }
            }
        }
	}

}
