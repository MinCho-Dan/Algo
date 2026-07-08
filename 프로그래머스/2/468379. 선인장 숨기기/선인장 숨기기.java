import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = drops.length + 1;

        int[][] map = new int[m][n];

        // 비가 안 오는 칸은 INF로 채우기
        for (int i = 0; i < m; i++)
            Arrays.fill(map[i], INF);

        // 비가 오는 칸은 몇 번째 비인지 저장
        for (int i = 0; i < drops.length; i++)
            map[drops[i][0]][drops[i][1]] = i + 1;

        // position[i][j] = i행에서 j부터 w칸의 최솟값
        int[][] position = new int[m][n - w + 1];

        // 가로 w칸 최솟값 구하기
        for (int i = 0; i < m; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                // 현재 w칸 범위를 벗어난 인덱스 제거
                while (!deque.isEmpty() && deque.peekFirst() <= j - w)
                    deque.pollFirst();

                // 현재 값보다 크거나 같은 값은 최솟값 후보에서 제거
                while (!deque.isEmpty() && map[i][deque.peekLast()] >= map[i][j])
                    deque.pollLast();

                // 현재 인덱스 추가
                deque.offerLast(j);

                // w칸이 완성되면 최솟값 저장
                if (j >= w - 1)
                    position[i][j - w + 1] = map[i][deque.peekFirst()];
            }
        }

        int[] answer = {-1, -1};
        int result = -1;

        // 세로 h칸 최솟값 구하기
        for (int j = 0; j <= n - w; j++) {
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                // 현재 h칸 범위를 벗어난 인덱스 제거
                while (!deque.isEmpty() && deque.peekFirst() <= i - h)
                    deque.pollFirst();

                // 현재 값보다 크거나 같은 값은 최솟값 후보에서 제거
                while (!deque.isEmpty() && position[deque.peekLast()][j] >= position[i][j])
                    deque.pollLast();

                // 현재 인덱스 추가
                deque.offerLast(i);

                // h칸이 완성되면 h*w 사각형의 최솟값 확인
                if (i >= h - 1) {
                    int rain = position[deque.peekFirst()][j];
                    int top = i - h + 1;
                    int left = j;

                    if (
                        rain > result ||
                        (rain == result && (top < answer[0] || (top == answer[0] && left < answer[1])))
                    ) {
                        result = rain;
                        answer[0] = top;
                        answer[1] = left;
                    }
                }
            }
        }

        return answer;
    }
}