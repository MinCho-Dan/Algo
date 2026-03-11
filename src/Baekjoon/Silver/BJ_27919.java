import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_27919 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int UC = 0;
        int DP = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'U' || c == 'C') UC++;
            else if (c == 'D' || c == 'P') DP++;
        }

        StringBuilder sb = new StringBuilder();

        if (UC > (DP + 1) / 2) sb.append("U");
        if (DP > 0) sb.append("DP");

        if (sb.length() == 0) System.out.println("C");
        else System.out.println(sb);
    }
}