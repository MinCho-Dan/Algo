package Maraton83;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_33710 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String S = br.readLine();

		List<int[]> intervals = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == 'X')
				continue;
			for (int j = i + 1; j < N; j++) {
				if (S.charAt(i) == S.charAt(j)) {
					intervals.add(new int[] { i, j, j - i + 1 });
				}
			}
		}

		int maxRemoved = 0;
		// 1개
		for (int[] in : intervals)
			maxRemoved = Math.max(maxRemoved, in[2]);

		// 2개
		for (int i = 0; i < intervals.size(); i++) {
			for (int j = i + 1; j < intervals.size(); j++) {
				int[] a = intervals.get(i);
				int[] b = intervals.get(j);
				if (a[1] < b[0] || b[1] < a[0]) {
					maxRemoved = Math.max(maxRemoved, a[2] + b[2]);
				}
			}
		}
		System.out.println(N - maxRemoved);
	}
}