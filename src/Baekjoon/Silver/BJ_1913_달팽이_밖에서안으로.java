import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1913_달팽이_밖에서안으로 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); 
		int findNum = Integer.parseInt(in.readLine()); 
		
		int[][] map = new int[N][N];
		int cnt = N*N;
		
		int x = 0, y = 0, findX = -1, findY = -1;
		int dir = 0;
		
		// 아래 오른쪽 위 왼쪽 순서로 방향 세팅
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		while (cnt > 0) {
			map[x][y] = cnt;
			
			// 다음위치
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			// 범위벗어남 or 값이 이미 채워져 있으면 방향 전환
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) {
				dir = (dir + 1) % 4;
				
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
				
			x = nx;
			y = ny;
			
			cnt--;
		}
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == findNum) {
					findX = i + 1;
					findY = j + 1;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println( findX + " " + findY );
	}
}
