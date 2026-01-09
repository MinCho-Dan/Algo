import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_26068 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("-");
			if (Integer.parseInt(tmp[1]) <= 90)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
