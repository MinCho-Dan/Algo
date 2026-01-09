import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_27889 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		switch (str) {
			case "NLCS" : 
				System.out.println("North London Collegiate School");
				break;
			case "BHA" : 
				System.out.println("Branksome Hall Asia");
				break;
			case "KIS" : 
				System.out.println("Korea International School");
				break;
			case "SJA" : 
				System.out.println("St. Johnsbury Academy");
				break;
		}
	}
}