import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4880 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a==0 && b==0 && c==0)
				break;

			if (c-b == b-a)
				sb.append("AP "+ (c+(c-b)) + "\n");
			else
				sb.append("GP "+ (c*(c/b)) + "\n");
		}
		
		System.out.println(sb);
	}

}