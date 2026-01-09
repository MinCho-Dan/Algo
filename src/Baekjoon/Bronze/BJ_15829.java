import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15829 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int M = 1234567891;
		long res = 0;
		long pow = 1;

		for (int i = 0; i < L; i++) {
			long idx = (long) (str.charAt(i) - 'a') + 1;
			long term = idx * pow % M;
			res = (res + term) % M;
			pow = (pow * 31) % M;
		}

		System.out.println(res);

	}
}