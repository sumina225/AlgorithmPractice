import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = new String[5];
		int maxlen = 0;
		for(int i = 0; i < 5; i++) {
			s[i] = br.readLine();
			if(maxlen < s[i].length())
				maxlen = s[i].length();
		}
		for(int i = 0; i < maxlen; i++) {
			for(int j = 0; j < 5; j++) {
				if(s[j].length() > i) {
					System.out.print(s[j].charAt(i));
				}
			}
		}
		
		
	}
}

