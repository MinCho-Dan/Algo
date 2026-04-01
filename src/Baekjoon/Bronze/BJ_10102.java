import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10102 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cntA = 0;
		int cntB = 0;
		
		for (int i = 0; i < n; i++) {
			if ('A'==str.charAt(i))
				cntA++;
			else
				cntB++;
		}
		
		if (cntA > cntB)
			System.out.println("A");
		else if (cntA < cntB)
			System.out.println("B");
		else
			System.out.println("Tie");
	}
}