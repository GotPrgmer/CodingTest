import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        List<Filename> list = new ArrayList<>();
        //문자와 숫자로 나누기
        for(int i=0;i<files.length;i++){
            //문자열
            String s = extractString(files[i]);
            int num = extractInt(files[i],s.length());
            Filename f = new Filename(files[i],s,num);
            list.add(f);
        }
        Collections.sort(list);
        // for(Filename f:list){
        //     System.out.println(f.head +" " + f.number);
        // }
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).original;
        }
        
        return answer;
    }
    // 문자추출
    public String extractString(String file){
        StringBuilder sb = new StringBuilder();
        for(char c:file.toCharArray()){
            if(!Character.isDigit(c)){
                sb.append(c);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
    
    // 숫자추출
    public int extractInt(String file,int start_idx){
     StringBuilder sb = new StringBuilder();
        for(int i=start_idx;i<file.length();i++){
            if(Character.isDigit(file.charAt(i))){
                sb.append(file.charAt(i));
            }
            else{
                break;
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
class Filename implements Comparable<Filename>{
    String original;
    String head;
    int number;
    
    public Filename (String original, String head, int number){
        this.original = original;
        this.head = head;
        this.number = number;
    }
    
    @Override
    public int compareTo(Filename filename){
        if(!this.head.toUpperCase().equals(filename.head.toUpperCase())){
            
            return this.head.toUpperCase().compareTo(filename.head.toUpperCase());
        }
        else{
            if(this.number != filename.number){
                return this.number - filename.number;
            }
            else{
                return 0;
            }
            
        }
    }
}