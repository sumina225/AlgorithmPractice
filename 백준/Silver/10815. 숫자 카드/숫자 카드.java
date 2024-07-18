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
		StringTokenizer st = null;
		int[] nums = new int[20000001];
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp < 0) {
				nums[10000000-temp]++;
			}
			else {
				nums[temp]++;
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] check = new int[m];
		
		for(int i = 0; i < m; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp < 0) {
				if(nums[10000000-temp] == 1) {
					check[i] = 1;
				}
				
			}
			else {
				if(nums[temp] == 1) {
					check[i] = 1;
				}
			}
		}
		for(int i = 0; i < m; i++) {
			bw.write(check[i] + " ");
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
