import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15784 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
        
        for (int i = 0; i < n; i++) {
			if (arr[i][b] > arr[a][b]) {
				System.out.println("ANGRY");
				break;
			} else if (arr[a][i] > arr[a][b]) {
				System.out.println("ANGRY");
				break;
			}
			if (i == n - 1)
				System.out.println("HAPPY");
		}

        
    }
}
