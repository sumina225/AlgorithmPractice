import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long count = 1;
		long num = 1;
		while(true) {
			if(n == 1) {
				System.out.println(1);
				break;
			}
			if(n <= num + 6*count) {
				System.out.println(count+1);
				break;
			}
			num += 6*count;
			count++;
		}
	}
}
