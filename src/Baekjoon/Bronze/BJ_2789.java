import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2789 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        String c = "CAMBRIDGE";
        boolean chk = false;
        
        for (int i = 0; i < str.length(); i++) {
        	char target = str.charAt(i);
			for (int j = 0; j < c.length(); j++) {
				if (target == c.charAt(j)) {
					chk = true;
					break;
				}
			}
			if (chk)
				chk = false;
			else
				sb.append(target);
		}
        
        System.out.println(sb);
    }
}