package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1676 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 5; i <= N; i *= 5)
			cnt += N / i;

		System.out.println(cnt);
	}
}