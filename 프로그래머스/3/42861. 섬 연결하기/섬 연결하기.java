import java.util.*;
class Solution {
    static List<List<int[]>> relationList;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        relationList = new ArrayList<>();
        for(int i=0;i<n;i++){
            relationList.add(new ArrayList<>());
        }
        for(int i=0;i<costs.length;i++){
            int n1 = costs[i][0];
            int n2 = costs[i][1];
            int cost = costs[i][2];
            relationList.get(n1).add(new int[]{cost,n2});
            relationList.get(n2).add(new int[]{cost,n1});
        }
        return prim(n);
    }
    public int prim(int n){
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String[] tmp1 = s1.split(" ");
                String[] tmp2 = s2.split(" ");
                int i1 = Integer.parseInt(tmp1[0]);
                int i2 = Integer.parseInt(tmp2[0]);
                return i1-i2;
            }
        });
        boolean[] visited = new boolean[n];
        pq.add("0 0");
        int ans = 0;
        while(!pq.isEmpty()){
            String cur = pq.poll();
            String[] tmp = cur.split(" ");
            int cost = Integer.parseInt(tmp[0]);
            int node = Integer.parseInt(tmp[1]);
            if(visited[node]){
                continue;
            }
            ans += cost;
            visited[node] = true;
            for(int[] list:relationList.get(node)){
                int nextC = list[0];
                int nextNode = list[1];
                pq.add(nextC+" "+nextNode);
            }
        }
        return ans;
    }
}