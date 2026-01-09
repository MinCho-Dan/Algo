import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_31775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char a = br.readLine().charAt(0);
		char b = br.readLine().charAt(0);
		char c = br.readLine().charAt(0);

		HashSet<Character> set = new HashSet<Character>();

		set.add(a);
		set.add(b);
		set.add(c);

		if (set.contains('l') && set.contains('k') && set.contains('p'))
			System.out.println("GLOBAL");
		else
			System.out.println("PONIX");
	}
}