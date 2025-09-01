import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M_1074_Z_최규직 {
	
	static int N, r, c;
	static int count = 0;	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
        solve((int) Math.pow(2, N), 0, 0);
        System.out.println(count);
    }

    public static void solve(int size, int row, int col) {
        // base case
        if (size == 1) {
            return;
        }

        int newSize = size / 2;
        int area = newSize * newSize;

        // 1사분면 (왼쪽 위)
        if (r < row + newSize && c < col + newSize) {
            solve(newSize, row, col);
        }
        // 2사분면 (오른쪽 위)
        else if (r < row + newSize && c >= col + newSize) {
            count += area; // 1사분면 더해줌
            solve(newSize, row, col + newSize);
        }
        // 3사분면 (왼쪽 아래)
        else if (r >= row + newSize && c < col + newSize) {
            count += area * 2; // 1,2사분면 더해줌
            solve(newSize, row + newSize, col);
        }
        // 4사분면 (오른쪽 아래)
        else {
            count += area * 3; // 1,2,3사분면 더해줌
            solve(newSize, row + newSize, col + newSize);
        }
    }
}