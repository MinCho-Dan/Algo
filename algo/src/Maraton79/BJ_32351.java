package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_32351 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		double s = Double.parseDouble(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int n1 = 1;
		double playTime = 0;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n2 = Integer.parseInt(st.nextToken());
			
			playTime += ((n2 - n1) * 4.0) / (s / 60);
			
			s = Double.parseDouble(st.nextToken());
			n1 = n2;
		}
		
		playTime += ((n - n1 + 1) * 4.0) / (s / 60);

		System.out.printf("%.12f\n", playTime);
	}
}