import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class S_1257_K번째문자열 {
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			int k = Integer.parseInt(in.readLine());
			String s = in.readLine();
			
			// HashSet에 저장 ( 중복 자동 제거)
            HashSet<String> substr = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    substr.add(s.substring(i, j));
                }
            }
            
            // HashSet 값을 ArrayList에 저장해서 정렬하고 k번째 값 저장
            ArrayList<String> list = new ArrayList<>(substr);
            Collections.sort(list);
			sb.append(list.get(k - 1) + "\n");
		}
		System.out.println(sb);
	}
}