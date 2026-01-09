import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2108 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] bin = new int[8001];
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a; // 배열
			sum += a; // 평균 위한 합계
			bin[a + 4000]++; // 최빈값 위한 배열
		}

		Arrays.sort(arr); // 배열 정렬

		// 평균
		sb.append(Math.round(sum / N) + "\n");

		// 중앙값
		sb.append(arr[N / 2]).append("\n");

		// 최빈값 구하기
		int maxbin = 0;
		int binchk = 0;
		boolean first = false;

		for (int i = 0; i < 8001; i++) {
			if (bin[i] > maxbin) {
				maxbin = bin[i];
				binchk = i - 4000;
				first = true;
			} else if (bin[i] == maxbin && first) {
				binchk = i - 4000;
				first = false;
			}
		}
		sb.append(binchk + "\n");

		// 범위 (정렬된거 맨끝 - 맨 처음)
		sb.append(arr[N - 1] - arr[0] + "\n");

		System.out.print(sb);
	}
}
