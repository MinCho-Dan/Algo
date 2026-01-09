import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_31403 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String a = in.readLine();
		String b = in.readLine();
		String c = in.readLine();
		
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		int cc = Integer.parseInt(c);
		
		int res1 = aa + bb - cc;
		
		String strAB = a + b;
		int ab = Integer.parseInt(strAB);
		int res2 = ab - cc;

		System.out.println(res1);
		System.out.println(res2);
	}

}