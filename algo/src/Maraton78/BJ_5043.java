package Maraton78;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5043 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		long capa = (1L << (b + 1)) - 1;
		
		if (n <= capa)
			System.out.println("yes");
		else
			System.out.println("no");
	}
}