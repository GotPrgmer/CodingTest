import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1+" ";
        String[] strArray = str1.split(str2);
        System.out.println(Arrays.toString(strArray));
        return strArray.length >1 || strArray.length == 0?1:2;
    }
}