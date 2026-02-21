import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5585 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

    	int C = 1000;
    	C -= Integer.parseInt(br.readLine());
    	
    	int cnt = 0;
		while (C >= 500) {
			C -= 500;
			cnt++;
		}
		while (C >= 100) {
			C -= 100;
			cnt++;
		}
		while (C >= 50) {
			C -= 50;
			cnt++;
		}
		while (C >= 10) {
			C -= 10;
			cnt++;
		}
		while (C >= 5) {
			C -= 5;
			cnt++;
		}
		while (C >= 1) {
			C -= 1;
			cnt++;
		}
		sb.append(cnt + "\n");
			
        System.out.println(sb);
    }
}