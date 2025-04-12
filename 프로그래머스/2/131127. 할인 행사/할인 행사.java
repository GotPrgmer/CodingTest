import java.util.*;
class Solution {
    static Map<String,Integer> mapping;
    static int[] cnt;
    public int solution(String[] want, int[] number, String[] discount) {
        mapping = new HashMap<>();
        //상품과 인덱스 매핑
        for(int i=0;i<want.length;i++){
            mapping.put(want[i],i);
        }
        cnt = new int[number.length];
        //첫 슬라이딩 10개 넣기
        for(int i=0;i<10;i++){
            oper(discount[i],true);
        }
        int ans = 0;
        if(isAnswer(number)){
            ans += 1;
        }
        //for문에서 정답이 나올경우
        
        for(int i=10;i<discount.length;i++){
            oper(discount[i],true);
            oper(discount[i-10],false);
            if(isAnswer(number)){
                ans += 1;
            }
        }

        //for문에서 정답이 나오지 않을 경우
        return ans;

    }
    
    public void oper(String item,boolean isAdd){
        //item에 맞는 인덱스 가져오기
        int itmIdx = mapping.getOrDefault(item,-1);
        if(itmIdx == -1){
            return;
        }
        if(isAdd){
            cnt[itmIdx] += 1;
        }
        else{
            cnt[itmIdx] -= 1;
        }
        return;
    }
    public boolean isAnswer(int[] number){
        for(int i=0;i<number.length;i++){
            if(number[i] != cnt[i]){
                return false;
            }
        }
        return true;
    }
}