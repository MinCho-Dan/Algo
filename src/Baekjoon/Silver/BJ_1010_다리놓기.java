import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1010_다리놓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] temp = in.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			
					
			// 1. 동적테이블
			int[][] D = new int[k+1][k+1];
			
			
			for (int i = 0; i <= k; i++) {
				int end = Math.min(i, k);
				for (int j = 0; j <= end; j++) {
					
					// 2. 베이스값 채우기
					if (j == 0 || j == i) {
						D[i][j] = 1;
					}
					// 3. 점화식
					else D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
				}
			}

			System.out.println(D[k][n]);
		}
	}
}
