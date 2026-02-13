import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_31009 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] value = new int[n];
        int jinju = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("jinju")) {
				jinju = Integer.parseInt(st.nextToken());
			} else {
				value[i] = Integer.parseInt(st.nextToken());
			}
		}
        for (int i = 0; i < n; i++) {
        	if (value[i] > jinju)
        		cnt++;
        }
        System.out.println(jinju);
        System.out.println(cnt);
    }
}