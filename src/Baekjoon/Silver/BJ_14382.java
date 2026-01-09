import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_14382 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= t; TC++) {
			sb.append("Case #" + TC + ": ");
			int x = Integer.parseInt(br.readLine());
			HashSet<Character> set = new HashSet<Character>();
			for (int i = 1; i < 10001; i++) {
				int a = x * i;
				String str = Integer.toString(a);
				for (int j = 0; j < str.length(); j++) {
					set.add(str.charAt(j));
				}
				if (set.size() == 10) {
					sb.append(a + "\n");
					break;
				}
				if (i == 10000)
					sb.append("INSOMNIA" + "\n");
			}
		}

		System.out.println(sb);
	}
}