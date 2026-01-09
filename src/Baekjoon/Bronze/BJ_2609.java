import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int a = Integer.parseInt(tmp[0]);
		int b = Integer.parseInt(tmp[1]);

		int gcd = GCD(a, b);
		int lcm = getLcm(a, b);

		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int GCD(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static int getLcm(int a, int b) {
		int gcd = GCD(a, b);
		if (gcd == 0)
			return 0;
		return (a * b) / gcd;
	}
}