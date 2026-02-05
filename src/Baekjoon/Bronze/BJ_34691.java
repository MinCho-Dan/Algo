import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_34691 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		while (true) {
			char a = str.charAt(0);
			if (a == 'a')
				sb.append("Panthera tigris\n");
			else if (a == 't')
				sb.append("Pinus densiflora\n");
			else if (a == 'f')
				sb.append("Forsythia koreana\n");
			else if (a == 'e')
				break;
			str = br.readLine();
		}

		System.out.println(sb);
	}
}