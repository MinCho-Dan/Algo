import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2846 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = -1;
		int mid = -1;
		int max = -1;
		for (int i = 0; i < n; i++) {
			int current = Integer.parseInt(st.nextToken());
			if (mid < current) {
				if (start == -1)
					start = current;
				mid = current;
			} else {
				max = Math.max(max, mid - start);
				start = current;
				mid = current;
			}
			if (i == n-1) {
				max = Math.max(max, mid - start);
			}
		}

		System.out.println(max);
	}
}