import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genreCount = new HashMap<>();
        HashMap<String,HashMap<Integer,Integer>> genrePlays = new HashMap<>();
        
        for(int idx=0;idx<plays.length;idx++){
            String genre = genres[idx];
            genreCount.put(genre,genreCount.getOrDefault(genre,0)+plays[idx]);
            //genrePlays 갱신
            HashMap<Integer,Integer> map = genrePlays.getOrDefault(genre,new HashMap<>());
            map.put(idx,plays[idx]);
            genrePlays.put(genre,map);
            
        }
        List<String> keySet = new ArrayList(genreCount.keySet());
        Collections.sort(keySet,(s1,s2)-> genreCount.get(s2)-genreCount.get(s1));
        //장르 순서대로 최대 2개의 노래를 정답에 넣는다.
        System.out.println(genreCount);
        System.out.println(genrePlays);
        ArrayList<Integer> answer = new ArrayList<>();
        for(String genre:keySet){
            HashMap<Integer,Integer> map = genrePlays.get(genre);
            List<Integer> idxList = new ArrayList(map.keySet());
            Collections.sort(idxList,(s1,s2)-> map.get(s2)-map.get(s1));
            answer.add(idxList.get(0));
            if(idxList.size()>=2){
                answer.add(idxList.get(1));
            }
        }
        System.out.println(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}