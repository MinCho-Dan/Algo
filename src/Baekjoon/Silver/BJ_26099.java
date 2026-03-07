package Maraton92;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_26099 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		long cnt = 0;

		while (n >= 0 && n % 5 != 0) {
			n -= 3;
			cnt++;
		}

		if (n < 0)
			System.out.println(-1);
		else {
			System.out.println(cnt + (n / 5));
		}
	}
}