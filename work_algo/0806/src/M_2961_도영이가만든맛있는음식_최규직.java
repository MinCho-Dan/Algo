import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M_2961_도영이가만든맛있는음식_최규직 {
	
	private static int N; 
	private static int[] s; // 신맛
	private static int[] ss; // 쓴맛
	private static boolean[] isSelected;
	private static ArrayList<Integer> result;  // 신맛의 곱
	private static ArrayList<Integer> result2; // 쓴맛의 합
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		isSelected = new boolean[N];
		s = new int[N];
		ss = new int[N];
		
		String[] split = new String[N];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			s[i] = Integer.parseInt(split[0]);
			ss[i] = Integer.parseInt(split[1]);
		}
		
		result = new ArrayList<Integer>();
		result2 = new ArrayList<Integer>();
		
		if (N==1) {
			if (s[0] > ss[0]) {
				System.out.println(s[0] - ss[0]);
			}
			else {System.out.println(ss[0] - s[0]);}
		}
		else {food(s,ss);}

	}


	private static void food(int[] s, int[] ss) {
		
		SubSetS(0);
		SubSetG(0);

		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.size(); j++) {
				if (answer > result.get(i) - result2.get(j) &&
						result.get(i) - result2.get(j) > 0) {
					answer = result.get(i) - result2.get(j);
				} 
				if (answer > result2.get(i) - result.get(j) &&
						result2.get(i) - result.get(j) > 0) {
					answer = result2.get(i) - result.get(j);
				} 
			}
		}
		
		System.out.println(answer);
		
	}
	
	private static void SubSetS(int cnt) {
		
		if (N == 1) {
			result.add(ss[0]);
			return;
		}
		
		//기저 부분
		if (cnt == N) { // 모든 원소를 고려한 경우
			
			int sum = 0;
			
			// 구한 부분집합의 총합
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += ss[i];
				}
			}
			result2.add(sum);
			return;
		}
		
		// 유도 부분
		// 현재원소를 부분집합에 포함
		isSelected[cnt] = true; 
		SubSetS(cnt + 1);
		
		// 현재원소를 부분집합에 미포함
		isSelected[cnt] = false;
		SubSetS(cnt + 1);
	}
	
	
	private static void SubSetG(int cnt) {
		
		if (N == 1) {
			result.add(s[0]);
			return;
		}
		
		//기저 부분
		if (cnt == N) { // 모든 원소를 고려한 경우
			
			int gop = 1;
			
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					gop *= s[i];
				}
			}
			if (gop != 0)
			{result.add(gop);}
			return;
		}	
		
		// 유도 부분
		// 현재원소를 부분집합에 포함
		isSelected[cnt] = true; 
		SubSetG(cnt + 1);
		
		// 현재원소를 부분집합에 미포함
		isSelected[cnt] = false;
		SubSetG(cnt + 1);
	}

}
