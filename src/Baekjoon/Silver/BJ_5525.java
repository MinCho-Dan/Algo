import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int ans = 0;
		int count = 0;

		for (int i = 1; i < m - 1; i++) {
			if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
				count++;

				if (count == n) {
					ans++;
					count--;
				}
				i++;
			} else {
				count = 0;
			}
		}

		System.out.println(ans);
	}

}
