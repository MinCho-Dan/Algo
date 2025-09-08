import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S_1216_회문2_최규직 {
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		for (int tc = 1; tc <= 10; tc++) { // 테케반복
			sb.append("#" + tc + " ");
			
			in.readLine(); // 입력 시 테케번호 버리기용
			String[] row = new String[100];
			String[] col = new String[100];
			Arrays.fill(col, "");
			
			for (int i = 0; i < 100; i++) {
				String temp = in.readLine();
				row[i] = temp;
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					col[i] += row[j].charAt(i);
				}
			}
			
			int max = -1;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 100; j <= 1; j--) {
					if (j > max && i + j < 100) {
						if (isPalindrome(row[i].substring(i, i+j))) {
							max = j;
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 100; j <= 1; j--) {
					if (j > max && i + j < 100) {
						if (isPalindrome(col[i].substring(i, i+j))) {
							max = j;
							break;
						}
					}
				}
			}
			
			
			sb.append(max + "\n");
		}
		
		System.out.println(sb);

	}


	public static boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length() - 1;
	    
	    // left 포인터가 right 포인터보다 작을 때까지
	    // -> 중간지점까지 반복
	    while (left < right) {
	        if (str.charAt(left) != str.charAt(right)) {
	            return false; 
	        }
	        left++;
	        right--;
	    }
	    
	    return true;
	}
}

