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
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int result = 0;
		for(int i = 0; i < n.length(); i++) {
			if(n.charAt(i) >= 'A' && n.charAt(i) <= 'Z') {
				result += (n.charAt(i)-'A' +10)*Math.pow(b, n.length()-1-i);
			}
			else {
				result += (n.charAt(i) - '0')*Math.pow(b, n.length()-1-i);
			}
		}
		System.out.println(result);
		
	}
}

