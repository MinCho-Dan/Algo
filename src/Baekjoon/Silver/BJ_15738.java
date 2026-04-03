import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15738 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		br.readLine();

		int pos = K;

		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x > 0) {
				if (pos <= x)
					pos = x - pos + 1;
			} else {
				int start = N + x + 1;
				if (pos >= start)
					pos = 2 * N + x + 1 - pos;
			}
		}

		System.out.println(pos);
	}
}