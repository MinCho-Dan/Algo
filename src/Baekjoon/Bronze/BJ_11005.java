import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11005 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		while (n > 0) {
			int r = n % b;

			if (r < 10)
				sb.append((char) (r + '0'));
			else
				sb.append((char) (r - 10 + 'A'));

			n /= b;
		}

		System.out.println(sb.reverse());
	}
}