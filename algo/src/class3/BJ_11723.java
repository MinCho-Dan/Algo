package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		boolean[] S = new boolean[21];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			int val = 0;
			if (st.countTokens() == 1)
				val = Integer.parseInt(st.nextToken());
			else {
				switch (func) {
				case "all":
					for (int j = 0; j < 21; j++)
						S[j] = true;
					break;
				case "empty":
					S = new boolean[21];
					break;
				}
			}
			switch (func) {
			case "add":
				S[val] = true;
				break;
			case "remove":
				S[val] = false;
				break;
			case "check":
				if (S[val]) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;
			case "toggle":
				S[val] = !S[val];
				break;

			}
		}
		System.out.println(sb);
	}
}
