package Maraton83;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_11256 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());
			Integer[] boxsize = new Integer[box];
			for (int i = 0; i < box; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				boxsize[i] = a * b;
			}
			Arrays.sort(boxsize, Comparator.reverseOrder());
			int cnt = 0;
			while (target > 0) {
				target -= boxsize[cnt];
				cnt++;
			}
			sb.append(cnt + "\n");
		}

		System.out.println(sb);
	}
}