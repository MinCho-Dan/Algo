import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_31994 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = 0;
		String res = "not init";
		for (int i = 0; i < 7; i++) {
			String[] tmp = br.readLine().split(" ");
			int peopleCnt = Integer.parseInt(tmp[1]);
			if (num < peopleCnt) {
				num = peopleCnt;
				res = tmp[0];
			}
		}

		System.out.println(res);
	}
}
