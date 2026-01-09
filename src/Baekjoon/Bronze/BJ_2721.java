import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_2721 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			int tn = 0;
			int res = 0;
			for (int i = 1; i <= N + 1; i++) {
				tn += i;
				res += (i-1) * tn;
			}
			sb.append(res + "\n");
		}
		
		System.out.println(sb);
	}
}