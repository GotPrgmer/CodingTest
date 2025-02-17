import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<UserStatus> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for(String info:record){
            String[] infoList = info.split(" ");
            String act = infoList[0];
            String userId = infoList[1];
            String userNickName = "";
            if(act.equals("Enter") || act.equals("Change")){
                userNickName = infoList[2];
                map.put(userId,userNickName);

            }
            
            // 리스트에 누적시킴
            if(act.equals("Enter") || act.equals("Leave")){
                list.add(new UserStatus(userId,act));
            }         
        }
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            String id = list.get(i).id;
            String status = list.get(i).status;
            String nickname = map.get(id);
            String act = status.equals("Enter") ? "들어왔습니다.":"나갔습니다.";
            answer[i] = nickname+"님이 " + act;
        }
        return answer;
        
    }
}
class UserStatus{
    String id;
    String status;
    
    public UserStatus(String id,String status){
        this.id = id;
        this.status =status;
    }
}