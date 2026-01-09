import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int TC = 0; TC < N; TC++) {
			Deque<Character> stack = new ArrayDeque<>();
			String str = br.readLine();

			boolean isBalanced = true;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						isBalanced = false;
						break;
					}
				}
			}
			
			if (isBalanced && stack.isEmpty()) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}

		System.out.print(sb);
	}
}