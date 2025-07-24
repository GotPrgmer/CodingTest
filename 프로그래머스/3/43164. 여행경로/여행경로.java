import java.util.*;
class Solution {
    static List<String> results;
    public String[] solution(String[][] tickets) {
        results = new ArrayList<>();
        //tickets 정렬 하기


        dfs("ICN",tickets,new boolean[tickets.length],0,"ICN");
        
        Collections.sort(results);
        String[] answer = results.get(0).split(" ");

        return answer;
    }
    
    public void dfs(String start, String[][] tickets, boolean[] visited, int cnt,String tmp){
        if(cnt == tickets.length){
            results.add(tmp);
        }
        else{
            //현재 출발지에서 출발하는 티켓이 있는지 확인
            for(int idx=0;idx<tickets.length;idx++){
                if(tickets[idx][0].equals(start) && !visited[idx]){
                    visited[idx] = true;
                    dfs(tickets[idx][1],tickets,visited,cnt+1,tmp +" "+tickets[idx][1]);
                    visited[idx] = false;
                }
            }
        }
    }
}