import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int current = Integer.parseInt(st.nextToken());
        int answer = current;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            current = Math.max(num, current + num);
            answer = Math.max(answer, current);
        }

        System.out.println(answer);
    }
}