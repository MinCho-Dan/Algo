import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16504 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = 0;

        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) 
				res += Integer.parseInt(st.nextToken());
		}
        
        System.out.println(res);
    }
}