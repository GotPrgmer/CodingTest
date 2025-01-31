import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String oneStr = one(new_id);
        String twoStr = two(oneStr);
        String threeStr = three(twoStr);
        String fourStr = four(threeStr);
        String fiveStr = five(fourStr);
        String sixStr = six(fiveStr);
        String sevenStr = seven(sixStr);
        
        return sevenStr;
    }
    
    //1단계
    private String one(String new_id){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<new_id.length();i++){
            if(Character.isUpperCase(new_id.charAt(i))){
                sb.append(Character.toLowerCase(new_id.charAt(i)));
            }
            else{
                sb.append(new_id.charAt(i));
            }
        }
    
   return sb.toString();
   }
    
    //2단계
    private String two(String new_id){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<new_id.length();i++){
            if(Character.isLowerCase(new_id.charAt(i)) || Character.isDigit(new_id.charAt(i)) || new_id.charAt(i)=='-' || new_id.charAt(i)=='_' || new_id.charAt(i)=='.'){
                sb.append(new_id.charAt(i));
            }

        }

           return sb.toString();
    }
    
    //3단계
    private String three(String new_id){
            while(new_id.contains("..")){
                new_id = new_id.replace("..",".");
            }
           return new_id;
    }
    
    //4단계
    private String four(String new_id){
        if(new_id.length()>0){
            if(new_id.charAt(0)=='.'){
            new_id=new_id.substring(1,new_id.length());
            }
           
        }
        
        if(new_id.length()>0){
            if(new_id.charAt(new_id.length()-1)=='.'){
                new_id=new_id.substring(0,new_id.length()-1);
            }
           
        }
         
        
        System.out.println(new_id);
        return new_id;
    }
    
    //5단계
    private String five(String new_id){
        if(new_id.length()==0){
            return "a";
        }
        return new_id;
        
    }
    
    //6단계
    private String six(String new_id){
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.'){
                new_id=new_id.substring(0,new_id.length()-1);
            }
            return new_id;
        }
        return new_id;
    }
    
    //7단계
    private String seven(String new_id){
        if(1<=new_id.length() && new_id.length()<=2){
            new_id +=String.valueOf(new_id.charAt(new_id.length() - 1)).repeat(3 - new_id.length());
        }
        return new_id;
    }
}