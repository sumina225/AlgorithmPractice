import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 0; t < test_case; t++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for(int i = 0; i < s.length(); i++) {
				for(int j = 0; j < r; j++) {
					System.out.print(s.charAt(i));
				}
			}
			System.out.println();
		}
	}
}
