import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_19944 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split(" ");
		int N = Integer.parseInt(a[0]);
		int M = Integer.parseInt(a[1]);
		
		if (M == 1 || M == 2)
			System.out.println("NEWBIE!");
		else if (N >= M )
			System.out.println("OLDBIE!");
		else
			System.out.println("TLE!");
	}

}
