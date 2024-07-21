import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		ArrayList<Integer> intervals = new ArrayList<>();
		for(int i = 1; i < n; i++) {
			intervals.add(nums[i]-nums[i-1]);
		}
		int gcdnum = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++) {
			gcdnum = gcd(gcdnum,intervals.get(i));
			
		}
		int result = 0;
		for(int i = 1; i < n; i++) {
			int gap = nums[i] - nums[i-1];
			result += (gap/gcdnum) - 1;
		}
		
		bw.write(result + "");
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int gcd(int a, int b) {
		while(b!=0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
