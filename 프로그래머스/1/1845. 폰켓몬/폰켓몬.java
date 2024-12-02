import java.util.*;
import java.io.*;
class Solution {
    static Set<Integer> set;
    public int solution(int[] nums) {
        int answer = 0;
        System.out.println(nums[0]);
        set = new HashSet<>();
        for(int num=0;num<nums.length;num++){
            set.add(nums[num]);
        }
        
        return set.size()<nums.length/2?set.size():nums.length/2;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s);
        
    }
}