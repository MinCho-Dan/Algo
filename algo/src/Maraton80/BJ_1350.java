package Maraton80;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1350 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());

		long res = 0;

		for (int i = 0; i < n; i++) {
			res += c * (arr[i] / c);
			if (arr[i] % c > 0)
				res += c;
		}

		System.out.println(res);
	}
}