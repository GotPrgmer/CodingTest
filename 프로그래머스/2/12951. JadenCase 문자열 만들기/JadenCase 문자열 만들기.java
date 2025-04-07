class Solution {
    public String solution(String s) {
        //공백 기준으로 나누기
        String[] input = s.split(" ",-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length;i++){
            if(i==input.length-1){
                sb.append(process(input[i]));
            }
            else{
                sb.append(process(input[i])+" ");
            }
            //공백이면 그대로 넣기
            //단어끼리 하나로 모으기
        }
        return sb.toString();
    
    }
    //첫머리 알파벳이면 대문자로 바꾸고 나머지 전부 소문자
    public String process(String parseString){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<parseString.length();i++){
            if(!Character.isDigit(parseString.charAt(i))){
                //두문자면 대문자로
                if(i==0){
                    sb.append(Character.toUpperCase(parseString.charAt(i)));
                }
                else{
                    sb.append(Character.toLowerCase(parseString.charAt(i)));
                }
            }
            else{
                sb.append(parseString.charAt(i));
            }
        }
        return sb.toString();
    }
               
}
