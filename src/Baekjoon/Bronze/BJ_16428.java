import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_16428 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        BigInteger q = A.divide(B);
        BigInteger r = A.remainder(B);

        if (r.compareTo(BigInteger.ZERO) < 0) {
            r = r.add(B.abs());

            if (B.compareTo(BigInteger.ZERO) > 0) {
                q = q.subtract(BigInteger.ONE);
            } else {
                q = q.add(BigInteger.ONE);
            }
        }

        System.out.println(q);
        System.out.println(r);
    }
}