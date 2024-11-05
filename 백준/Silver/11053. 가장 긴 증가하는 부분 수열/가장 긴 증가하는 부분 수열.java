import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int current = nums[i];
			int index = Collections.binarySearch(list, current);
			
			if(index < 0) {
				index = -(index+1);
			}
			
			if(index < list.size()) {
				list.set(index, current);
			}else {
				list.add(current);
			}
		}
		System.out.println(list.size());
	}
}