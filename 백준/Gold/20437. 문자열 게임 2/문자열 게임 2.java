import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for (char c : map.keySet()) {
                List<Integer> list = map.get(c);
                if (list.size() < k) continue;

                for (int i = 0; i <= list.size() - k; i++) {
                    int start = list.get(i);
                    int end = list.get(i + k - 1);
                    int len = end - start + 1;
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                System.out.println("-1");
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}
