import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1049 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = 1001;
        int minsix = 1001;
        int minone = 1001;
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            if (minsix > six)
            	minsix = six;
            if (minone > one)
            	minone = one;
		}
        int a = 1001;
        if (n % 6 == 0)
        	a = (n / 6) * minsix;
        else
        	a = Math.min(((n / 6) + 1) * minsix,((n / 6) * minsix) + ((n % 6) * minone));
        int b = n * minone;
        min = Math.min(a, b);
        
        System.out.println(min);
    }
}