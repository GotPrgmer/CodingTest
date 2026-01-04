import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] beauty;
    static List<Integer>[] graph;
    static int[][] dp;
    static final char[] COLOR = {'R', 'G', 'B'};
    static char[] selected;

    static int dfs(int cur, int color){
        if (dp[cur][color] != 0) {
            return dp[cur][color];
        }
        int sum = beauty[cur][color];
        for (int nxt : graph[cur]) {
            if(visited[nxt]) continue;
            visited[nxt] = true;
            int max = Integer.MIN_VALUE;
            for(int c=0;c<3;c++){
                if(c==color) continue;
                max = Math.max(max, dfs(nxt, c));
            }
            visited[nxt] = false;
            sum += max;
        }
        return dp[cur][color] = sum;
    }

    static void restore(int cur, int parent, int color){
        selected[cur] = COLOR[color];
        for (int nxt : graph[cur]) {
            if(nxt == parent) continue;

            int bestColor = -1;
            int bestVal = Integer.MIN_VALUE;
            for (int c = 0; c < 3; c++) {
                if(c == color) continue;
                if (dp[nxt][c] > bestVal) {
                    bestVal = dp[nxt][c];
                    bestColor =c;
                }
            }
            restore(nxt, cur, bestColor);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N+1][3];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        beauty = new int[N+1][3];
        selected = new char[N+1];

        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                beauty[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MIN_VALUE;
        int rootColor = 0;
        for (int c = 0; c < 3; c++) {
            visited[1] = true;
            int val = dfs(1, c);
            visited[1] = false;
            if (val > ans) {
                ans = val;
                rootColor = c;
            }
        }
        restore(1, 0, rootColor);
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append('\n');
        for (int i = 1; i <= N; i++) sb.append(selected[i]);
        System.out.println(sb);

    }
}
