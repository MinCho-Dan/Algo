import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2992 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().trim().toCharArray();

        if (nextPermutation(arr))
            System.out.println(new String(arr));
        else
            System.out.println(0);
	}

	private static boolean nextPermutation(char[] arr) {
		int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;

        if (i < 0) return false;

        int j = n - 1;
        while (arr[i] >= arr[j])
            j--;

        swap(arr, i, j);
        reverse(arr, i + 1, n - 1);
        return true;
	}
	
	static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse(char[] arr, int left, int right) {
        while (left < right)
            swap(arr, left++, right--);
    }
}