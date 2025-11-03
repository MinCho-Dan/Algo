package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_10816 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		String[] tmp = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(tmp[i]);
			map.putIfAbsent(key, 0);
			map.put(key, map.get(key) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		tmp = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(tmp[i]);
			sb.append(map.get(key) != null ? map.get(key) + " " : 0 + " ");
		}
		System.out.println(sb);
	}
}