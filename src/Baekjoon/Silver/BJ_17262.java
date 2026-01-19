import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17262 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a = 1;
		int b = 100001;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int s = Integer.parseInt(st.nextToken());
	        int e = Integer.parseInt(st.nextToken());
	        a = Math.max(a, s);
	        b = Math.min(b, e);
		}
        
		if (a - b <= 0)
			System.out.println(0);
		else
			System.out.println(a - b);
        
    }
}