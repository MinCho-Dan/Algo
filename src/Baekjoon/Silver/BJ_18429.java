import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_18429 {
	static int cnt = 0, n, k ;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) 
        	arr[i] = (Integer.parseInt(st.nextToken()));
		
        chk(0, 500);
        
        System.out.println(cnt);
	}

	private static void chk(int depth, int w) {
		
		if (depth == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				int W = w + arr[i] - k;
				
				if (W >= 500) {
	                visited[i] = true;
	                chk(depth + 1, W);
	                visited[i] = false;
	            }
			}
		}
	}
}