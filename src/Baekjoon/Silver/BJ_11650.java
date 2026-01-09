import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11650 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(tmp[0]);
			map[i][1] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(map, (o1, o2) -> {
			if (o1[0] != o2[0])
				return o1[0] - o2[0];

			return o1[1] - o2[1];
		});

		for (int[] m : map)
			sb.append(m[0] + " " + m[1] + '\n');
		
		System.out.println(sb);
	}
}