import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> win_nums_list = Arrays.stream(win_nums).boxed().collect(Collectors.toList()); 
        Set<Integer> win_nums_set = new HashSet<>(win_nums_list);
        int zeroCnt = 0;
        int fixedCnt = 0;
        for(int num:lottos){
            if(win_nums_set.contains(num)){
                fixedCnt +=1;
            }
            if(num==0){
                zeroCnt += 1;
            }
        }
        System.out.println(zeroCnt);
        System.out.println(fixedCnt);
        int best = 0;
        int worst = 0;
        if(fixedCnt+zeroCnt <=1){
            best = 6;
        }
        else{
            best = 7-(fixedCnt+zeroCnt);
        }
        
        if(fixedCnt<=1){
            worst = 6;
        }
        else{
            worst = 7-(fixedCnt);
        }
        
        
        return new int[]{best,worst};
    }
}