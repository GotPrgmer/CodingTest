import java.util.*;
class Solution {
    static Set<String> set;
    static Map<String, List<String>> map;
    static Set<String> visited;
    static Set<Set<String>> visited_pair;
    static int ans;
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        map = new HashMap<>();
        visited = new HashSet<>();
        visited_pair = new HashSet<>();
        ans =0;
        for(int i=0;i<banned_id.length;i++){
            set.add(banned_id[i]);
        }
        for(String s:set){
            for(int i=0;i<user_id.length;i++){
                //매치되면 map에 추가
                if(match(user_id[i],s)){
                    List<String> tmp = map.getOrDefault(s,new ArrayList<>());
                    tmp.add(user_id[i]);
                    map.put(s,tmp);
                }
            }
        }
        dfs(0,banned_id);
        return ans;
    }
    public boolean match(String user_id,String pattern){
        if(user_id.length() != pattern.length()){
            return false;
        }
        else{
            for(int i=0;i<user_id.length();i++){
                if(pattern.charAt(i) != '*' 
                   &&user_id.charAt(i) != pattern.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }
    public void dfs(int idx, String[] banned_id){
        if(visited.size() == banned_id.length ){
            Set<String> tmp = new HashSet<>(visited);
            if(!visited_pair.contains(tmp)){
                visited_pair.add(tmp);
                ans += 1;
            }
            return;
        }
        else{
            for(String s:map.get(banned_id[idx])){
                if(!visited.contains(s)){
                    visited.add(s);
                    dfs(idx+1, banned_id);
                    visited.remove(s);
                }
            }
        }
    }
}