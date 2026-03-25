import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_32282 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		long d2 = 1L * X * X + 1L * Y * Y;
		long c2 = 1L * c * c;
		
		long answer;

		if (d2 == 0) answer = 0;
		else if (d2 == c2) answer = 1;
		else if (d2 < c2) answer = 2;
		else answer = (long)Math.ceil(Math.sqrt(d2) / c);
        
        System.out.println(answer);
    }
}