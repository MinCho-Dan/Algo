package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(1);
			return;
		}
		if (N == 2) {
			System.out.println(2);
			return;
		}

		int[] dp = new int[N + 1];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= N; i++)
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

		System.out.println(dp[N]);
	}
}