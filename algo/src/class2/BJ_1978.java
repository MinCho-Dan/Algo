package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (isPrime(Integer.parseInt(tmp[i])))
				cnt++;
		}

		System.out.println(cnt);

	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
