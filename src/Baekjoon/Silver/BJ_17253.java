import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17253 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        if (n == 0) {
        	System.out.println("NO");
        	return;
        }
        
        while (n > 1) {
        	if (n % 3 == 2) {
        		System.out.println("NO");
        		return;
        	}
        	n /= 3;
        }
        System.out.println("YES");
    }
}