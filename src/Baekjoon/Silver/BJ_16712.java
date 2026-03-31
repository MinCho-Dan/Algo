import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16712 {
    static class Person implements Comparable<Person> {
        int skill;
        int idx;

        Person(int skill, int idx) {
            this.skill = skill;
            this.idx = idx;
        }

        @Override
        public int compareTo(Person other) {
            if (skill != other.skill) {
                return skill - other.skill;
            }
            return idx - other.idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] skills = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            skills[i] = Integer.parseInt(st.nextToken());
        }

        int rounds = n - m + 1;
        int[] ranks = new int[rounds];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rounds; i++) {
            ranks[i] = Integer.parseInt(st.nextToken());
        }

        List<Person> current = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            current.add(new Person(skills[i], i));
        }

        int next = m;
        for (int round = 0; round < rounds; round++) {
            List<Person> sorted = new ArrayList<>(current);
            Collections.sort(sorted);

            Person eliminated = sorted.get(ranks[round] - 1);
            current.remove(eliminated);

            if (next < n) {
                current.add(new Person(skills[next], next));
                next++;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (Person person : current) {
            answer.add(person.skill);
        }
        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(answer.get(i));
        }

        System.out.println(sb);
    }
}
