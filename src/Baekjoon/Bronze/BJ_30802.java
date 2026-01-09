import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_30802 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int[] s = new int[6];
		for (int i = 0; i < 6; i++) {
			s[i] = Integer.parseInt(tmp[i]);
		}

		tmp = br.readLine().split(" ");
		int T = Integer.parseInt(tmp[0]);
		int P = Integer.parseInt(tmp[1]);

		int ss = 0;

		for (int i = 0; i < 6; i++) {
			if (s[i] != 0) {
				ss += (s[i] / T);
				if (s[i] % T != 0)
					ss++;
			}
		}
		System.out.println(ss);

		System.out.println((N / P) + " " + N % P);

	}
}
