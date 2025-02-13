import java.util.*;
class Solution {
    static int lastClock = 23*60+59;
    public int[] solution(int[] fees, String[] records) {
        //입차 및 출차 정보 map
        Map<String,Integer> inAndOut = new HashMap<>();
        //분 합계
        Map<String, Integer> minuteTotal = new HashMap<>();
        
        //records에서 하나씩 빼면서 입차때는 맵에 기록하고
        //출차때는 입차에서의 기록에서 빼서 분을 분 합계에 기록하고
        // 입출차 정보에서 해당 번호를 지운다.
        for(int i=0;i<records.length;i++){
            String[] input = records[i].split(" ");
            String time = input[0];
            String num = input[1];
            String parkOrNot = input[2];
            // System.out.println(time+" "+num+" "+parkOrNot);
            
            int hourToMin = Integer.parseInt(time.substring(0,2))*60;
            int minute = Integer.parseInt(time.substring(3,5));
            int totalMin = hourToMin + minute;
            // System.out.println(totalMin);
            
            //입차 일때
            if(parkOrNot.equals("IN")){
                inAndOut.put(num,totalMin);
            }
            //출차 일때
            else{
                int inTime = inAndOut.get(num);
                minuteTotal.put(num,minuteTotal.getOrDefault(num,0)+(totalMin-inTime));
                inAndOut.remove(num);
            }
            
        }
        // System.out.println(minuteTotal);
        //현재 남아있는 번호에 대해서는 lastClock에서 빼서 남은시간을 더해준다.
        for(String car:inAndOut.keySet()){
            // System.out.println(car +" "+(lastClock-inAndOut.get(car))+" "+inAndOut.get(car));
            minuteTotal.put(car,minuteTotal.getOrDefault(car,0)+(lastClock-inAndOut.get(car)));
        }
        
        
        List<String> mapKey = new ArrayList<>(minuteTotal.keySet());
        int[] answer = new int[mapKey.size()];
        Collections.sort(mapKey);
        // 기본 시간
        int defaultTime= fees[0];
        // 기본 요금
        int defaultFee = fees[1];
        // 단위 시간
        int unitTime = fees[2];
        // 단위 요금
        int unitFee = fees[3];
        
        for(int i=0;i<mapKey.size();i++){
            //사용시간
            int carTime = minuteTotal.get(mapKey.get(i));
            //나머지
            
            if(carTime>defaultTime){
                int remain = (carTime - defaultTime)%unitTime;
                if(remain>0){
                    answer[i] = defaultFee+((carTime - defaultTime)/unitTime+1)*unitFee;
                }
                else{
                    answer[i] = defaultFee+((carTime - defaultTime)/unitTime)*unitFee;
                }
            }
            else{
                answer[i] = defaultFee;
            }
            
        }
        return answer;
    }
}