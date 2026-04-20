import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_27922 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ab = new int[N];
        int[] ac = new int[N];
        int[] bc = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ab[i] = a + b;
            ac[i] = a + c;
            bc[i] = b + c;
        }

        Arrays.sort(ab);
        Arrays.sort(ac);
        Arrays.sort(bc);

        long ans = 0;
        ans = Math.max(ans, sumTopK(ab, K));
        ans = Math.max(ans, sumTopK(ac, K));
        ans = Math.max(ans, sumTopK(bc, K));

        System.out.println(ans);
    }

    static long sumTopK(int[] arr, int k) {
        long sum = 0;
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            sum += arr[i];
        }
        return sum;
    }
}