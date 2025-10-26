package Maraton73;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_32154 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()) - 1;
		String[][] board = { { "11", "A B C D E F G H J L M" }, { "9", "A C E F G H I L M" },
				{ "9", "A C E F G H I L M" }, { "9", "A B C E F G H L M" }, { "8", "A C E F G H L M" },
				{ "8", "A C E F G H L M" }, { "8", "A C E F G H L M" }, { "8", "A C E F G H L M" },
				{ "8", "A C E F G H L M" }, { "8", "A B C F G H L M" } };
		System.out.println(board[N][0]);
		System.out.println(board[N][1]);
	}
}
