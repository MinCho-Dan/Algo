import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_30890 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int gcd = gcd(x, y);
        int lcm = x / gcd * y;
        
        int left = lcm / x;
        int right = lcm / y;
        
        for (int i = 1; i <= lcm; i++) {
			boolean chkL = (i % left == 0);
			boolean chkR = (i % right == 0);
			
			if (chkL && chkR) sb.append('3');
			else if (chkL) sb.append('1');
			else if (chkR) sb.append('2');
		}
        
        System.out.println(sb);
    }

	private static int gcd(int x, int y) {
		while (y != 0) {
			int tmp = x % y;
			x = y;
			y = tmp;
		}
		return x;
	}
}