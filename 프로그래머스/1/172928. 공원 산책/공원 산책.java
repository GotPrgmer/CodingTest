import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        // routes를 하나씩 받아서 현재 위치에서 옮기려는 위치가 비어잇는지 확인
        // 비어있으면 현재 위치를 옮기려는 위치로 변경
        // 비어있지 않으면 다음 명령으로 스킵
        Map<String,Integer> map = new HashMap<>();
        map.put("N",0);
        map.put("E",1);
        map.put("S",2);
        map.put("W",3);
        int[] d_r = new int[]{-1,0,1,0};
        int[] d_c = new int[]{0,1,0,-1};
        
        int cur_r = -1;
        int cur_c = -1;
        
        // 시작값 찾기
        for(int i=0;i<park.length;i++){
            for(int j =0;j<park[0].length();j++){
                if(park[i].charAt(j) == 'S'){
                    cur_r = i;
                    cur_c = j;
                    break;
                }
            }
            if(cur_r != -1 && cur_c != -1){
                break;
            }
        }
        int n = park.length;
        int m = park[0].length();
        
        for(String cmd:routes){
            System.out.println(cmd);
            System.out.println("초입" +cur_r + " " + cur_c);
            String[] cmdSplit = cmd.split(" ");
            String direction = cmdSplit[0];
            int moveCnt = Integer.valueOf(cmdSplit[1]);
            int dIdx = map.getOrDefault(direction,-1);
            int n_r = cur_r;
            int n_c = cur_c;
            
            boolean flag = true;
            //범위 확인
            //break하는 부분에서 flag false로 바꾸기
            while(n_r!=cur_r + d_r[dIdx]*moveCnt || n_c!=cur_c + d_c[dIdx]*moveCnt){
                System.out.println("emfdjrka");
                n_r += d_r[dIdx];
                n_c += d_c[dIdx];
                if(0<=n_r && n_r<n && 0<=n_c && n_c<m){
                //장애물 아님
                if(!(park[n_r].charAt(n_c) == 'X')){
                    continue;
                }
                //장애물 발견
                else{
                    flag = false;
                    break;
                }
            }
            else{
                flag = false;
                    break;
            }
            }
            System.out.println(n_r + " " + n_c);
            if(flag){
                cur_r = n_r;
                cur_c = n_c;
            }
            
            
        }
        int[] answer = new int[]{cur_r,cur_c};
        return answer;
    }
}