package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_3052 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(in.readLine());
			int key = n % 42;
			map.put(key, key);
		}
		int res = map.size();
		System.out.println(res);
	}
}
