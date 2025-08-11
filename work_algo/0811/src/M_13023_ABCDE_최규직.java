import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class M_13023_ABCDE_최규직 {
	
	
	public static int N;
	public static int M;
	public static int[] visited;
	public static int[][] connect;
	
	public static void main(String[] args) throws Exception {
		 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
        String[] split = in.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        
        connect = new int[N][N]; // 인접행렬.
        
        for (int i = 0; i < M; i++) {
        	String[] tmp = in.readLine().split(" ");
        	int x = Integer.parseInt(tmp[0]);
        	int y = Integer.parseInt(tmp[1]);
			connect[x][y] = 1;
			}
        
        visited = new int[N];
        
        dfs(0);
        
        for (int i = 0; i < N; i++) {
			System.out.println(visited[i]);
		}
        
        int result = 1;
        for (int i = 0; i < N; i++) {
			if (visited[i] == 0) {
				result = 0;
			}
		}
        
        System.out.println(result);
		}

	private static void dfs(int start) {
		
		visited[start] = 1;
		
		for (int i = 0; i < N; i++) {
			if (visited[i]==0 &&
				connect[start][i]==1) {
				visited[i] = 1;
				dfs(i);
			}
		}
	}
	
 
	
}



/*
 * 문제에 대해 고민해보기.
 * 
 */