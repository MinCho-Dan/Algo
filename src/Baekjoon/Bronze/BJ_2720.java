import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2720 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
        	int C = Integer.parseInt(br.readLine());
        	int cnt = 0;
			while (C >= 25) {
				C -= 25;
				cnt++;
			}
			sb.append(cnt + " ");
			cnt = 0;
			while (C >= 10) {
				C -= 10;
				cnt++;
			}
			sb.append(cnt + " ");
			cnt = 0;
			while (C >= 5) {
				C -= 5;
				cnt++;
			}
			sb.append(cnt + " ");
			cnt = 0;
			while (C >= 1) {
				C -= 1;
				cnt++;
			}
			sb.append(cnt + "\n");
		}
        
        
        System.out.println(sb);
    }
}