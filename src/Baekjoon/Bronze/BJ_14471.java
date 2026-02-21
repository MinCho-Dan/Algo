import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14471 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] chk = new int[m];
        int cnt = 0;
        int idx = 0;

        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
            if (a >= n)
            	cnt++;
            else
            	chk[idx++] = n - a;
		}
        
        int res = 0;
        
        cnt = (m - 1) - cnt;
        if (cnt > 0) {
	        Arrays.sort(chk, 0, idx);
	        for (int i = 0; i < cnt; i++)
				res += chk[i];
        }
        System.out.println(res);
    }
}