import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_13706 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BigInteger N = new BigInteger(br.readLine());

		BigInteger start = BigInteger.ONE;
		BigInteger end = N;

		final BigInteger TWO = BigInteger.valueOf(2);

		// 이분탐색
		while (start.compareTo(end) <= 0) {
			// mid 계산
			BigInteger mid = start.add(end).divide(TWO);

			// mid 제곱 계산
			BigInteger midSquared = mid.multiply(mid);

			// N과 비교
			int compare = midSquared.compareTo(N);

			if (compare == 0) {
				System.out.println(mid);
				return;
			} else if (compare < 0)
				start = mid.add(BigInteger.ONE);
			else
				end = mid.subtract(BigInteger.ONE);

		}
	}
}