import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comNum = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        graph = new ArrayList[comNum+1];
        visited = new boolean[comNum+1];
        for(int i=0;i<comNum+1;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<pair;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] =  true;
        int ans = 0;
        int t=2;
        while(t-->0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                for(int nxt:graph[cur]){
                    if(visited[nxt]) continue;
                    ans++;
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
        return ans;

    }
}
