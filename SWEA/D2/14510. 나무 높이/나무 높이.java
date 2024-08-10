import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] trees = new int[n];
			int max = 0;
			for(int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			int[] days = new int[2];
			for(int i = 0; i < n; i++) {
				int num = max-trees[i];
				days[0] += num/2;
				days[1] += num%2;
			}
			int hol = days[1];
			int jjak = days[0];
			while(days[0] > 0) {
				days[0]--;
				days[1] += 2;
				if(Math.abs(hol-jjak) > Math.abs(days[0]-days[1])) {
					hol = days[1];
					jjak = days[0];
				}
			}
			if(jjak >= hol) {
				System.out.println("#" + t + " " + jjak*2);
			}else {
				System.out.println("#" + t + " " + (hol*2-1));
			}
			
		}
	}
	
	
}