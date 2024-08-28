import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] nums;
    public static int[] people;
    public static int sum;
    public static int min = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        people = new int[n + 1];
        visited = new boolean[n + 1];
        sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            sum += people[i];
        }
        nums = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int last = Integer.parseInt(st.nextToken());
            for (int j = 0; j < last; j++) {
                nums[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        // Iterate through all possible subsets of nodes
        for (int i = 1; i < (1 << n); i++) {
            List<Integer> group1 = new ArrayList<>();
            List<Integer> group2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    group1.add(j + 1);
                } else {
                    group2.add(j + 1);
                }
            }
            
            if (group1.isEmpty() || group2.isEmpty()) continue;

            if (isConnected(group1) && isConnected(group2)) {
                int sumGroup1 = group1.stream().mapToInt(node -> people[node]).sum();
                int sumGroup2 = group2.stream().mapToInt(node -> people[node]).sum();
                min = Math.min(min, Math.abs(sumGroup1 - sumGroup2));
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }

    public static boolean isConnected(List<Integer> group) {
        boolean[] visitedInGroup = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0));
        visitedInGroup[group.get(0)] = true;
        int countVisited = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : nums[node]) {
                if (group.contains(neighbor) && !visitedInGroup[neighbor]) {
                    visitedInGroup[neighbor] = true;
                    queue.add(neighbor);
                    countVisited++;
                }
            }
        }
        return countVisited == group.size();
    }
}
