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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int count = (V-B) / (A-B);
		if((V-B) % (A-B) != 0) {
			count++;
		}
		System.out.println(count);
		
		
	}
}
