import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == -1) break;
			int sum = 0;
			ArrayList<Integer> nums = new ArrayList<>();
			for(int i = 1; i < n; i++) {
				if(n%i == 0) {
					sum += i;
					nums.add(i);
					
				}
			}
			if(sum == n) {
				System.out.print(n + " = ");
				for(int i = 0; i < nums.size(); i++) {
					if(i == nums.size()-1) {
						System.out.println(nums.get(i));
						break;
					}
					System.out.print(nums.get(i) + " + ");
				}
			}
			else {
				System.out.println(n + " is NOT perfect.");
			}
		}
	}
}
