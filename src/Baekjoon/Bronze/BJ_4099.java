import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4099 {
	static final long MOD = 998244353L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = br.readLine().length();
		int b = br.readLine().length();

        System.out.println(a>=b?"go":"no");
    }
}
