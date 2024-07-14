import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] nums = new int[26];
		for(int i = 0; i < 26; i++) {
			nums[i] = 0;
		}
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				nums[s.charAt(i)-'A']++;
			}
			else {
				nums[s.charAt(i)-'a']++;
			}
		}
		int max = 0;
		int index = -1;
		for(int i = 0; i < 26; i++) {
			if(max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		int count = 0;
		for(int i = 0; i < 26; i++) {
			if(max == nums[i]) {
				count++;
			}
		}
		if(count == 1) {
			char c = 'A';
			c += index;
			System.out.println(c);
		}
		else {
			System.out.println("?");
		}
		
	}
}

