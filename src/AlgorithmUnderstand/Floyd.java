import java.util.Scanner;

public class Floyd {

	private static final int INF = 99999; // 계산 시 오버플로우 방지를 위해 적당히 큰값
	private static int N; // 정점의 수
	private static int[][] D; // 동적테이블
	// 첫 인덱스 : 출발 정점
	// 두번째 인덱스 : 도착정점
	// 값 : 최단거리
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				D[i][j] = sc.nextInt();
				
				// 자기 자신으로의 간선 혹은 다른 정점으로 가는 간선이 없는 경우
				if (i != j && D[i][j] == 0) {
					D[i][j] = INF; // 무한대 (적당히 큰 값)으로 채우기
				}
			}
		}
		
		// 플로이드 워샬 알고리즘
		// 3중 for문 : 경유지 -> 출발지 -> 도착지 순으로 작성
		// 경출도 : 경찰이 출동했다 도망쳐!!
		// k : 경유지, i : 출발지, j : 도착지 정점번호
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k) continue; // 출발지==경유지면 패스
				for (int j = 0; j < N; j++) {
					if (k == j || i == j) continue; // 경유지 or 출발지 == 도착지면 패스
					
					// 점화식
					// 출발지에서 도착지로 바로 가는 거리(D[i][j])보다
					// 경유지 k를 거쳐서 가는 거리(D[i][k] + D[k][j])가 더 짧은지 판별
					if (D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j]; // 더 짧으면 갱신
					}
					
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
}
