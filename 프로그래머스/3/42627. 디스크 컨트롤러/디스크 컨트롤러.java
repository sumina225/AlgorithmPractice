import java.util.*;

class Solution {
    
    static class Pos{
        int start;
        int end;
        
        public Pos(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Pos> pq = new PriorityQueue<Pos>(new Comparator<Pos>(){
            @Override
            public int compare(Pos a, Pos b){
                if(a.end == b.end){
                    return a.start - b.start;
                }
                return a.end - b.end;
            }
        });
        int time = 0;
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while(list.size() < jobs.length || !pq.isEmpty()){
            while(index < jobs.length && jobs[index][0] <= time){
                pq.add(new Pos(jobs[index][0],jobs[index][1]));
                index++;
            }
            if(pq.isEmpty()){
                time = jobs[index][0];
                continue;
            }
            Pos temp = pq.poll();
            time += temp.end;
            list.add(time-temp.start);
        }
        for(int num : list){
            answer += num;
        }
        answer /= jobs.length;
        return answer;
    }
}