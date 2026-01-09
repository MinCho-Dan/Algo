import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17203 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		long[] arr = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Long.parseLong(st.nextToken());

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (b - a > 0) {
				long res = 0;
				for (int j = a; j < b; j++) {
					res += Math.abs(arr[j] - arr[j + 1]);
				}
				sb.append(res + "\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);

	}
}