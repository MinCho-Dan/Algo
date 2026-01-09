import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3845 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());

            if (w == 0.0 && nx == 0 && ny == 0 ) break;

            double[] xPos = readPositions(br, nx);
            double[] yPos = readPositions(br, ny);

            if (isCovered(xPos, w, 75.0) && isCovered(yPos, w, 100.0)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    private static double[] readPositions(BufferedReader br, int n) throws IOException {
        double[] pos = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pos[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(pos);
        return pos;
    }

    private static boolean isCovered(double[] pos, double w, double target) {
        double halfW = w / 2.0;
        double currentEnd = 0.0;

        for (double p : pos) {
            // 현재까지 커버된 지점보다 다음 구간의 시작점이 멀면 빈틈 발생
            if (p - halfW > currentEnd) return false;
            
            // 커버 범위 갱신
            currentEnd = p + halfW;
        }

        // 마지막 커버 지점이 목표 길이(target)에 도달했는지 확인
        return currentEnd >= target;
    }
}
