import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = br.readLine();
		st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		String s = "";
		while(n != 0) {
			if(n%b >= 10) {
				s = (char)(n%b-10 + 'A') + s;
			}
			else {
				s = Integer.toString(n%b) + s;
			}
			n /= b;
		}
		System.out.println(s);
	}
}

