import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_1234_비밀번호_최규직 {
	
	private static int N;
	private static int[] num;
	private static int cnt;
	private static int[] result;
 
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
//        Integer.parseInt(in.readLine()); // TC 개수 버리기
         
        for (int test_case = 1; test_case <= 1; test_case++) {
            sb.append("#" + test_case + " ");
             
            String[] split = in.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            String tmp = split[1];
            num = new int[N];
            for (int i = 0; i < N; i++) {
            	num[i] = Character.getNumericValue(tmp.charAt(i));
            }

            cnt = 0;
            String res = password(num);
            
            sb.append(res);
        }
        System.out.println(sb);
    }

	private static String password(int[] num) {
		
		for (int i = 0; i < num.length-1; i++) {
			cnt = 0;
			if (num[i] != num[i+1]) {
				 += num[i];
			}
			else cnt++;

			if (cnt==0) return result;
		}
	}
 
}




/*
 * N * N의 행렬에서 상하좌우 인접한 위치가 +1값이면 이동 가능.
 * 그렇게 이동해서 최대한 많이 움직이는 경우의 시작점의 값.
 * 많이 움직이는 경우가 여럿이라면 그중에 시작점의 숫자가 가장 작은 값 출력.
 * 
 * 
 * 
 * 
 * 
*/
