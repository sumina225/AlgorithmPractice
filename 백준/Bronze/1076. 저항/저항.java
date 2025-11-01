import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("black", 0);
        valueMap.put("brown", 1);
        valueMap.put("red", 2);
        valueMap.put("orange", 3);
        valueMap.put("yellow", 4);
        valueMap.put("green", 5);
        valueMap.put("blue", 6);
        valueMap.put("violet", 7);
        valueMap.put("grey", 8);
        valueMap.put("white", 9);

        long[] multiplier = {
            1L, 10L, 100L, 1_000L, 10_000L, 100_000L,
            1_000_000L, 10_000_000L, 100_000_000L, 1_000_000_000L
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        int first = valueMap.get(color1);
        int second = valueMap.get(color2);
        int third = valueMap.get(color3);

        long result = (first * 10L + second) * multiplier[third];

        System.out.println(result);
    }
}
