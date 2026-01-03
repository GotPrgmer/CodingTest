import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static int[][] beauty;     // beauty[i][0]=R, [1]=G, [2]=B
    static long[][] dp;        // dp[i][color]
    static int[] parent;
    static int[] order;
    static char[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        beauty = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            beauty[i][0] = Integer.parseInt(st.nextToken());
            beauty[i][1] = Integer.parseInt(st.nextToken());
            beauty[i][2] = Integer.parseInt(st.nextToken());
        }

        // 1) root=1 기준으로 parent, order 만들기 (반복 DFS)
        parent = new int[N + 1];
        order = new int[N];
        parent[1] = -1;

        int idx = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            order[idx++] = cur;

            for (int nxt : graph[cur]) {
                if (nxt == parent[cur]) continue;
                parent[nxt] = cur;
                stack.push(nxt);
            }
        }

        // 2) post-order DP (order 역순)
        dp = new long[N + 1][3];

        for (int i = N - 1; i >= 0; i--) {
            int cur = order[i];

            dp[cur][0] = beauty[cur][0];
            dp[cur][1] = beauty[cur][1];
            dp[cur][2] = beauty[cur][2];

            for (int nxt : graph[cur]) {
                if (nxt == parent[cur]) continue;

                dp[cur][0] += Math.max(dp[nxt][1], dp[nxt][2]);
                dp[cur][1] += Math.max(dp[nxt][0], dp[nxt][2]);
                dp[cur][2] += Math.max(dp[nxt][0], dp[nxt][1]);
            }
        }

        // 3) 루트 최적 색 선택 (C++의 max({f(1,0),f(1,1),f(1,2)}) 동일)
        int rootColor = 0;
        if (dp[1][1] > dp[1][rootColor]) rootColor = 1;
        if (dp[1][2] > dp[1][rootColor]) rootColor = 2;

        long best = dp[1][rootColor];

        // 4) 색 복원 (C++의 g() 동일한 비교 방식)
        ans = new char[N + 1];
        char[] map = new char[]{'R', 'G', 'B'};

        ArrayDeque<int[]> st2 = new ArrayDeque<>();
        st2.push(new int[]{1, rootColor});
        ans[1] = map[rootColor];

        while (!st2.isEmpty()) {
            int[] cur = st2.pop();
            int node = cur[0];
            int color = cur[1];

            for (int nxt : graph[node]) {
                if (nxt == parent[node]) continue;

                int childColor;
                if (color == 0) { // parent=R -> child=G or B
                    childColor = (dp[nxt][1] > dp[nxt][2]) ? 1 : 2;
                } else if (color == 1) { // parent=G -> child=R or B
                    childColor = (dp[nxt][0] > dp[nxt][2]) ? 0 : 2;
                } else { // parent=B -> child=R or G
                    childColor = (dp[nxt][1] > dp[nxt][0]) ? 1 : 0;
                }

                ans[nxt] = map[childColor];
                st2.push(new int[]{nxt, childColor});
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(best).append('\n');
        for (int i = 1; i <= N; i++) sb.append(ans[i]);
        System.out.print(sb);
    }
}