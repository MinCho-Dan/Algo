import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_30403 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String str = br.readLine();

		boolean up = false;
		boolean down = false;

		if (str.contains("r") && str.contains("o") && str.contains("y") && str.contains("g") && str.contains("b")
				&& str.contains("i") && str.contains("v"))
			down = true;

		if (str.contains("R") && str.contains("O") && str.contains("Y") && str.contains("G") && str.contains("B")
				&& str.contains("I") && str.contains("V"))
			up = true;

		if (up && down)
			System.out.println("YeS");
		else if (up)
			System.out.println("YES");
		else if (down)
			System.out.println("yes");
		else
			System.out.println("NO!");
	}
}