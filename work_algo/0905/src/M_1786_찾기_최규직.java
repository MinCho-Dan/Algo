import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_1786_찾기_최규직 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = in.readLine().toCharArray(); // 본문
		char[] P = in.readLine().toCharArray(); // 패턴
		
		int tLength = T.length;
		int pLength = P.length;
		
		// 1단계 : 부분일치 테이블 만들기
		int[] next = new int[pLength];
		
		// i : 접미사 포인터
		// j : 접두사 포인터
		for (int i = 1, j = 0; i < pLength; i++) {
			while ( j > 0 && P[i] != P[j]) {
				j = next[j - 1]; // j - 1 위치까지는 일치 했으므로 일치했던 만큼 건너뜀
			}
			
			if (P[i] == P[j]) {
				next[i] = ++j; // 일치하면 일치했던 길이를 기록
			}
			else {
				next[i] = 0;
			}
		}
		
		System.out.println("부분일치 테이블 : " + Arrays.toString(next));
		
		
		// 2단계 : 부분일치 테이블을 활용해서 본문과 패턴 비교
		int cnt = 0; // 일치한 패턴 개수
		List<Integer> list = new ArrayList<>(); // 일치한 곳의 시작 인덱스 번호들
		
		// i : 본문 포인터
		// j : 패턴 포인터
		for (int i = 0, j = 0; i < tLength; i++) {
			while ( j > 0 && T[i] != P[j]) {
				j = next[j - 1]; // j - 1 위치까지는 일치 했으므로 일치했던 만큼 건너뜀
			}
			
			if (T[i] == P[j]) {
				if (j == pLength - 1) {// 패턴과 일치하는 문자열을 찾음
					cnt++;
					list.add(i - (pLength - 1)); // 찾은 문자열의 첫 인덱스 번호를 저장
					j = next[j];
				}
				else j++;
			}
		}
//		System.out.println("일치하는 문자열의 첫 인덱스 번호들 : " + list);
		
		int a = list.size();
		System.out.println(a);
		for (int i = 0; i < a; i++) {
			System.out.print(list.get(i) + 1 + " ");
		}
		
	}

}
