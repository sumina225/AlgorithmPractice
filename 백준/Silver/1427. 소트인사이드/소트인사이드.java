import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		int[] nums = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			nums[i] = s.charAt(i)-'0';
		}
		Arrays.sort(nums);
		for(int i = s.length()-1; i >= 0; i--) {
			bw.write(nums[i] + "");
		}
		
		
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
