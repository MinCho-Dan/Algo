import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1076 {
	static final long MOD = 998244353L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> colorValue = new HashMap<>();
        colorValue.put("black", 0);
        colorValue.put("brown", 1);
        colorValue.put("red", 2);
        colorValue.put("orange", 3);
        colorValue.put("yellow", 4);
        colorValue.put("green", 5);
        colorValue.put("blue", 6);
        colorValue.put("violet", 7);
        colorValue.put("grey", 8);
        colorValue.put("white", 9);

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        long value = colorValue.get(first) * 10L + colorValue.get(second);
        value *= (long) Math.pow(10, colorValue.get(third));

        System.out.println(value);
    }
}
