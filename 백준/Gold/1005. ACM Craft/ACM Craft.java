import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int[] deg = new int[1001];
            int[] time = new int[1001];
            int[] dp = new int[1001];

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[1001];
            for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) time[i] = Integer.parseInt(st.nextToken());

            for(int i=1;i<K+1;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                deg[b]++;
            }
            int w = Integer.parseInt(br.readLine());

            //순회하면서 0인것들 큐에 삽입
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                if(deg[i] == 0){
                    q.add(i);
                    dp[i] = time[i];
                }
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : graph[cur]) {
                    dp[nxt] = Math.max(dp[nxt], dp[cur] + time[nxt]);
                    deg[nxt]--;
                    if(deg[nxt] == 0){
                        q.add(nxt);
                    }
                }
            }

            sb.append(dp[w]).append("\n");

        }
        System.out.println(sb);
    }
}
