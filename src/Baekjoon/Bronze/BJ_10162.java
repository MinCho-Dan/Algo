import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_10162 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int A = 0, B = 0, C = 0;
		
		
		while (N >=300) {
			N -= 300;
			A++;
		}
		while (N >= 60) {
			N -= 60;
			B++;
		}
		while (N >= 10) {
			N -= 10;
			C++;
		}
		
		if (N == 0)
			System.out.println(A + " " + B + " " + C);
		else
			System.out.println(-1);
	}
}