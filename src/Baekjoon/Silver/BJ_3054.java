import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3054 {
	static void put(char[][] a, int r, int c, char ch) {
        if (ch == '*') a[r][c] = '*';
        else if (a[r][c] != '*') a[r][c] = '#';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int W = 4 * n + 1;
        char[][] out = new char[5][W];
        for (int i = 0; i < 5; i++) Arrays.fill(out[i], '.');

        for (int i = 0; i < n; i++) {
            char frame = ((i + 1) % 3 == 0) ? '*' : '#';
            int c = 2 + 4 * i;

            out[2][c] = s.charAt(i);

            put(out, 0, c, frame);
            put(out, 1, c - 1, frame);
            put(out, 1, c + 1, frame);
            put(out, 2, c - 2, frame);
            put(out, 2, c + 2, frame);
            put(out, 3, c - 1, frame);
            put(out, 3, c + 1, frame);
            put(out, 4, c, frame);
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 5; r++) {
            sb.append(out[r]).append('\n');
        }
        System.out.print(sb);
    }
}