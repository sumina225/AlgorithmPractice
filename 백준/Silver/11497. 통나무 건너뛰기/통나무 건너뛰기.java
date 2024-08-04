import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
        	int n = Integer.parseInt(br.readLine());
        	List<Integer> nums = new ArrayList<Integer>();
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < n; i++) {
        		nums.add(Integer.parseInt(st.nextToken()));
        	}
        	Collections.sort(nums,Comparator.reverseOrder());
        	Deque<Integer> result = new ArrayDeque<>();
        	result.add(nums.get(0));
        	for(int i = 1; i < nums.size();i++) {
        		if(i % 2 == 1) {
        			result.addLast(nums.get(i));
        		}else {
        			result.addFirst(nums.get(i));
        		}
        	}
        	int min = 0;
        	for(int i = 0; i < nums.size(); i++) {
        		nums.set(i, result.pollFirst());
        	}
        	for(int i = 1; i < nums.size(); i++) {
        		min = Math.max(min, Math.abs(nums.get(i) - nums.get(i-1)));
        	}
        	min = Math.max(min, Math.abs(nums.get(0) - nums.get(nums.size()-1)));
        	System.out.println(min);
        }
    }
}