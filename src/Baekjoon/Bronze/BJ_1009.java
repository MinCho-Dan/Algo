import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1009 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int r = b % 4;
            
            if (r == 0) r = 4;
            
            int res = 1;
            for (int j = 0; j < r; j++) {
				res = (res * a) % 10;
			}

            if (res == 0) res = 10;
            System.out.println(res);
		}
        
    }
}