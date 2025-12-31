package Maraton82;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10825 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		STD[] arr = new STD[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new STD(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i].n + "\n");
		}
		System.out.println(sb);

	}

}

class STD implements Comparable<STD> {
	String n;
	int k;
	int e;
	int m;

	STD(String n, int k, int e, int m) {
		this.n = n;
		this.k = k;
		this.m = m;
		this.e = e;
	}

	@Override
	public int compareTo(STD o) {
		if (o.k != this.k)
			return o.k - this.k;
		if (this.e != o.e)
			return this.e - o.e;
		if (o.m != this.m)
			return o.m - this.m;
		return this.n.compareTo(o.n);
	}
}