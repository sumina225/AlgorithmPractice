import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] nums = new int[26];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = -1;
		}
		for(int i = 0; i < s.length(); i++) {
			if(nums[s.charAt(i)-'a'] != -1) continue;
			
			nums[s.charAt(i)-'a'] = i;
		}
		for(int i : nums) {
			System.out.print(i + " ");
		}
		
	}
}
