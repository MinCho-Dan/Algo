import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int[] arr = new int[N];
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
			maxValue = Math.max(maxValue, arr[i]);
		}

		double sum = 0;
		for (int i = 0; i < N; i++) {
			double tmp1 = (double) arr[i] / maxValue * 100;
			sum += tmp1;
		}
		double res = sum / N;
		System.out.println(res);
	}
}
