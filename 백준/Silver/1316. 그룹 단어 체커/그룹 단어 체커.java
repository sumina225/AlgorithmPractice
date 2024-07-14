import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			int[] nums = new int[26];
			boolean isgroup = true;
			for(int j = 0; j < 26; j++) {
				nums[j] = 0;
			}
			nums[s.charAt(0)-'a']++;
			for(int j = 1; j < s.length(); j++) {
				if(s.charAt(j) != s.charAt(j-1) && nums[s.charAt(j)-'a'] != 0) {
					isgroup = false;
					break;
				}
				nums[s.charAt(j)-'a']++;
			}
			if(isgroup) {
				result++;
			}
		}
		System.out.println(result);
		
	}
}

