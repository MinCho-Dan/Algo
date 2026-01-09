import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10987 {
	public static void main(String[] args) throws Exception {
		
		char[] lst = {'a', 'e', 'i', 'o', 'u'};
		int cnt = 0;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = in.readLine().toCharArray();
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (tmp[i] == lst[j]) cnt++;
			}
		}
		System.out.println(cnt);
	}
}