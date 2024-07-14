import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 2;
		for(int i = 1; i <= n; i++) {
			result = result + (int)Math.pow(2, i-1);
		}
		System.out.println(result*result);
	}
}
