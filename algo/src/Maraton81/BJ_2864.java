package Maraton81;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2864 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] origin = br.readLine().split(" ");
		
		int sum = 0;
		// 최소 구하기
		for (int kk = 0; kk < 2; kk++) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < origin[kk].length(); i++) {
				int tmp = origin[kk].charAt(i) - '0';
				if (tmp == 6)
					tmp = 5;
				a = (a * 10) + tmp;
			}
			sum += a;
		}
		sb.append(sum + " ");
		
		sum = 0;
		// 최대구하기
		for (int kk = 0; kk < 2; kk++) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < origin[kk].length(); i++) {
				int tmp = origin[kk].charAt(i) - '0';
				if (tmp == 5)
					tmp = 6;
				a = (a * 10) + tmp;
			}
			sum += a;
		}
		sb.append(sum);
		
		System.out.println(sb);
	}
}