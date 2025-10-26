package Maraton72;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9501 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int T = 0; T < TC; T++) {
			int cnt = 0;
			String[] tmp = in.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int D = Integer.parseInt(tmp[1]);
			
			int[] v = new int [N];
			int[] f = new int [N];
			int[] c = new int [N];
			
			for (int i = 0; i < N; i++) {
				tmp = in.readLine().split(" ");
				v[i] = Integer.parseInt(tmp[0]);
				f[i] = Integer.parseInt(tmp[1]);
				c[i] = Integer.parseInt(tmp[2]);
			}

			for (int i = 0; i < N; i++) {
				if (D <= ((float) v[i] * ((float) f[i] / (float) c[i]))) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
	}
}