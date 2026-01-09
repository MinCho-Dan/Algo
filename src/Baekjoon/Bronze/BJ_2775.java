import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < TC; T++) {
			
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[k + 1][n + 1];
			
			for (int i = 1; i <= n; i++) {
				map[0][i] = i;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}

			System.out.println(map[k][n]);
		}

	}
}