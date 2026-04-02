
import java.io.*;
import java.util.*;

public class BJ_3060 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long sum = 0;
            for (int i = 0; i < 6; i++)
                sum += Long.parseLong(st.nextToken());

            int day = 1;
            
            while (sum <= n) {
                sum *= 4;
                day++;
            }
            System.out.println(day);

        }
    }
}