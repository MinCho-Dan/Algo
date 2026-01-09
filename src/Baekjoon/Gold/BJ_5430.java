import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ_5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String f = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String a = br.readLine();
			String[] arr = a.substring(1, a.length() - 1).split(",");

			ArrayDeque<String> q = new ArrayDeque<String>();
			for (int i = 0; i < len; i++)
				q.add(arr[i]);

			String chk = "test";
			Boolean flag = false; // false가 정방향
			for (int i = 0; i < f.length(); i++) {
				if (f.charAt(i) == 'R') {
					flag = !flag;
				} else {

					if (flag) {
						chk = q.pollLast();
					} else {
						chk = q.poll();
					}
					if (chk == null) {
						sb.append("error\n");
						break;
					}
				}
			}
			if (chk == null)
				continue;
			else {
				sb.append("[");
				int qSize = q.size();
				if (!flag) {
					for (int i = 0; i < qSize; i++) {
						sb.append(q.poll());
						if (i != qSize - 1)
							sb.append(",");
					}
				} else {
					for (int i = 0; i < qSize; i++) {
						sb.append(q.pollLast());
						if (i != qSize - 1)
							sb.append(",");
					}
				}
				sb.append("]" + "\n");

			}
		}
		System.out.println(sb);
	}

}
