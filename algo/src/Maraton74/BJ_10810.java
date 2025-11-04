package Maraton74;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10810 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		
		int[] arr = new int[N];
		
		for (int mm = 0; mm < M; mm++) {
			tmp = br.readLine().split(" ");
			int ii = Integer.parseInt(tmp[0]);
			int jj = Integer.parseInt(tmp[1]);
			int kk = Integer.parseInt(tmp[2]);
			
			for (int i = ii - 1; i < jj; i++) {
				arr[i] = kk;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
