import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2745_진법변환 {
	
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = in.readLine().split(" ");
		String N = temp[0];
		int B = Integer.parseInt(temp[1]);
		
		int result = 0;
		
		// B진법만큼 자리 올림을 위한 변수
		// 초기화값이 1이니까 오른쪽 첫째자리는 10진법으로 나오고 (B의 0승)
		// B를 곱해주니까 오른쪽에서 두번째 자리는 B의 1승
		// 오른쪽에서 세번째 자리는 B의 2승
		int tmp = 1; 
		
		
		for (int i = N.length() - 1; i >= 0; i--) {
			char c = N.charAt(i);
			
			if  ('A' <= c && c <= 'Z') result += (c - 'A' + 10) * tmp;
			else result += (c - '0') * tmp;
			tmp *= B; 
		}
		
		System.out.println(result);
	}
}
