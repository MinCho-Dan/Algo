import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25643 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] towers = new String[n];
        for (int i = 0; i < n; i++)
            towers[i] = br.readLine();
        
        boolean canStack = true;
        
        for (int i = 0; i < n - 1; i++) {
            String bottom = towers[i];
            String top = towers[i + 1];
            boolean isMatched = false;
            
            for (int j = 1; j <= m; j++) {
                if (bottom.substring(m - j).equals(top.substring(0, j))) {
                    isMatched = true;
                    break;
                }
                if (bottom.substring(0, j).equals(top.substring(m - j))) {
                    isMatched = true;
                    break;
                }
            }
            
            if (!isMatched) {
                canStack = false;
                break;
            }
        }
        
        System.out.println(canStack ? 1 : 0);
    }
}