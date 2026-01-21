import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17247 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean a = true;
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					if (a) {
						x += i;
						y += j;
						a = false;
					} else {
						x -= i;
						y -= j;
						if (x<0)
							x *= -1;
						if (y<0)
							y *= -1;
						System.out.println(x + y);
						return;
					}
				}
			}
		}
    }
}