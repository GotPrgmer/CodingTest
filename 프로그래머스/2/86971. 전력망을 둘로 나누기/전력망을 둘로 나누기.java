import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<wires.length;i++){
            int first = wires[i][0];
            int second = wires[i][1];
            graph[first].add(second);
            graph[second].add(first);
        }
        int answer = 101;
        for(int i=0;i<wires.length;i++){
            visited = new boolean[n+1];
            int first = wires[i][0];
            int second = wires[i][1];
            graph[first].remove(Integer.valueOf(second));
            graph[second].remove(Integer.valueOf(first));
            int cnt = dfs(1);
            answer = Math.min(answer,Math.abs(cnt-(n-cnt)));
            graph[first].add(second);
            graph[second].add(first);


        }
        return answer;
    }
    public int dfs(int cur){
        visited[cur] = true;
        int cnt = 1;
        for(int next:graph[cur]){
            if(!visited[next]){
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}