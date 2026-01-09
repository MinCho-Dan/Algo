import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_7568 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] cm = new int[N];
		int[] kg = new int[N];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			kg[i] = Integer.parseInt(tmp[0]);
			cm[i] = Integer.parseInt(tmp[1]);
		}
		
		for (int i = 0; i < N; i++) {
			int rank = 1;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (kg[i] < kg[j] && cm[i] < cm[j])
					rank++;
			}

			sb.append(rank + " ");
		}
		System.out.println(sb);
	}
}