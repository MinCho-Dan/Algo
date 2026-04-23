import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9333 {
	 static long parseMoneyToCent(String s) {
	        String[] parts = s.split("\\.");
	        long dollar = Long.parseLong(parts[0]);
	        long cent = Long.parseLong(parts[1]);
	        return dollar * 100 + cent;
	    }

	    // 예: 1.23 -> 123
	    static long parseRate(String s) {
	        String[] parts = s.split("\\.");
	        long integer = Long.parseLong(parts[0]);
	        long decimal = Long.parseLong(parts[1]);
	        return integer * 100 + decimal;
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();

	        int T = Integer.parseInt(br.readLine().trim());

	        while (T-- > 0) {
	            StringTokenizer st = new StringTokenizer(br.readLine());

	            long rate = parseRate(st.nextToken());      // R * 100
	            long balance = parseMoneyToCent(st.nextToken()); // B in cents
	            long payment = parseMoneyToCent(st.nextToken()); // M in cents

	            boolean paid = false;

	            for (int month = 1; month <= 1200; month++) {
	                long interest = (balance * rate + 5000) / 10000; // nearest cent
	                long next = balance + interest - payment;

	                if (next <= 0) {
	                    sb.append(month).append('\n');
	                    paid = true;
	                    break;
	                }

	                // 이번 달에도 원금이 줄지 않았다면 앞으로도 못 갚음
	                if (next >= balance) {
	                    break;
	                }

	                balance = next;
	            }

	            if (!paid) {
	                sb.append("impossible").append('\n');
	            }
	        }

	        System.out.print(sb);
	    }
}
