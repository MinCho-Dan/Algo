package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_28702 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nextNum = 0;
		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			if (str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz"))
				continue;
			else {
				int gg = Integer.parseInt(str);
				nextNum = gg + 3 - i;
			}
		}
		if (nextNum % 3 == 0 && nextNum % 5 == 0)
			System.out.println("FizzBuzz");
		else if (nextNum % 3 == 0)
			System.out.println("Fizz");
		else if (nextNum % 5 == 0)
			System.out.println("Buzz");
		else
			System.out.println(nextNum);
	}
}