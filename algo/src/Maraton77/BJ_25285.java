package Maraton77;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_25285 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 0; TC < T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double ki = Integer.parseInt(st.nextToken());
			double mugae = Integer.parseInt(st.nextToken());
			double ki2 = ki / 100;
			double BMI = mugae / (ki2 * ki2);

			if (ki < 140.1) {
				sb.append(6 + "\n");
				continue;
			} else if (ki < 146.0) {
				sb.append(5 + "\n");
				continue;
			} else if (ki < 159.0) {
				sb.append(4 + "\n");
				continue;
			} else if (ki < 161.0) {
				if (BMI < 16.0 || BMI >= 35.0) {
					sb.append(4 + "\n");
					continue;
				}
				else {
					sb.append(3 + "\n");
					continue;
				}
			} else if (ki < 204.0) {
				if (BMI < 16.0 || BMI >= 35.0) {
					sb.append(4 + "\n");
					continue;
				} else if ((BMI >= 16.0 && BMI < 18.5) || (BMI < 35.0 && BMI >= 30.0)) {
					sb.append(3 + "\n");
					continue;
				} else if ((BMI >= 18.5 && BMI < 20) || (BMI < 30 && BMI >= 25.0)) {
					sb.append(2 + "\n");
					continue;
				} else if (BMI < 25.0 || BMI >= 20.0) {
					sb.append(1 + "\n");
					continue;
				}
			}
		}
		
		System.out.println(sb);
	}
}