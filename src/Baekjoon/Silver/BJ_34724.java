import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_34724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n ; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m ; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				if (arr[i][j]==1 &&
						arr[i][j] == arr[i+1][j] &&
						arr[i][j] == arr[i][j+1] &&
						arr[i][j] == arr[i+1][j+1]) {
					System.out.println(1);
					return;
				}
			}
		}
		
		System.out.println(0);
	}
}