package Maraton75;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_33571 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int cnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			switch (c) {
            // 구멍 1개인 문자들
            case 'A':
            case 'a':
            case 'b':	
            case 'D':
            case 'd':
            case 'e':
            case 'g':
            case 'O':
            case 'o':
            case 'P':
            case 'p':
            case 'Q':
            case 'q':
            case 'R':
            case '@':
                cnt++;
                break;
                
            // 구멍 2개인 문자
            case 'B':
                cnt += 2;
                break;
                
            // 나머지 (구멍 0개)는 무시
            default:
                break;
			}
		}
		
		System.out.println(cnt);
	}

}
