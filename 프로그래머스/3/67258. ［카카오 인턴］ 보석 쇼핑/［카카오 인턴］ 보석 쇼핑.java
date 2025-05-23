import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        //전체 보석 종류 개수 구하기
        int left = 0;
        int ans_left = 0;
        int ans_right = 0;
        int distance = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>();
        Set<String> kind_cnt = new HashSet<>();
        for(int i=0;i<gems.length;i++){
            kind_cnt.add(gems[i]);
        }
        //투포인터로 right를 가면서 보석갯수 맞춰주면서
        //left를 while문으로 제거하면서 거리가 줄어들면 정답 갱신
        for(int right=0;right<gems.length;right++){
            //보석 추가
            map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            //보석 제거
            while(map.get(gems[left])>1){
                map.put(gems[left],map.get(gems[left])-1);
                left ++;
            }
            if(map.size()== kind_cnt.size()&&right-left<distance){
                ans_left =left+1;
                ans_right = right+1;
                distance = right-left;
            }
        }
        return new int[]{ans_left,ans_right};
    }
}