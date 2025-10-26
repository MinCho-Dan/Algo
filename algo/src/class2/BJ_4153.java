package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]), b = Integer.parseInt(tmp[1]), c = Integer.parseInt(tmp[2]);

			if (a == 0 && b == 0 && c == 0)
				break;

			int m = Math.max(a, b);
			m = Math.max(m, c);

			if (m == a) {
				if (a * a == (b * b) + (c * c)) {
					System.out.println("right");
					continue;
				}
			} else if (m == b) {
				if (b * b == (a * a) + (c * c)) {
					System.out.println("right");
					continue;
				}
			} else if (m == c) {
				if (c * c == (a * a) + (b * b)) {
					System.out.println("right");
					continue;
				}
			}
			System.out.println("wrong");
		}
	}
}
