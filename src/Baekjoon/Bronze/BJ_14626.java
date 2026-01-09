import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14626 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		long value = 0;
		int chk = 1;
		int idx = -1;
		
		for (int i = 0; i < 13; i++) {
			// '*' 처리하고 계수 구하기.
			if (str.charAt(i) == '*') {
				if (i % 2 == 1)
					chk = 3;
				idx = i;
				continue;
			}
			int tmp = (int) str.charAt(i) - '0';
			if (i % 2 == 0)
				value += (long) tmp;
			else
				value += (long) 3 * tmp;
		}

		for (int i = 0; i <= 9; i++) {
			long finalSum = value + (long) i * chk;
			if (finalSum % 10 == 0) {
				System.out.println(i);
				return;
			}
		}

	}
}