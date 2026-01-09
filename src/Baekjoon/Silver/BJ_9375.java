import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_9375 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 0; TC < T; TC++) {
			HashMap<String, Integer> map = new HashMap<>();
			
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				sb.append(0 + "\n");
				continue;
			}
			
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				map.put(tmp[1], map.getOrDefault(tmp[1], 0) + 1);
			}
			
			int res = 1;
			
			for (Integer v : map.values())
				res *= v + 1;
			sb.append(res - 1 + "\n");
		}

		System.out.println(sb);
	}

}
