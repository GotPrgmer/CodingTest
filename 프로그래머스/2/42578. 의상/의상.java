import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Set<String>> map = new HashMap<>();
        for (String[] clothSet:clothes){
                String key = clothSet[clothSet.length - 1];

                Set<String> newSet = Set.of(Arrays.copyOfRange(clothSet, 0, clothSet.length - 1));

                Set<String> existingSet = map.getOrDefault(key, new HashSet<>());

                // 기존 Set에 새로운 값 추가
                existingSet.addAll(newSet);
            map.put(key,existingSet);
        }
        int combClothes = 1;
        for(Set<String> clothe: map.values()){

            combClothes *= (clothe.size()+1);
        }


        return combClothes-1;
    }
}