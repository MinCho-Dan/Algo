import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2738 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int[][] mat1 = new int[N][M];
		int[][] mat2 = new int[N][M];
		int[][] mat = new int[N][M];

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				mat1[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				mat2[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mat[i][j] = mat1[i][j] + mat2[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}
}