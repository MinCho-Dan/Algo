import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_18221 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[] kyu = new int[2];
		int[] pro = new int[2];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(str[j]);
				arr[i][j] = tmp;
				if (tmp == 2) {
					kyu[0] = i;
					kyu[1] = j;
				}
				if (tmp == 5) {
					pro[0] = i;
					pro[1] = j;
				}
			}
		}

		int diffx = 0;
		if (kyu[0] >= pro[0])
			diffx = (kyu[0] - pro[0]) * (kyu[0] - pro[0]);
		else
			diffx = (pro[0] - kyu[0]) * (pro[0] - kyu[0]);

		int diffy = 0;
		if (kyu[1] >= pro[1])
			diffy = (kyu[1] - pro[1]) * (kyu[1] - pro[1]);
		else
			diffy = (pro[1] - kyu[1]) * (pro[1] - kyu[1]);

		if (Math.sqrt(diffx + diffy) < 5) {
			System.out.println(0);
			return;
		}

		int minx = Math.min(kyu[0], pro[0]);
		int maxx = Math.max(kyu[0], pro[0]);
		int miny = Math.min(kyu[1], pro[1]);
		int maxy = Math.max(kyu[1], pro[1]);
		int cnt = 0;
		for (int i = minx; i <= maxx; i++) {
			for (int j = miny; j <= maxy; j++) {
				if (arr[i][j] == 1)
					cnt++;
			}
		}

		if (cnt >= 3)
			System.out.println(1);
		else
			System.out.println(0);
	}
}