import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int n;
	public static int m;
	public static BufferedWriter bw; 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        
        func(0);
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void func(int k) throws IOException{
    	if(k == m) {
    		for(int i = 0; i < m; i++) {
    			bw.write(arr[i] + " ");
    		}
    		bw.write("\n");
    		return;
    	}
    	for(int i = 1; i <= n; i++) {
    		arr[k] = i;
    		func(k+1);
    	}
    }
   

}