import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_9205_맥주마시면서걸어가기 {
	
	static ArrayList<int[]> list;
	static int N;
	static boolean[] visited;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int t = Integer.parseInt(st.nextToken()); // TC수
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 편의점 개수
			
			list = new ArrayList<>();
			visited = new boolean[N + 2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			result = "sad";
			dfs(0);
			System.out.println(result);
			
		}
	}
			
	public static void dfs(int current) {
		if (current == N + 1) {
			result = "happy";
			return;
		}
		
		visited[current] = true;
			
		for (int i = 0; i < N + 2; i++) {
			if (!visited[i]) {
				int a = Math.abs(list.get(current)[0] - list.get(i)[0]);
				int b = Math.abs(list.get(current)[1] - list.get(i)[1]);
				if (a + b <= 1000) {
					dfs(i);
				}
			}
		}
	}
}
