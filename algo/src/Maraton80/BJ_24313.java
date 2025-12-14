package Maraton80;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_24313 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a0 = Integer.parseInt(st.nextToken());
		int a1 = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		if ((a0 * n) + a1 <= c * n && a0 <= c)
			System.out.println(1);
		else
			System.out.println(0);
	}

}