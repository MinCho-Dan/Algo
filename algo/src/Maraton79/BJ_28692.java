package Maraton79;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_28692 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long sx = 0;
		long sxx = 0;
		long sy = 0;
		long sxy = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			
			sx += x;
			sxx += x * x;
			sy += y;
			sxy += x * y;
		}
		
		if (n * sxx == sx * sx) {
			System.out.println("EZPZ");
			return;
		}
		
		double a = (double)((n * sxy) - (sx * sy)) / ((n * sxx) - (sx * sx));
		double b = (double)(sy - (a * sx)) / n;
		
		System.out.println(a + " " + b);

	}
}