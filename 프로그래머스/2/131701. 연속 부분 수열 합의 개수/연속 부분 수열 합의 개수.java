import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        List<Integer> initElements = Arrays.stream(elements).boxed().collect(Collectors.toList());
        //리스트 이어붙이기
        List<Integer> list = new ArrayList<>();
        list.addAll(initElements);
        list.addAll(initElements);
        list.addAll(initElements);
        //누적합 구하기
        for(int i =1;i<list.size();i++){
            list.set(i,list.get(i-1)+list.get(i));
        }
        //정답구하기
        for(int i =1;i<initElements.size()+1;i++){
            for(int j =i-1;j<initElements.size()+i;j++){
                if(j-i<0){
                    set.add(list.get(j));
                }
                else{
                    set.add(list.get(j)-list.get(j-i));
                }
            }
        }
        int answer = 0;
        return set.size();
    }
}