import java.util.*;
class Solution {
    static Map<String,Integer> cache;
    public int solution(int cacheSize, String[] cities) {
        cache = new HashMap<>();
        int ans = 0;
        if(cacheSize<1){
            return 5*cities.length;
        }
        else{
            //도시돌면서 LRU
        for(int i=0;i<cities.length;i++){
            String findKey = cities[i].toLowerCase();
            if(cache.containsKey(findKey)){
                cache.put(findKey,i);
                ans += 1;
            }
            else{
                if(cache.size()<cacheSize){
                    cache.put(findKey,i);
                }
                else{
                    change(findKey,i);
                }
                ans += 5;
            }
        }
        return ans;
        }
        
    }
    
    private void change(String changeKey,int i){
        //key와 value 기록해서 뺌
        String minimumKey ="";
        int tmp =Integer.MAX_VALUE;
        for(String key:cache.keySet()){
            if(tmp>cache.get(key)){
                minimumKey = key;
                tmp = cache.get(key);
            }
        }
        cache.remove(minimumKey);
        cache.put(changeKey,i);
        
    }
}