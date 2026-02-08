import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1032 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();

        for (int i = 0; i < N - 1; i++) {
            String fileName = br.readLine();
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] == '?') continue;
                if (pattern[j] != fileName.charAt(j)) {
                    pattern[j] = '?';
                }
            }
        }
        System.out.println(pattern);
    }
}