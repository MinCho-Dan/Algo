import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1075 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        
        int tmp = (n / 100) * 100;
        
        for (int i = 0; i < 100; i++) {
			if ((tmp + i) % f == 0) {
				if (i< 10)
					System.out.println("0" + i);
				else
					System.out.println(i);
				break;
			}
		}
    }
}