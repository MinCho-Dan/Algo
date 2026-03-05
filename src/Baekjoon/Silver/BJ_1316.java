import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_1316 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		int cnt = 0;
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine();

		for (int i = 0; i < n; i++) {
			int len = arr[i].length();
			String str = arr[i];
			HashSet<Character> set = new HashSet<Character>();
			set.add(str.charAt(0));
			boolean chk = true;

			for (int j = 1; j < len; j++) {
				if (set.contains(str.charAt(j)) && str.charAt(j - 1) == str.charAt(j)) {
					continue;
				} else if (!set.contains(str.charAt(j))) {
					set.add(str.charAt(j));
				} else {
					chk = false;
					break;
				}
			}
			if (chk)
				cnt++;
		}

		System.out.println(cnt);
	}
}