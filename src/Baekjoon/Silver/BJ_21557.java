import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21557 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = n-2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n - 1; i++) 
        	st.nextToken();
        int end = Integer.parseInt(st.nextToken());
        
        while (cnt > 0) {
	        if (cnt > 1 && start < end) {
	        	cnt--;
	        	end--;
	        } else if (cnt > 1 && start >= end) {
	        	cnt--;
	        	start--;
	        } else if (cnt == 1) {
	        	start--;
	        	end--;
	        	cnt--;
	        }
        }
        System.out.println(Math.max(start, end));
    }
}