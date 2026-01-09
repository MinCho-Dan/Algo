import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_10814 {

	static class Member {
		int age;
		String name;
		int order; // 가입 순서 (입력 순서)를 저장

		public Member(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		// 문제의 요구사항에 맞게 "나이 이름" 형식으로 출력
		@Override
		public String toString() {
			return age + " " + name;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Member[] member = new Member[N];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			int age = Integer.parseInt(tmp[0]);
			String name = tmp[1];
			member[i] = new Member(age, name, i + 1);
		}
		
		Arrays.sort(member, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
		});

		for (Member m : member)
			sb.append(m.toString()).append('\n');
		
		System.out.println(sb);
	}
}