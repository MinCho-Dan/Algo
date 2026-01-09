import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<Integer, String> map2 = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			map1.put(name, i);
			map2.put(i, name);
		}
		
		for (int i = 0; i < M; i++) {
			String val = br.readLine();
			if (Character.isDigit(val.charAt(0))) {
				String ansStr = map2.get(Integer.parseInt(val));
				sb.append(ansStr + "\n");
			} else {
				int ansInt = map1.get(val);
				sb.append(ansInt + "\n");
			}
			
		}

		System.out.println(sb);
	}
}
