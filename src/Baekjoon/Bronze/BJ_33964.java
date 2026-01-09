import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_33964 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int xx = 0;
		int yy = 0;

		for (int i = 0; i < x; i++)
			xx = (xx * 10) + 1;

		for (int i = 0; i < y; i++)
			yy = (yy * 10) + 1;

		int res = xx + yy;

		System.out.println(res);
	}
}