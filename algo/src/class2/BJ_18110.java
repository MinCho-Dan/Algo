package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_18110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int start = (int) Math.round((float) N * 0.15);
		int end = N - start;

		double s = 0;
		int cnt = 0;

		for (int i = start; i < end; i++) {
			s += arr[i];
			cnt++;
		}
		int res = (int) Math.round(s / cnt);

		System.out.println(res);
	}
}

