
import java.io.BufferedReader;
import java.io.InputStreamReader;

class S_1240_단순2진암호코드_최규직 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());

        for (int q = 1; q <= T; q++) { // TC횟수만큼 반복
        	sb.append("#" + q + " "); // "#T " 내용을 sb에 추가
        	
        	String N = in.readLine();
            int minSum = Integer.MAX_VALUE;

            for (int i = 1; i < N.length(); i++) {
            	// substring(start) = 배열[start] 부터 끝까지 반환
            	// substring(start, end) = 배열[start]부터 배열[end-1]까지 반환
                String a = N.substring(0, i); // 0부터 i-1까지
                String b = N.substring(i); // i부터 끝까지

                int part1 = Integer.parseInt(a);
                int part2 = Integer.parseInt(b);

                int sum = part1 + part2;
                if (sum < minSum) {
                    minSum = sum;
                }
            }
            sb.append(minSum).append("\n");
		}
        System.out.println(sb);
    }

}