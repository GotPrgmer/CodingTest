class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min,Integer.valueOf(nums[i]));
            max = Math.max(max,Integer.valueOf(nums[i]));
        }
        return  String.valueOf(min) +" " +String.valueOf(max);
    }
}