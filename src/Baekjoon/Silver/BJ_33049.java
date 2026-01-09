import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_33049 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p3 = Integer.parseInt(st.nextToken());
		int p4 = Integer.parseInt(st.nextToken());
		int p0 = Integer.parseInt(st.nextToken());
		
		int total = p3 + p4 + p0;
		
		int res3 = -1;
		int res4 = -1;
		
        int minK4 = (p4 + 3) / 4; 
        int maxK4 = total / 4;

        for (int i = maxK4; i >= minK4; i--) {
            int remaining = total - (i * 4);

            if (remaining >= p3 && remaining % 3 == 0) {
                res3 = remaining / 3;
                res4 = i;
                System.out.println(res3 + " " + res4);
                return;
            }
        }

        System.out.println("-1");
	}
}