package Maraton82;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_32779 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());

		for (int Q = 0; Q < q; Q++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			long res = (long)a * m * 176 / 100000;
			
			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}
}
