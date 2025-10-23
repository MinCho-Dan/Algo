package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10250 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int TC = 0; TC < T; TC++) {
			String[] tmp = in.readLine().split(" ");
			int H = Integer.parseInt(tmp[0]);
			int W = Integer.parseInt(tmp[1]);
			int N = Integer.parseInt(tmp[2]);
			
			int floor = (N % H == 0) ? H : N % H;
			int num;
			if (floor == H) num = (N / H);
			else num = (N / H) + 1;

			System.out.print(floor);
			if (num < 10) System.out.print(0);
			System.out.println(num);
			
		}
	}
}