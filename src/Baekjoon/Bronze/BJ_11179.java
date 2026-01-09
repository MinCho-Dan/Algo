import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11179 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		while (n > 1) {
			sb.append(n % 2);
			n /= 2;
		}
		sb.append(n);
		
		String num = sb.toString();
		int len = num.length();
		int tmp = 1;
		int res = 0;
		for (int i = len-1; i >= 0; i--) {
			res += (num.charAt(i) - '0') * tmp;
			tmp *= 2;
		}
		
		System.out.println(res);
	}
}