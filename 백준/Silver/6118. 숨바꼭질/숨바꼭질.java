import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int node;
    static int dist;
    static int numNodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(node).append(" ").append(dist).append(" ").append(numNodes);
        System.out.println(sb);
    }
    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int[] visited = new int[N+1];
        Arrays.fill(visited,-1);
        visited[1] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if(visited[nxt] != -1) continue;
                visited[nxt] = visited[cur]+1;
                q.add(nxt);
            }
        }
//        System.out.println(Arrays.toString(visited));
        node = -1;
        numNodes = 0;
        dist = -1;
        for(int i=1;i<N+1;i++){
            if(visited[i] > dist){
                dist = visited[i];
                numNodes = 1;
            }
            else if(visited[i] == dist){
                numNodes++;
            }
        }
        for(int i=1;i<N+1;i++){
            if(visited[i] == dist){
                node = i;
                break;
            }
        }
    }
}
