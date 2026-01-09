import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long low = 1;
		long high = Long.MIN_VALUE;

		long[] arr = new long[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			if (arr[i] > high)
				high = arr[i];
		}

		long result = 0;

		while (low <= high) {
			long mid = (low + high) / 2;

			long count = 0;
			for (long len : arr)
				count += (len / mid);

			if (count >= N) {
				result = mid;
				low = mid + 1;
			} else
				high = mid - 1;
		}

		System.out.println(result);
	}
}