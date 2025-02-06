import java.util.*;
class Solution {
    static Map<String,List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        
        for(int i=0;i<info.length;i++){
            String[] infoList = info[i].split(" ");
            pathInclude(infoList,0,"");
        }
        
        for(String key:map.keySet()){
            Collections.sort(map.get(key));
        }
        int[] answer = new int[query.length];
        //query에서 하나씩 꺼내서 이분탐색 돌림
        StringBuilder sb;
        for(int i=0;i<query.length;i++){
            sb = new StringBuilder();
            String[] queryStr = query[i].split(" and ");
            String[] tmp = queryStr[3].split(" ");
            int findNum = Integer.parseInt(tmp[1]);
            sb.append(queryStr[0]);
            sb.append(queryStr[1]);
            sb.append(queryStr[2]);
            sb.append(tmp[0]);
            // System.out.println(sb.toString());
            answer[i] = binarySearch(sb.toString(),findNum);
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    private void pathInclude(String[] info,int cnt,String str){
        if(cnt ==4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(info[4]));
        }
        else{
            pathInclude(info,cnt+1,str+info[cnt]);
            pathInclude(info,cnt+1,str+"-");
        }
        
    }
    private int binarySearch(String findKey,int goal){
        List<Integer> numbers = map.getOrDefault(findKey,new ArrayList<>());
        // System.out.println(numbers);
        int l = -1;
        int h = numbers.size();
        if (numbers.size() == 0){
            return 0;
        }

        while(l+1<h){
            int m = (l+h)/2;
            //체크
            if(numbers.get(m) < goal){
                l = m;
            }
            else{
                h = m;
            }
        }
        return numbers.size() - h;
    }
}