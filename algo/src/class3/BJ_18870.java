package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_18870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] ori = new int[N];
		int[] sorted = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			ori[i] = num;
			sorted[i] = num;
		}

		Arrays.sort(sorted);

		int rank = 0;
		for (int key : sorted) {
			if (!map.containsKey(key)) {
				map.put(key, rank);
				rank++;
			}
		}

		for (int key : ori)
			sb.append(map.get(key) + " ");

		System.out.println(sb);
	}
}