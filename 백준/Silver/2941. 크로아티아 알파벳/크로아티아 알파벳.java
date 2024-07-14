import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i != s.length()-1) {
				if(s.charAt(i) == 'c' && (s.charAt(i+1) == '=' || s.charAt(i+1) == '-')) {
					i++;
				}
				else if(s.charAt(i) == 'd') {
					if(s.charAt(i+1) == '-') {
						i++;
					}
					else if(s.charAt(i+1) == 'z' && i < s.length()-2) {
						if(s.charAt(i+2) == '=') {
							i += 2;
						}
					}
				}
				else if(s.charAt(i) == 'l' && s.charAt(i+1) == 'j') {
					i++;
				}
				else if(s.charAt(i) == 'n' && s.charAt(i+1) == 'j') {
					i++;
				}
				else if(s.charAt(i) == 's' && s.charAt(i+1) == '=') {
					i++;
				}
				else if(s.charAt(i) == 'z' && s.charAt(i+1) == '=') {
					i++;
				}
			}
			count++;

			
		}
		System.out.println(count);
		
	}
}

