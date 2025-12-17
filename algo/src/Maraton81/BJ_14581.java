package Maraton81;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14581 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String name = br.readLine();
		
		sb.append(":fan::fan::fan:\n:fan::"+name+"::fan:\n:fan::fan::fan:");
		
		System.out.println(sb);
	}
}