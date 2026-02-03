import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_33690 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int cnt = 0;
        
        if (n >= 0) cnt++;
        
        for (int d = 1; d <= 9; d++) {
        	long current = d;
        	
        	while (current <= n) {
        		cnt++;
        		if (Long.MAX_VALUE / 10 < current) break;
        		current = current * 10 + d;
        	}
        }
        
        System.out.println(cnt);
    }
}