import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17362 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = n % 8;
        
        if (mod == 1) {
            System.out.println(1);
        } else if (mod == 2 || mod == 0) {
            System.out.println(2);
        } else if (mod == 3 || mod == 7) {
            System.out.println(3);
        } else if (mod == 4 || mod == 6) {
            System.out.println(4);
        } else { 
            System.out.println(5);
        }
    }
}