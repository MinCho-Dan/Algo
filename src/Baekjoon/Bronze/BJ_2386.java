import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2386 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] tmp = br.readLine().split(" ");

		char find = tmp[0].charAt(0);
		char find2;
		
		while (find != '#') {
			if (find - 'a' < 0) {
				find2 = Character.toLowerCase(find);
			} else {
				find2 = Character.toUpperCase(find);
			}
			
			sb.append(find + " ");
			int cnt = 0;
			for (int i = 1; i < tmp.length; i++) {
				for (int j = 0; j < tmp[i].length(); j++) {
					if (find == tmp[i].charAt(j) || find2 == tmp[i].charAt(j)) {
						cnt++;
					};
				}
			}
			sb.append(cnt + "\n");
			tmp = br.readLine().split(" ");
			find = tmp[0].charAt(0);
			
		}

		System.out.println(sb);
	}
}