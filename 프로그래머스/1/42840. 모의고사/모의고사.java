import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        for(int idx=0;idx<answers.length;idx++){
            if (answers[idx] == first[idx%5]) score[0] += 1;
            if (answers[idx] == second[idx%8]) score[1] += 1;
            if (answers[idx] == third[idx%10]) score[2] += 1;
        }
        int maxScore = Math.max(score[0], Math.max(score[1],score[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<3;i++){
            if(maxScore == score[i]){
                list.add(i+1);
            }
        }
        
        return list;
    }
}