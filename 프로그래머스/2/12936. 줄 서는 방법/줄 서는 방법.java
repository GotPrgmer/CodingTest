import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        // entire/숫자수 = unit
        // k/unit = 몫 인덱스 추가
        // k%unit 으로 나머지 연산
        long entire = entire(n);
        int[] answer = new int[n];
        int num = n;
        k -= 1;
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            nums.add(i);
        }
        for(int i=0;i<n;i++){
            long unit = entire/num;
            int idx = 0;
            if(k/unit>=Integer.MIN_VALUE && k/unit<=Integer.MAX_VALUE){
                idx = (int)(k/unit);
            }
            answer[i] = nums.get(idx);
            nums.remove(idx);
            entire = entire/num;
            num -= 1;
            k = k%unit;
        }
        return answer;
    }
    public long entire(int n){
        long tmp = 1;
        for(int i=1;i<n+1;i++){
            tmp *= i;
        }
        return tmp;
    }
}