package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_6131 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i = 1; i < 500; i++) {
			int A = i * i;
			for (int j = 1; j < i + 1; j++) {
				int B = j * j;
				if (A < B)
					break;
				if (A - N == B) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);

	}
}
