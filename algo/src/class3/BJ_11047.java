package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 동전 입력
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		// 동전은 오름차순으로 들어온다.
		
		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (K == 0)
				break;
			while (arr[i] <= K) {
				K -= arr[i];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}