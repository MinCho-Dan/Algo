import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2744 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] tmp = br.readLine().toCharArray();

		for (int i = 0; i < tmp.length; i++) {
			if ((int) (tmp[i] - 'a') < 0) {
				tmp[i] += 32;
			} else {
				tmp[i] -= 32;
			}
		}

		for (int j = 0; j < tmp.length; j++) {
			System.out.print(tmp[j]);
		}

//		System.out.println((int) 'A');
//		System.out.println((int) 'Z');
//		System.out.println((int) 'a');
//		System.out.println((int) 'z');
//
//		System.out.println();
//		System.out.println(97 - 65);
	}
}