import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ_10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

		for (int i = 0; i < K; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0)
				stack.pop();
			else
				stack.push(tmp);
		}
		long res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		System.out.println(res);
	}
}