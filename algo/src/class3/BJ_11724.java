package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11724 {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);

	}

	private static void dfs(int start) {

		visited[start] = true;

		for (int xx : graph.get(start)) {
			if (!visited[xx])
				dfs(xx);
		}

	}
}