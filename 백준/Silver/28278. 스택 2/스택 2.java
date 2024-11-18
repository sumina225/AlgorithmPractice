import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	switch(Integer.parseInt(st.nextToken())) {
        	case 1:
        		stack.add(Integer.parseInt(st.nextToken()));
        		break;
        	case 2:
        		if(!stack.isEmpty()) {
        			int num = stack.pop();
        			System.out.println(num);
        		}else {
        			System.out.println(-1);
        		}
        		break;
        	case 3:
        		System.out.println(stack.size());
        		break;
        	case 4:
        		if(!stack.isEmpty()) {
        			System.out.println(0);
        		}else {
        			System.out.println(1);
        		}
        		break;
        	case 5:
        		if(!stack.isEmpty()) {
        			int num = stack.peek();
        			System.out.println(num);
        		}else {
        			System.out.println(-1);
        		}
        		break;
        	}
        }
    }
}
