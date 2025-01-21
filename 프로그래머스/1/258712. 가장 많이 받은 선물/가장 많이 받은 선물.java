import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String,Map<String,Integer>> pairCnt = new HashMap<>();
        Map<String,List<Integer>> giftCnt = new HashMap<>();
        Map<String,Integer> result = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            giftCnt.put(friends[i],list);
        }
        for(int i=0;i<gifts.length;i++){
            String[] friendsList = gifts[i].split(" ");
            String a = friendsList[0];
            String b = friendsList[1];
            Map<String,Integer> tmp = pairCnt.getOrDefault(a,new HashMap<>());
            tmp.put(b,tmp.getOrDefault(b,0)+1);
            pairCnt.put(a,tmp);
            giftCnt.get(a).set(0,giftCnt.get(a).get(0)+1);
            giftCnt.get(b).set(1,giftCnt.get(b).get(1)+1);
        }
        System.out.println(giftCnt);
        System.out.println(pairCnt);
        for(String first:friends){
            for(String second:friends){
                int fCnt = pairCnt.getOrDefault(first,new HashMap<>()).getOrDefault(second,0);
                int sCnt = pairCnt.getOrDefault(second,new HashMap<>()).getOrDefault(first,0);
                if(!first.equals(second)){
                    if(fCnt != 0){
                        //두개가 다르면 주고받은 선물갯수 비교
                        if(fCnt > sCnt){
                            System.out.println(first+" " +second+"1");
                            result.put(first,result.getOrDefault(first,0)+1);
                        }
                        //두개가 같으면 선물지수 확인
                        else if(fCnt == sCnt){
                            List<Integer> firstList = giftCnt.get(first);
                            List<Integer> secondList = giftCnt.get(second);
                            int firstTotal = firstList.get(0) - firstList.get(1);
                            int secondTotal = secondList.get(0) - secondList.get(1);
                            if(firstTotal > secondTotal){
                            result.put(first,result.getOrDefault(first,0)+1);
                            }
                            else if(firstTotal > secondTotal){
                            result.put(second,result.getOrDefault(second,0)+1);
                            }
                        }
                    }
                    else if(fCnt == 0 && sCnt == 0){
                         List<Integer> firstList = giftCnt.get(first);
                            List<Integer> secondList = giftCnt.get(second);
                            int firstTotal = firstList.get(0) - firstList.get(1);
                            int secondTotal = secondList.get(0) - secondList.get(1);
                            if(firstTotal > secondTotal){
                            result.put(first,result.getOrDefault(first,0)+1);
                            }
                            else if(firstTotal > secondTotal){
                            result.put(second,result.getOrDefault(second,0)+1);
                            }
                    }
                }
            }
        }
        int ans = 0;
        for(String f:friends){
            if(ans < result.getOrDefault(f,0)){
                ans = result.getOrDefault(f,0);
            }
        }
        System.out.println(result);
        return ans;
    }
}