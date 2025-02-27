import java.util.*;
class Solution {
    public String solution(String s) {
        s = ". "+s+" .";
        StringBuilder sb = new StringBuilder();
        String[] sList = s.split(" ");
        if(sList.length==0){
            return s;
        }
        else{
        System.out.println(Arrays.toString(sList));
        for(int i=1;i<sList.length-1;i++){
            if(sList[i].equals("")){
                sb.append("");
            }
            else{
                sb.append(process(sList[i]));
            }
            
            if(i!=sList.length-2){
                sb.append(" ");
            }
        }
        return sb.toString();
        }
    }
    public String process(String s){
        StringBuilder sb = new StringBuilder();
        if(!Character.isDigit(s.charAt(0))){
                sb.append(String.valueOf(s.charAt(0)).toUpperCase());
            }
        else{
                sb.append(String.valueOf(s.charAt(0)).toUpperCase());

        }
        for(int i=1;i<s.length();i++){
            sb.append(String.valueOf(s.charAt(i)).toLowerCase());
        }
        return sb.toString();
    }
    
}