import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10953 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			sb.append(a + b + "\n");
		}

		System.out.println(sb);
	}
}