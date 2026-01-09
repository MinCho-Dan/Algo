import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1018 {

	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		int minVal = 10000;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int res = chk(i, j);
				if (res < minVal)
					minVal = res;
			}
		}
		
		System.out.println(minVal);

	}

	private static int chk(int row, int col) {

		int minVal = 10000;
		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					if (map[row + i][col + j] != 'B')
						cnt++;
				} else {
					if (map[row + i][col + j] != 'W')
						cnt++;
				}
				if (i == 7 && j == 7) {
					if (cnt > 64 - cnt)
						cnt = 64 - cnt;
					if (minVal > cnt)
						minVal = cnt;
				}
			}
		}
		return minVal;
	}
}

