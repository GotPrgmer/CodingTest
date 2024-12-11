import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String,Integer> map = new HashMap<>();
        for(int idx=0;idx<phone_book.length;idx++){
            map.put(phone_book[idx],idx);
        }
        for(int numIdx=0;numIdx<phone_book.length;numIdx++){
            for(int numLength=1;numLength<phone_book[numIdx].length();numLength++){
                if(map.containsKey(phone_book[numIdx].substring(0,numLength))){
                    return false;
                }
            }
        }
        return true;
    }
}