import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25183 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();

		for (int i = 0; i <= n - 5; i++) {
			int cnt = 0;

			for (int j = i; j < i + 4; j++) {
				if (Math.abs(str[j] - str[j + 1]) == 1)
					cnt++;
				else
					break;
			}

			if (cnt == 4) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}
}