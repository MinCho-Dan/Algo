import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++)
			map.put(str[i], 1);

		int M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			if (map.containsKey(str[i]))
				System.out.println(1);
			else
				System.out.println(0);
		}
		
	}
}