package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9095 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		for (int i = 5; i <= 11; i++)
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		
		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}

		System.out.println(sb);
	}

}
