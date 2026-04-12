import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_34155 {
	static final long MOD = 998244353L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            ans = ans * (a == i ? N - 1L : N - 2L) % MOD;
        }

        System.out.println(ans);
    }
}
