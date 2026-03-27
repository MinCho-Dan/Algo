import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1515 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		
		int idx = 0;
		int num = 1;
		
		while(true) {
			String cur = String.valueOf(num);

		    for (int i = 0; i < cur.length(); i++) {
		        if (idx < len && cur.charAt(i) == s.charAt(idx)) {
		            idx++;
		        }
		    }

		    if (idx == s.length()) {
		        System.out.println(num);
		        break;
		    }

		    num++;
		}
    }
}