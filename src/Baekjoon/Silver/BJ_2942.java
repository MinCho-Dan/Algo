import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2942 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        int g = gcd(R, G);

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * (long)i <= g; i++) {
            if (g % i == 0) {
                divisors.add(i);
                if (i != g / i) {
                    divisors.add(g / i);
                }
            }
        }

        Collections.sort(divisors);

        StringBuilder sb = new StringBuilder();
        for (int d : divisors) {
            sb.append(d).append(' ')
              .append(R / d).append(' ')
              .append(G / d).append('\n');
        }

        System.out.print(sb);
    }
}