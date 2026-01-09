import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			Deque<Character> stack = new ArrayDeque<>();
			String str = br.readLine();

			// "."이 들어오면 빠져나가기
			if (str.equals("."))
				break;

			// 플래그 생성
			boolean isBalanced = true;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						isBalanced = false;
						break;
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						isBalanced = false;
						break;
					}
				}
			}
			
			if (isBalanced && stack.isEmpty()) {
				sb.append("yes").append('\n');
			} else {
				sb.append("no").append('\n');
			}
		}

		System.out.print(sb);
	}
}