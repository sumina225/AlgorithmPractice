import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		
		for(int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words,new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length()-s2.length();
				}
			}
		});
		
		for(int i = 0; i < n; i++) {
			if(i > 0) {
				if(words[i].equals(words[i-1])) {
					continue;
				}
			}
			bw.write(words[i] + "\n");
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
