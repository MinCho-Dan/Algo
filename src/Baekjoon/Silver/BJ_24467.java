import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_24467 {
	static int course = 0; // 0: 바깥길, 1: 첫 지름길, 2: 가장 짧은 안쪽 길, 3: 두 번째 지름길
    static int idx = 0;    // 현재 course 안에서의 위치
    static boolean win = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> throwsList = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                throwsList.add(line);
            }
        }

        int p = 0;

        // 총 10턴 진행
        for (int turn = 0; turn < 10 && !win; turn++) {
            while (true) {
                String s = throwsList.get(p++);
                int zeros = countZero(s); // 0 = 뒷면

                if (zeros == 4) {       // 윷: 4칸 + 한 번 더
                    move(4);
                    if (win) break;
                } else if (zeros == 0) { // 모: 5칸 + 한 번 더
                    move(5);
                    if (win) break;
                } else {                // 도/개/걸
                    move(zeros);
                    break; // 현재 턴 종료
                }
            }
        }

        System.out.println(win ? "WIN" : "LOSE");
    }

    static int countZero(String s) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (s.charAt(i) == '0') cnt++;
        }
        return cnt;
    }

    static void move(int dist) {
        idx += dist;

        if (course == 0) {
            // 바깥길에서 정확히 분기점에 도착했을 때만 지름길 진입
            if (idx == 5) {
                course = 1;
                idx = 0;
            } else if (idx == 10) {
                course = 3;
                idx = 0;
            } else if (idx >= 21) {
                win = true;
            }
        } else if (course == 1) {
            // 첫 번째 지름길에서 안쪽 짧은 길로 한 번 더 분기
            if (idx == 3) {
                course = 2;
                idx = 0;
            } else if (idx >= 12) {
                win = true;
            }
        } else if (course == 2) {
            if (idx >= 4) {
                win = true;
            }
        } else if (course == 3) {
            if (idx >= 7) {
                win = true;
            }
        }
    }
}
