import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20310 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int zero = 0, one = 0;
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		for (char c : arr) {
			if (c == '0') zero++;
			else one++;
		}
		
		zero /= 2;
		one /= 2;
		
		for (int i = 0; i < arr.length; i++) {
            if (one == 0) break;
            if (arr[i] == '1') {
                arr[i] = 'X';
                one--;
            }
        }
		
		for (int i = arr.length - 1; i >= 0; i--) {
            if (zero == 0) break;
            if (arr[i] == '0') {
                arr[i] = 'X';
                zero--;
            }
        }
		
		for (char c : arr) {
            if (c != 'X') sb.append(c);
        }

		System.out.println(sb);
	}
}