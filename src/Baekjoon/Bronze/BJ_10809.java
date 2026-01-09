import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = in.readLine();
		int[] num = new int[26];
		Arrays.fill(num, -1);
		for (int i = 0; i < str.length(); i++) {
			int n = (int) str.charAt(i) - 'a';
			if (num[n] == -1)
				num[n] = i;
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(num[i] + " ");
		}
	}
}