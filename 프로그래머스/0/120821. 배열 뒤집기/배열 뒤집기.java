import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] newArray = new int[num_list.length];
        for(int i=num_list.length-1;i>-1;i--){
            newArray[num_list.length-1-i] = num_list[i];
        }
        
        return newArray;
    }
}