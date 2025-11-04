package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2606 {
	
	static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        dfs(1);
        
        System.out.println(count);

	}

	private static void dfs(int node) {
		visited[node] = true;
		
		for (int nn : graph[node]) {
			if (!visited[nn]) {
				count++;
				dfs(nn);
			}
		}
		
	}

}
