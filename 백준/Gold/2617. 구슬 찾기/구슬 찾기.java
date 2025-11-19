import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int M;
    static List<Integer>[] lightGraph;
    static List<Integer>[] heavyGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        heavyGraph = new ArrayList[N+1];
        lightGraph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) {
            heavyGraph[i] = new ArrayList<>();
            lightGraph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lightGraph[b].add(a);
            heavyGraph[a].add(b);
        }
        int ans = 0;
        for(int i=1;i<N+1;i++){
            int lightBfs = lightBfs(i);

            int heavyBfs = heavyBfs(i);
            //최대값
            if(lightBfs >= (N+1)/2 || heavyBfs >= (N+1)/2){
                ans ++;
            }

        }
        System.out.println(ans);
    }
    static int lightBfs(int start){
        Queue<Integer> q= new ArrayDeque<>();
        int[] visited = new int[N+1];
        q.add(start);
        visited[start] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt:lightGraph[cur]){
                if(visited[nxt] == 1) continue;
                visited[nxt] = 1;
                q.add(nxt);
                cnt++;
            }

        }
        return cnt;
    }
    static int heavyBfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[N+1];
        q.add(start);
        visited[start] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt:heavyGraph[cur]){
                if(visited[nxt] == 1) continue;
                visited[nxt] = 1;
                q.add(nxt);
                cnt++;
            }

        }
        return cnt;
    }
}
