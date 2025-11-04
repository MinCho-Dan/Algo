package Maraton74;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BJ_3181 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		Set<String> words = new HashSet<>(Arrays.asList("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"));
		
		String[] arr = br.readLine().split(" ");
		String res = "";
		
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && words.contains(arr[i]))
				continue;
			
			res += arr[i].charAt(0);
			
		}

		System.out.println(res.toUpperCase());
	}
}
