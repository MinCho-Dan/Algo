package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1003 {

	static int[][] dp = new int[41][2]; // N의 최대값 40

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// DP 테이블 미리 계산하기
		calculateDP();

		int TC = Integer.parseInt(br.readLine());

		for (int T = 0; T < TC; T++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(dp[a][0] + " " + dp[a][1] + "\n");
		}
		System.out.println(sb);
	}

	private static void calculateDP() {
		// 초기값 설정
		dp[0][0] = 1;
		dp[0][1] = 0;

		dp[1][0] = 0;
		dp[1][1] = 1;

		// 상향식으로 2부터 40까지 DP 테이블 채우기
		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
	}
}
