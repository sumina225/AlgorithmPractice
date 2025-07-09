import java.util.*;

class Solution {
    
    static class Comp{
        String s;
        int idx;
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        Comp[] list = new Comp[files.length];
        for(int i = 0; i < files.length; i++){
            list[i] = new Comp();
            list[i].s = files[i];
            list[i].idx = i;
        }
        Arrays.sort(list, new Comparator<Comp>(){
            @Override
            public int compare(Comp a, Comp b){
                int aNumIdx = 0;
                int aTailIdx = 0;
                int bNumIdx = 0;
                int bTailIdx = 0;
                for(int i = 0; i < a.s.length(); i++){
                    if(aNumIdx == 0 && (a.s.charAt(i) >= '0' && a.s.charAt(i) <= '9')){
                        aNumIdx = i;
                    }
                    if(aNumIdx != 0 && !(a.s.charAt(i) >= '0' && a.s.charAt(i) <= '9')){
                        aTailIdx = i;
                        break;
                    }
                }
                
                for(int i = 0; i < b.s.length(); i++){
                    if(bNumIdx == 0 && (b.s.charAt(i) >= '0' && b.s.charAt(i) <= '9')){
                        bNumIdx = i;
                    }
                    if(bNumIdx != 0 && !(b.s.charAt(i) >= '0' && b.s.charAt(i) <= '9')){
                        bTailIdx = i;
                        break;
                    }
                }
                
                if(aTailIdx == 0){
                    aTailIdx = a.s.length();
                }
                if(bTailIdx == 0){
                    bTailIdx = b.s.length();
                }
                
                String aHead = a.s.substring(0,aNumIdx);
                int aNum = Integer.parseInt(a.s.substring(aNumIdx,aTailIdx));
                
                String bHead = b.s.substring(0,bNumIdx);
                int bNum = Integer.parseInt(b.s.substring(bNumIdx,bTailIdx));
                aHead = aHead.toLowerCase();
                bHead = bHead.toLowerCase();
                if(!aHead.equals(bHead)){
                    return aHead.compareTo(bHead);
                }
                if(aNum != bNum){
                    return aNum - bNum;
                }
                return a.idx - b.idx;
            }
        });
        for(int i = 0; i < files.length; i++){
            files[i] = list[i].s;
        }
        return files;
    }
}