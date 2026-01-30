import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_14720 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int flag = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	if (flag == Integer.parseInt(st.nextToken())) {
        		cnt++;
        		flag++;
        		if (flag > 2)
        			flag = 0;
        	}
		}
        
        System.out.println(cnt);
    }
}