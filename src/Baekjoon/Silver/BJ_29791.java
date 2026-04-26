import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_29791 {

    static int countAvailableUses(int[] times, int cooldown) {

        Arrays.sort(times);
        int count = 0;
        int nextAvailableTime = 0;
        for (int time : times) {
            if (time >= nextAvailableTime) {
                count++;
                nextAvailableTime = time + cooldown;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] erda = new int[N];
        int[] origin = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            erda[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int erdaCount = countAvailableUses(erda, 100);
        int originCount = countAvailableUses(origin, 360);
        System.out.println(erdaCount + " " + originCount);

    }

}
