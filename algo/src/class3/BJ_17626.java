package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_17626 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;

			for (int j = 0; j * j <= i; j++) {
				int square = j * j;

				dp[i] = Math.min(dp[i], dp[i - square] + 1);
			}
		}
		System.out.println(dp[N]);
	}

}