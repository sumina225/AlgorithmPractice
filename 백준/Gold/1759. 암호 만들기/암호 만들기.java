import java.io.*;
import java.util.*;

public class Main {
	static int l;
	static int c;
	static char[] letters;
	static StringBuilder sb;
	static boolean[] visited;
	static List<String> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		letters = new char[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		visited = new boolean[c];
		result = new ArrayList<>();
		
		
		func(0,0,0,"");
		Collections.sort(result);
		
		for(int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void func(int depth, int vowel/*모음*/, int consonant/*자음*/, String s) {
		if(depth == l) {
			if(vowel >= 1 && consonant >= 2) {
				result.add(s);
			}
			return;
		}
		
		for(int i = 0; i < c; i++) {
			if(!visited[i] && (depth == 0 || letters[i] > s.charAt(s.length()-1))) {
				visited[i] = true;
				if(letters[i] == 'a' || letters[i] == 'e' || letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u') {
					func(depth+1,vowel+1,consonant, s+Character.toString(letters[i]));
				}else {
					func(depth+1,vowel,consonant+1, s+Character.toString(letters[i]));
				}
				visited[i] = false;
				
			}
		}
		
	}
}
