import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        int sum = 0;
        
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        while(l<r){
            int cur = people[l]+people[r];
            if(cur>limit){
                r -= 1;
                boat += 1;
            }
            else{
                boat += 1;
                l += 1;
                r -= 1;
            }
        }
        //홀수면 하나 증가
        if(l==r){
            return boat+1;
        }
        else{
            return boat;
        }
    }
}