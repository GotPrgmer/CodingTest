import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        long entire = calculateEntire(n);
        int num = n;
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            nums.add(i);
        }
        k -= 1;
        int[] answer = new int[n];
        for(int i=0;i<answer.length;i++){
            // 해당 index에 들어갈 숫자 구해서 넣기
            long unit = entire/num;
            long numIdxLong = k/unit;
            int numIdx = 0;
            if (numIdxLong >= Integer.MIN_VALUE && numIdxLong <= Integer.MAX_VALUE) {
                numIdx = (int) numIdxLong;
            }
            answer[i] = nums.get(numIdx);
            nums.remove(numIdx);
            k = k%unit;
            entire = entire/num;
            num -= 1;
        }
        return answer;
    }
    
    public long calculateEntire(int n){
        long num = 1;
        for(int i=n;i>0;i--){
            num *= i;
        }
        return num;
    }
}