import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2754 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String score = br.readLine();
		double res;

		if (score.equals("A+")) {
			res = 4.3;
		} else if (score.equals("A0")) {
			res = 4.0;
		} else if (score.equals("A-")) {
			res = 3.7;
		} else if (score.equals("B+")) {
			res = 3.3;
		} else if (score.equals("B0")) {
			res = 3.0;
		} else if (score.equals("B-")) {
			res = 2.7;
		} else if (score.equals("C+")) {
			res = 2.3;
		} else if (score.equals("C0")) {
			res = 2.0;
		} else if (score.equals("C-")) {
			res = 1.7;
		} else if (score.equals("D+")) {
			res = 1.3;
		} else if (score.equals("D0")) {
			res = 1.0;
		} else if (score.equals("D-")) {
			res = 0.7;
		} else {
			res = 0.0;
		}

		System.out.println(res);
	}
}