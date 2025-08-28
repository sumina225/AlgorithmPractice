import java.io.*;
import java.util.*;

public class Main {

    static class Word{
        String s;
        int count;

        public Word(String s, int count){
            this.s = s;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Word> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(s.length() >= m){
                if(map.containsKey(s)){
                    list.get(map.get(s)).count++;
                }else{
                    map.put(s,list.size());
                    list.add(new Word(s,1));
                }
            }
        }
        list.sort(new Comparator<Word>() {
            @Override
            public int compare(Word a, Word b) {
                if (a.count != b.count) {
                    return b.count - a.count;
                }
                if (a.s.length() != b.s.length()) {
                    return b.s.length() - a.s.length();
                }
                return a.s.compareTo(b.s);
            }
        });
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i).s).append("\n");
        }
        System.out.println(sb.toString());
    }
}

