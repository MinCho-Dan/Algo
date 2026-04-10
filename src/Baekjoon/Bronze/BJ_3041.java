import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_3041 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < 4; j++) {
                char c = tmp.charAt(j);
                if (c == '.') continue;

                int idx = c - 'A';
                int targetRow = idx / 4;
                int targetCol = idx % 4;

                answer += Math.abs(i - targetRow) + Math.abs(j - targetCol);
            }
        }

        System.out.println(answer);
        
    }
}
