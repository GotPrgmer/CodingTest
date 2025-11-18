import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] visited;
    static int[] cnt;
    static int[] numOfCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new int[N+1];
        Arrays.fill(visited, -1);
        cnt = new int[N + 1];
        numOfCnt = new int[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        StringBuilder sb = new StringBuilder();
        int max = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<N+1;i++){
            int tmp = bfs(i);
//            System.out.println(tmp);
            if(max < tmp){
                ans.clear();
                max = tmp;
                ans.add(i);
            }
            else if(max == tmp){
                ans.add(i);
            }
        }
        for(int i=0;i<ans.size();i++){
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    static int bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        visited = new int[N+1];
        visited[start] = 1;
        q.add(start);
        int cntReach = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (visited[nxt] != 0) continue;
                visited[nxt] = 1;
                q.add(nxt);
                cntReach++;
            }
        }
        return cntReach;
    }
}
