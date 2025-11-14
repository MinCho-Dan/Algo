package Maraton76;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25494 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int T = 0; T < TC; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int cnt = 0;

			for (int i = 1; i <= a; i++) {
				for (int j = 1; j <= b; j++) {
					for (int k = 1; k <= c; k++) {
						if ((i % j) == (j % k) && (j % k) == (k % i))
							cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}

		System.out.println(sb);
	}

}
