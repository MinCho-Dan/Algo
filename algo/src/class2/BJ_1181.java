package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class BJ_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<String> word = new HashSet<>();

		for (int i = 0; i < N; i++)
			word.add(br.readLine());

		String[] wordArr = word.toArray(new String[0]);

		Arrays.sort(wordArr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() != s2.length()) {
					return s1.length() - s2.length();
				} else
					return s1.compareTo(s2);
			}
		});

		for (String res : wordArr)
			sb.append(res + "\n");

		System.out.println(sb);

	}
}