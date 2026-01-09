import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_18868 {
	
	static int[][] arr;
	static int N, M, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		cnt = 0;
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(tmp[j]);
		}
		
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				cnt += chk(i, j);
			}
		}

		System.out.println(cnt);
	}

	private static int chk(int a, int b) {
		
		for (int i = 0; i < M; i++) {
			for (int j = i+1; j < M; j++) {
				if (arr[a][i] < arr[a][j]) {
					if (!(arr[b][i] < arr[b][j]))
						return 0;
				} else if (arr[a][i] > arr[a][j]) {
					if (!(arr[b][i] > arr[b][j]))
						return 0;
				} else if (arr[a][i] == arr[a][j]) {
					if (!(arr[b][i] == arr[b][j]))
						return 0;
				}
			}
		}
		return 1;
	}
}