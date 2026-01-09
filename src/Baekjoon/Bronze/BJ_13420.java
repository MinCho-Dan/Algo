import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13420 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			boolean chk = false;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			char operator = st.nextToken().charAt(0);
			long B = Long.parseLong(st.nextToken());
			st.nextToken();
			long C = Long.parseLong(st.nextToken());

			switch (operator) {
				case '+':
					if (A + B == C) 
						chk = true;
					break;
				case '-':
					if (A - B == C)
						chk = true;
					break;
				case '*':
					if (A * B == C)
						chk = true;
					break;
				case '/':
					if (B != 0 && A / B == C)
						chk = true;
					break;
			}
			
			if (chk) sb.append("correct\n");
			else sb.append("wrong answer\n");
			
		}
		
		System.out.println(sb);
		
	}

}
