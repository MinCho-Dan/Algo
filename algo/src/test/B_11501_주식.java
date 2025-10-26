package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 날의 수
            int[] prices = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }

            long maxProfit = 0;
            int maxPrice = 0;

            // 배열을 뒤에서부터 탐색
            for (int j = N - 1; j >= 0; j--) {
                if (prices[j] > maxPrice) {
                    // 현재 주가가 최고가보다 높으면 최고가 갱신
                    maxPrice = prices[j];
                } else {
                    // 현재 주가가 최고가보다 낮으면 이익 계산
                    maxProfit += (long) maxPrice - prices[j];
                }
            }
            System.out.println(maxProfit);
        }
    }
}