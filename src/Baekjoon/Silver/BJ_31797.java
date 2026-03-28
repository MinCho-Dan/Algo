import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_31797 {
	public static void main(String[] args) throws Exception {
		
		class Hand {
        int height;
        int person;
        	Hand(int height, int person) {
        		this.height = height;
        		this.person = person;
        	}
    	}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Hand> list = new ArrayList<>();
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.add(new Hand(a, i));
            list.add(new Hand(b, i));
		}
		
		list.sort(Comparator.comparingInt(h -> h.height));

		int idx = (n - 1) % (2 * m);
		System.out.println(list.get(idx).person);
    }
}