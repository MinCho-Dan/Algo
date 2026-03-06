import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_32980 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] arr = {'O', 'P', 'C', 'V', 'S', 'G', 'F'};
        
        int n = Integer.parseInt(br.readLine());
        int[] res = new int[n];
        int[] reslen = new int[n];
        
        for (int i = 0; i < n; i++) {
			String trash = br.readLine();
			int len = trash.length();
			reslen[i] = len;
			HashSet<Character> set = new HashSet<Character>();
			// Set에 저장
			for (int j = 0; j < len; j++) 
				set.add(trash.charAt(j));
			// 재활용이 가능하다면 어느 쓰레기인지 저장.
			if (set.size() == 1) {
				for (int j = 1; j < 7; j++) {
					if (arr[j]==trash.charAt(0))
						res[i] = j;
				}
			}
		}
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] val = new int [8];
        for (int i = 1; i < 7; i++) 
			val[i] = Integer.parseInt(st.nextToken());
		val[0] = Integer.parseInt(br.readLine());
		
		long ans = 0;
		for (int i = 0; i < n; i++) {
			if (res[i] != 0)
				ans += Math.min(reslen[i] * val[0], reslen[i] * val[res[i]]);
			else
				ans += reslen[i] * val[0];
		}
        
		System.out.println(ans);
	}
}