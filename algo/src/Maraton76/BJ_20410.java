package Maraton76;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20410 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int seed = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int a = -1;
		int c = -1;

		boolean find = false;

		for (int i = 0; i < m + 1; i++) {
			if (find)
				break;
			for (int j = 0; j < m + 1; j++) {
				if ((i * seed + j) % m == x1 && (i * x1 + j) % m == x2) {
					find = true;
					a = i;
					c = j;
				}
			}
		}

		System.out.println(a + " " + c);
	}

}
