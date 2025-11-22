package Maraton77;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4388 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		while (!(a.equals("0") && b.equals("0"))) {
			int aLen = a.length();
			int bLen = b.length();

			int aIdx = aLen - 1;
			int bIdx = bLen - 1;

			int carry = 0; // flag 대신 carry라는 이름 사용 (올림수)
			int cnt = 0; // 올림수 발생 횟수

			// 두 숫자 중 하나라도 처리할 자릿수가 남아있다면 계속 반복
			while (aIdx >= 0 || bIdx >= 0) {
				// 인덱스가 0보다 작으면(숫자가 끝났으면) 0으로 취급
				int numA = (aIdx >= 0) ? a.charAt(aIdx) - '0' : 0;
				int numB = (bIdx >= 0) ? b.charAt(bIdx) - '0' : 0;

				if (numA + numB + carry >= 10) {
					cnt++;
					carry = 1;
				} else {
					carry = 0;
				}

				// 다음 자릿수로 이동
				aIdx--;
				bIdx--;
			}

			sb.append(cnt + "\n");

			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			b = st.nextToken();

		}

		System.out.println(sb);
	}

}