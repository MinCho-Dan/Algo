package Maraton81;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_13915 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
            int n = Integer.parseInt(line.trim());

            HashSet<Integer> categories = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String flightRecord = br.readLine();
                if (flightRecord == null) break;
                categories.add(getBitmask(flightRecord));
            }

            sb.append(categories.size() + "\n");
        }
		
		System.out.println(sb);
	}

	private static Integer getBitmask(String record) {
		int mask = 0;
        for (int i = 0; i < record.length(); i++) {
            int digit = record.charAt(i) - '0';
            if (digit >= 1 && digit <= 9) {
                mask |= (1 << digit);
            }
        }
        return mask;
	}
}