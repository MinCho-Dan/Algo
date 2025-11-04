package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();

		
		for (int i = 1; i <= N; i++)
			map.put(br.readLine(), 1);
		
		int cnt = 0;
		ArrayList<String> lst = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (map.containsKey(name)) {
				lst.add(name);
				cnt++;
			}
		}

		Collections.sort(lst);
		for (int i = 0; i < lst.size(); i++)
			sb.append(lst.get(i) + "\n");

		System.out.println(cnt);
		System.out.println(sb);
	}
}