import java.util.Scanner;

public class S_7465_창용마을무리의개수_최규직 {
    static int[] person;

    // 경로 압축을 사용해 루트(대표 원소)를 찾는 메서드
    public static int find(int x) {
        if (person[x] == x) {
            return x;
        }
        return person[x] = find(person[x]);
    }

    // 두 집합을 합치는 메서드
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            person[rootY] = rootX;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 사람의 수
            int M = sc.nextInt(); // 관계의 수

            person = new int[N + 1];
            // 각 사람을 독립된 집합으로 초기화
            for (int i = 1; i <= N; i++) {
                person[i] = i;
            }

            // 모든 관계에 대해 union 연산 수행
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a, b);
            }

            // 무리의 개수 세기
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (person[i] == i) {
                    count++;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
        sc.close();
    }
}