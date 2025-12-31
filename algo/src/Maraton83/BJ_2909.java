package Maraton83;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2909 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int a = 1;
        for (int i = 0; i < K; i++) {
            a *= 10;
        }
        
        long res = (long)((C + (a / 2)) / a) * a;
        
        System.out.println(res);
	}

}