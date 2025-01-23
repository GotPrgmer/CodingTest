import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> tmp = new ArrayList<>(Arrays.asList(report));
        Set<String> report_set = new HashSet<>(tmp); //리스트만 가능 배열안됨.
        // 정지된 아이디를 set으로 관리
        Set<String> stopIds = new HashSet<>();
        // 각 유저당 신고당한 횟수를 기록
        Map<String,Integer> idCount = new HashMap<>();
        // 각 유저당 신고한 ID 리스트로 기록
        Map<String,List<String>> idToNickname = new HashMap<>();
        for(String s:report_set){
            String[] aToB = s.split(" ");
            String a = aToB[0];
            String b = aToB[1];
            List<String> tmpList = idToNickname.getOrDefault(a,new ArrayList<>());
            tmpList.add(b);
            idToNickname.put(a,tmpList);
            idCount.put(b,idCount.getOrDefault(b,0)+1);
        }
        for(String key:idCount.keySet()){
            if(idCount.getOrDefault(key,0) >=k){
                stopIds.add(key);
            }
        }
        for(int nameIdx=0;nameIdx<id_list.length;nameIdx++){
            String name = id_list[nameIdx];
            for(String toName:idToNickname.getOrDefault(name,new ArrayList<>())){
                if(stopIds.contains(toName)){
                    answer[nameIdx] += 1;
                }
            }
        }

        return answer;
    }
}