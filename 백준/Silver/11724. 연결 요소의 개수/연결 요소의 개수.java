import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int node, edge;
    static int[][] arr;
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        arr = new int[node + 1][node + 1];
        for (int line = 0; line < edge; line++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        int ans = 0;
        for(int idx=1;idx<node+1;idx++){
                if(!set.contains(idx) ){
                    bfs(idx);
                    ans += 1;
                }

        }
        sb.append(ans);
        System.out.println(sb);
    }

    private static void bfs(int start) {
        q.add(start);
        while (!q.isEmpty()) {
            start = q.poll();
            if(set.contains(start)){
                continue;
            }
            set.add(start);
            for(int next=1;next<node+1;next++){
                if(!set.contains(next) && arr[start][next] == 1){
                    q.add(next);
                }
            }
        }
    }
}
