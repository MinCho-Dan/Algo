import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_35493 {
	static final long MOD = 998244353L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		if (sum % 2 == 0) {
			System.out.println("YES");
			return;
		}
		
        if (n == 1) {
            System.out.println("NO");
            return;
        }
		
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                System.out.println("YES");
                return;
            }
        }
		System.out.println("NO");
    }
}
