package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2869 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");

		int A = Integer.parseInt(tmp[0]);
		int B = Integer.parseInt(tmp[1]);
		int V = Integer.parseInt(tmp[2]);

		int cal = (int) Math.ceil((double) (V - A) / (A - B)) + 1;
		System.out.println(cal);

	}
}