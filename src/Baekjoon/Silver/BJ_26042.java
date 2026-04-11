import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_26042 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int maxSize = 0;
        int answerStudent = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.offer(student);

                int currentSize = queue.size();

                if (currentSize > maxSize) {
                    maxSize = currentSize;
                    answerStudent = student;
                }
                else if (currentSize == maxSize) {
                    answerStudent = Math.min(answerStudent, student);
                }
            } else {
                queue.poll();
            }
        }

        System.out.println(maxSize + " " + answerStudent);
    }
}
