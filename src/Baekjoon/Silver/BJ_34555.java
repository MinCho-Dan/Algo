import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_34555 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int mid = n / 2 + 1;
        int cur = mid;
        sb.append(cur + " ");
        
        for (int i = 1; i < n; i++) {
			if (i % 2 == 1)
				cur = cur - i;
			else 
				cur = cur + i;
			sb.append(cur + " ");
		}
        
        System.out.println(sb);
    }
}