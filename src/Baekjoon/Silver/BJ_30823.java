import java.io.*;
import java.util.*;

public class BJ_30823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(k - 1));

        // 앞부분 (인덱스 0 ~ K-2) 처리
        String prefix = s.substring(0, k - 1);
        int repeatCount = n - k + 1;

        if (repeatCount % 2 == 1) {
            // 홀수면 뒤집어서 추가
            StringBuilder temp = new StringBuilder(prefix);
            sb.append(temp.reverse());
        } else {
            // 짝수면 그대로 추가
            sb.append(prefix);
        }

        System.out.println(sb.toString());
    }
}