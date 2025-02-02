import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String,Integer> score = new HashMap<>();
        for(int i=0;i<choices.length;i++){
            //i에 해당하는 survey
            String thisSurvey = survey[i];
            String first = String.valueOf(thisSurvey.charAt(0));
            String second = String.valueOf(thisSurvey.charAt(1));
            System.out.println(first + " "+ second);
            //i에 해당하는 선택지(1을 뺌)
            int choice = choices[i] -1;
            
            //score를 3으로 나누고 몫이 0이거나 1일때 브랜치
            if(choice/3 == 0){
                int plusScore = 3 - choice;
                score.put(first,score.getOrDefault(first,0)+plusScore);
            }
            else if(choice != 3){
                int plusScore = choice - 3;
                score.put(second,score.getOrDefault(second,0)+plusScore);
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(score);
        //"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 순서쌍 비교
        for(String e:new String[]{"R", "F", "M", "N"}){
            //score가 같은지 아닌지 판별
            if(e.equals("R") || e.equals("T")){
                int one = score.getOrDefault("R",0);
                int two = score.getOrDefault("T",0);
                if(one>two){
                    sb.append("R");
                }
                else if(one<two){
                    sb.append("T");
                }
                else{
                    sb.append("R");
                }
            }
            else if(e.equals("F") || e.equals("C")){
                int one = score.getOrDefault("C",0);
                int two = score.getOrDefault("F",0);
                if(one>two){
                    sb.append("C");
                }
                else if(one<two){
                    sb.append("F");
                }
                else{
                    sb.append("C");
                }
            }
            else if(e.equals("M") || e.equals("J")){
                int one = score.getOrDefault("J",0);
                int two = score.getOrDefault("M",0);
                if(one>two){
                    sb.append("J");
                }
                else if(one<two){
                    sb.append("M");
                }
                else{
                    sb.append("J");
                }
            }
            else{
                int one = score.getOrDefault("A",0);
                int two = score.getOrDefault("N",0);
                if(one>two){
                    sb.append("A");
                }
                else if(one<two){
                    sb.append("N");
                }
                else{
                    sb.append("A");
                }
            }
        }

        return sb.toString();
    }
}