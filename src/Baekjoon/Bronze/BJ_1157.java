import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1157 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}
        
        int maxCount = -1;
        char result = '?';
        
        for (int i = 0; i < 26; i++) {
        	if (arr[i] > maxCount) {
        		maxCount = arr[i];
        		result = (char) (i + 'A');
        	} else if (arr[i] == maxCount) {
        		result = '?';
        	}
        }
        
        System.out.println(result);
    }
}