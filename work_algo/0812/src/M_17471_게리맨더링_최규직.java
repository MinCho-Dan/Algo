import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class M_17471_게리맨더링_최규직 {
	
	
	static int[] arr;
	static boolean[] visited;
	static int[] population;
	static int N;
	static ArrayList<Integer> list;
	static Integer[] num;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	
	    // 인구수 리스트 초기화
	    String[] tmp = br.readLine().split(" ");
	    population = new int[N+1]; // 0번 사용안함
	    for (int i = 1; i < N + 1; i++) { // 그래서 1번부터 N까지.
	    	population[i] = Integer.parseInt(tmp[i-1]);
	    }
	    
	    // 1번부터 N번까지 선거구 배열 만들기
	    arr = new int[N];
	    for (int i = 0; i < N; i++) {arr[i] = i+1;}
	    // 조합구하기
	    
	    
	    
	    
	    
	    
	    
	}



	private static void combination(int cnt, int start, int R) {
		
		// 기저부분
		if (cnt == R) {
			System.out.println(Arrays.toString(num));
			return;
		}
		//유도부분
		for (int i = start; i < N; i++) {
			
			//원소 뽑기
			num[cnt] = arr[i];
			
			// 다음 원소 뽑으러 가기
			combination(cnt +1, i + 1, R);
		}
		
	}
}

/*
 * 선거구가 N개.
 * N개의 선거구를 NC1 ~ NC(2/N)까지 조합을 구하고
 * 차집합을 구해서 2개의 선거구로 나눈 다음
 * 연결이 되는지 DFS로 조사.
 * DFS로 조사할 때 인구수 값 차이를 저장.
 * 그 중에 최소값을 리턴하면? 풀릴거 같은데.
 */


