package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1913_달팽이_안에서밖으로 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); 
		int findNum = Integer.parseInt(in.readLine()); 
		
		int[][] map = new int[N][N];
		int cnt = 2;
		
		map[N/2][N/2] = 1;
		int x = N/2, y = N/2, findX = -1, findY = -1;
		int go = 1;
		
		if (1 == findNum) { // 찾는 숫자가 1인 경우
			findX = x;
			findY = y;
		}
		
		while (true) {
			// 위로
			for (int i = 1; i <= go; i++) {
				x--;
				map[x][y] = cnt;
				if (cnt==findNum) {
					findX = x;
					findY = y;
				}
				if (cnt == N*N) break;
				cnt++;
			} 
			
			if (cnt == N*N) break;
			
			// 오른쪽으로
			for (int i = 1; i <= go; i++) {
				y++;
				map[x][y] = cnt;
				if (cnt==findNum) {
					findX = x;
					findY = y;
				}
				cnt++;
			}
			
			go++;
			
			// 아래로
			for (int i = 1; i <= go; i++) {
				x++;
				map[x][y] = cnt;
				if (cnt==findNum) {
					findX = x;
					findY = y;
				}
				cnt++;
			}
			
			// 왼쪽으로
			for (int i = 1; i <= go; i++) {
				y--;
				map[x][y] = cnt;
				if (cnt==findNum) {
					findX = x;
					findY = y;
				}
				cnt++;
			}
			
			go++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println( (findX+1) + " " + (findY+1) );
	}
}
