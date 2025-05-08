import java.util.*;
class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String,List<int[]>> map = new HashMap<>();
        // System.out.println(genresByPlay(genres,plays).toString());
        List<String[]> list = new ArrayList<>();
        list = genresByPlay(genres,plays);
        //장르별로 int[](횟수, 첨자) 저장
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            int play = plays[i];
            List<int[]> tmp = map.getOrDefault(genre,new ArrayList<>());
            tmp.add(new int[]{plays[i],i});
            map.put(genre,tmp);
        }
        // System.out.println(map);
        
        //장르별로 어레이 정렬
        for(String s:map.keySet()){
            Collections.sort(map.get(s),new Comparator<int[]>(){
                @Override
                public int compare(int[] i1, int[] i2){
                    if(i1[0] != i2[0]){
                        return i2[0] - i1[0];
                    }
                    else{
                        return i1[1] - i2[1];
                    }
                }
                
            });
        }
        List<Integer> ans = new ArrayList<>();
        //정렬에서 하나씩 빼서 장르별로 노래 인덱스를 answer에 추가
        for(int i=0;i<list.size();i++){
            String genre = list.get(i)[0];
            //해당 장르 어레이를 돌면서 인덱스를 answer에 넣기
            List<int[]> arr = map.get(genre);
            for(int j=0;j<arr.size() && j<2;j++){
                ans.add(arr.get(j)[1]);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    public List<String[]> genresByPlay(String[] genres, int[] plays){
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        //하나씩 리스트에 넣고 정렬
        List<String[]> list = new ArrayList<>();
        for(String s:map.keySet()){
            list.add(new String[]{s,String.valueOf(map.get(s))});
        }
        Collections.sort(list,new Comparator<String[]>(){
            @Override
            public int compare(String[] s1,String[] s2){
                return Integer.valueOf(s2[1])-Integer.valueOf(s1[1]);
            }
        });
        // for(int i=0;i<list.size();i++){
        //     System.out.println(list.get(i)[0]+list.get(i)[1]);
        // }
        
        return list;
    }
}