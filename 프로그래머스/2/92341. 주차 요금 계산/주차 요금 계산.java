import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> timeMap = new HashMap<>();
        Map<String, Integer> accumulateTime = new TreeMap<>();
        for(String s:records){
            String[] sInfo = s.split(" ");
            String t = sInfo[0];
            String num = sInfo[1];
            String inOut = sInfo[2];
            // System.out.println(Arrays.toString(sInfo));
            //in이면
            if(inOut.equals("IN")){
                timeMap.put(num,toMinute(t));
            }
            //out이면
            else{
                //기존 IN 시간 가져와서
                int inTime = timeMap.get(num);
                timeMap.put(num,-1);
                //accumulateTime에 누적
                accumulateTime.put(num, accumulateTime.getOrDefault(num,0) + toMinute(t) - inTime);
            } 
        }
        //-1이 아닌 숫자가 들어있는 애들은 출차가 안됐으므로 누적을 따로 해줘야함
        for(String num:timeMap.keySet()){
            if(timeMap.get(num) != -1){
                int inTime = timeMap.get(num);
                accumulateTime.put(num, accumulateTime.getOrDefault(num,0) + 23*60+59 - inTime);

            }
        }
        List<Integer> ansTmp = new ArrayList<>();
        //시간별로 요금 계산
        for(String s:accumulateTime.keySet()){
            ansTmp.add(fee(accumulateTime.get(s),fees));
            
        }
        int[] ans = new int[ansTmp.size()];
        for(int i=0;i<ansTmp.size();i++){
            ans[i] = ansTmp.get(i);
        }
        
        return ans;
    }
    
    public int toMinute(String s){
        String[] sArray = s.split(":");
        // System.out.println(Arrays.toString(sArray));
        int h = Integer.parseInt(sArray[0]);
        int m = Integer.parseInt(sArray[1]);
        
        return h*60 + m;
    }
    
    public int fee(int time, int[] fees){
        int basicT = fees[0];
        int basicF = fees[1];
        int unitT = fees[2];
        int unitF = fees[3];
        if(time<=basicT){
            return basicF;
        }
        else{
            int extraFee = (time-basicT)%unitT == 0 ? (time-basicT)/unitT*unitF:(time-basicT)/unitT*unitF+unitF;
                extraFee += basicF;
                return extraFee;
        }
    }
}