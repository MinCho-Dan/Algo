import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11665 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[6];
		for (int i = 3; i < 6; i++) {
			arr[i] = 1111;
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j] = Math.max(arr[j], Long.parseLong(st.nextToken()));
			}
			for (int j = 3; j < 6; j++) {
				arr[j] = Math.min(arr[j], Long.parseLong(st.nextToken()));
			}
		}
		long dx = arr[3] - arr[0];
		long dy = arr[4] - arr[1];
		long dz = arr[5] - arr[2];

		if (dx <= 0 || dy <= 0 || dz <= 0) {
		    System.out.println(0);
		} else {
		    System.out.println(dx * dy * dz);
		}
	}
}