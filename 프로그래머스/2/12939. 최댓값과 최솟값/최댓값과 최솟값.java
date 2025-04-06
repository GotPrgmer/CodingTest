class Solution {
    public String solution(String s) {
        String[] s_split = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s_split.length;i++){
            min = Math.min(min,Integer.parseInt(s_split[i]));
            max = Math.max(max,Integer.parseInt(s_split[i]));
        }

        return min+" "+max;
    }
}