package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_31821 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] price = new int[N];

		for (int i = 0; i < N; i++)
			price[i] = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());
		int res = 0;

		for (int i = 0; i < M; i++)
			res += price[Integer.parseInt(br.readLine()) - 1];

		System.out.println(res);

	}
}
