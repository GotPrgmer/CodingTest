import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(int i =0;i<files.length;i++){
            String[] thisSep =seperate(files[i]);
            list.add(new File(thisSep[0],thisSep[1],i));
        }
        Collections.sort(list);
        String[] answer = new String[files.length];
        for(int i=0;i<list.size();i++){
            answer[i] = files[list.get(i).tail];
        }
        return answer;
    }
    
    public String[] seperate(String word){
        //head와 num으로 나눠서 String[]에 넣어서 호출
        int numStart = -1;
        int tailStart = word.length();
        //tail이 없을수도 있음.
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            //숫자
            if(Character.isDigit(c) && numStart == -1){
                numStart = i;
            }
            else if(!Character.isDigit(c) && numStart != -1){
                tailStart = i;
                break;
            }
        }
        //tail이 없을 수도 있음.
        return new String[]{word.substring(0,numStart),word.substring(numStart,tailStart)};
    }
class File implements Comparable<File>{
    String head;
    String num;
    int tail;
    public File(String head, String num, int tail){
        this.head = head;
        this.num = num;
        this.tail = tail;
    }
    @Override
    public int compareTo(File f){
        String first = this.head.toLowerCase();
        String second = f.head.toLowerCase();
        if(first.equals(second)){
            //숫자로 정렬
            int thisNum = Integer.parseInt(this.num);
            int inputNum = Integer.parseInt(f.num);
            //숫자가 같으면 인덱스로 정렬
            if(thisNum == inputNum){
                // System.out.println("같은 수"+thisNum);
                return this.tail - f.tail;
            }
            else{
                return thisNum-inputNum;
            }
        }
        else{
            return first.compareTo(second);
        }
    }
    
    
}
}
