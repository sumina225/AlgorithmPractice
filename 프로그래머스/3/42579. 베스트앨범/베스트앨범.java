import java.util.*;

class Solution {

    static class Track {
        int idx, plays;
        Track() { this.idx = -1; this.plays = -1; }
        Track(int idx, int plays) { this.idx = idx; this.plays = plays; }
    }

    private boolean better(Track a, Track b) {
        if (b.idx == -1) return true;
        if (a.plays != b.plays) return a.plays > b.plays;
        return a.idx < b.idx;
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, Track[]> top2 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            if (total.containsKey(g)) total.put(g, total.get(g) + p);
            else total.put(g, p);

            if (!top2.containsKey(g)) top2.put(g, new Track[]{ new Track(), new Track() });
            Track[] t = top2.get(g);
            Track cur = new Track(i, p);

            if (better(cur, t[0])) {
                t[1] = t[0];
                t[0] = cur;
            } else if (better(cur, t[1])) {
                t[1] = cur;
            }
        }

        List<String> order = new ArrayList<String>(total.keySet());
        Collections.sort(order, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(total.get(b), total.get(a));
            }
        });

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < order.size(); i++) {
            Track[] t = top2.get(order.get(i));
            if (t[0].idx != -1) result.add(t[0].idx);
            if (t[1].idx != -1) result.add(t[1].idx);
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
