import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_35466 {
		static int N;

	    static int dist(int x, int y) {
	        int diff = Math.abs(x - y);
	        return Math.min(diff, N - diff);
	    }

	    static int[] candidates(int d) {
	        if (d == 0 || d * 2 == N) {
	            return new int[]{d};
	        }
	        return new int[]{d, N - d};
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        N = Integer.parseInt(br.readLine().trim());

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());

	        st = new StringTokenizer(br.readLine());
	        int p = Integer.parseInt(st.nextToken());
	        int q = Integer.parseInt(st.nextToken());

	        int[] dPos = candidates(a);
	        int[] pPos = candidates(c);
	        int[] vPos = candidates(p);

	        for (int D : dPos) {
	            for (int P : pPos) {
	                if (dist(D, P) != b)
	                	continue;
	                for (int V : vPos) {
	                    if (dist(D, V) != q) continue;
	                    System.out.println(dist(P, V));
	                    return;
	                }
	            }
	        }
	    }
}
