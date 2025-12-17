package Maraton81;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20540 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String name = br.readLine();
		
		char[][] mbti = new char[4][2];
		mbti[0][0] = 'E';
		mbti[0][1] = 'I';
		mbti[1][0] = 'S';
		mbti[1][1] = 'N';
		mbti[2][0] = 'T';
		mbti[2][1] = 'F';
		mbti[3][0] = 'J';
		mbti[3][1] = 'P';
		
		for (int i = 0; i < 4; i++) {
			if (mbti[i][0] == name.charAt(i))
				sb.append(mbti[i][1]);
			else
				sb.append(mbti[i][0]);
		}
		
		
		System.out.println(sb);
	}
}