import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2583 {
	static int[][] arr;
	static boolean[][] visited;
	static int cnt, n, m;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        cnt = 0;
        arr = new int[n][m];
        visited = new boolean[n][m];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for (int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
			for (int j = b; j < d; j++) {
				for (int j2 = a; j2 < c; j2++) {
					arr[j][j2] = 1;
				}
			}
		}
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (arr[i][j] == 0 && !visited[i][j]) {
        			int area = dfs(i, j);
        			cnt++;
        			pq.offer(area);
        		}
        	}
		}
        
        for (int i = 0; i < cnt; i++) {
			sb.append(pq.poll() + " ");
		}
        
        System.out.println(cnt);
        System.out.println(sb);
    }

	private static int dfs(int y, int x) {
		visited[y][x] = true;
		int area = 1;
		
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx] || arr[ny][nx] == 1)
				continue;
			
			area += dfs(ny, nx);
		}
		
		return area;
	}
}