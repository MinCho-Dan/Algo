import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_25329 {

	static class Student implements Comparable<Student> {
		String name;
		int fee;

		public Student(String name, int fee) {
			this.name = name;
			this.fee = fee;
		}

		@Override
		public int compareTo(Student o) {
			if (this.fee != o.fee) {
				return Integer.compare(o.fee, this.fee);
			}
			return this.name.compareTo(o.name);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> timeMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String timeStr = st.nextToken();
			String name = st.nextToken();

			String[] timeParts = timeStr.split(":");
			int h = Integer.parseInt(timeParts[0]);
			int m = Integer.parseInt(timeParts[1]);
			int totalMinutes = h * 60 + m;

			timeMap.put(name, timeMap.getOrDefault(name, 0) + totalMinutes);
		}

		List<Student> students = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : timeMap.entrySet()) {
			String name = entry.getKey();
			int time = entry.getValue();

			int fee = 10;

			if (time > 100) {
				int exceed = time - 100;
				fee += ((exceed + 49) / 50) * 3;
			}

			students.add(new Student(name, fee));
		}

		Collections.sort(students);

		for (Student s : students)
			sb.append(s.name).append(" ").append(s.fee).append("\n");

		System.out.print(sb);
	}
}
