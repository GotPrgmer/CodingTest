import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> mapIdx = new HashMap<>();
        Set<String> excludeInfo = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int infoIdx=0;infoIdx<terms.length;infoIdx++){
            String info = terms[infoIdx];
            String[] tmp = info.split(" ");
            int duration = Integer.valueOf(tmp[1]);
            map.put(tmp[0],duration);
            mapIdx.put(tmp[0],infoIdx);
            System.out.println(info);
        }
        System.out.println(today);
        String[] todaySep = today.split("\\.");
        System.out.println(Arrays.toString(todaySep));
        int totalCurDate = calTotalDays(today);
        for(int pIdx=0;pIdx<privacies.length;pIdx++){
            String p = privacies[pIdx];
            String[] dateAndP = p.split(" ");
            //이미 제외한 달 스킵!
            // if(excludeInfo.contains(dateAndP[1])){
            //     continue;
            // }
            //전체 일수 계산
            int plusDuration = map.getOrDefault(dateAndP[1],-1);
            if(plusDuration == -1){
                System.out.println("뭔가 이상함");
            }
            int totalPrivacy = calTotalDays(dateAndP[0]);
            totalPrivacy += plusDuration*28;
            // 전체일수에서 유효기간 빼서 양수면 제외해야함
            // 유효기간 일수를 더하면 유효기간날짜의 -1까지 유효하므로
            int remainTotalDate = totalCurDate - totalPrivacy;
            if(remainTotalDate>=0){
                ans.add(pIdx+1);
                excludeInfo.add(dateAndP[1]);
            }
                                }
        Collections.sort(ans);
        int[] ansArray = ans.stream().mapToInt(Integer::intValue).toArray();
        return ansArray;
        }
    //         return new int[3];
    // }
    
    public int calTotalDays(String date){
        String[] sepDate = date.split("\\.");
        int y = Integer.valueOf(sepDate[0]);
        int m = Integer.valueOf(sepDate[1]);
        int d = Integer.valueOf(sepDate[2]);
        return ((y-2000)*12*28) + (m-1)*28+d;
    }
}