import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25165 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Ac = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Sr = Integer.parseInt(st.nextToken());
        int Sc = Integer.parseInt(st.nextToken());

        int finalDir = D;

        // 1행에서 N행까지 내려가며 N-1번 방향 전환
        if ((N - 1) % 2 == 1) {
            finalDir = 1 - finalDir;
        }

        if (Sr == N && finalDir == 0) {
            System.out.println("YES!");
        } else {
            System.out.println("NO...");
        }
    }
}