package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 1; i < N; i++) {
			int sum = i;
			int tmp = i;

			while (tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}

			if (sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
