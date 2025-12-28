import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<String>> ans = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s = new String[1001];
        int[] degree = new int[1001];
        for(int i=0;i<N;i++){
            String tmp = st.nextToken();
            s[i] = tmp;
            map.put(tmp, i);
            ans.put(tmp, new ArrayList<>());
        }
        List<Integer>[] adj = new ArrayList[1001];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String X = st.nextToken();
            String Y = st.nextToken();
            degree[map.get(X)]++;
            adj[map.get(Y)].add(map.get(X));
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<String> roots = new ArrayList<>();
        int treeCnt = 0;
        for(int i=0;i<N;i++){
            if(degree[i] == 0) {
                roots.add(s[i]);
                q.add(i);
                treeCnt++;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                degree[nxt]--;
                if(degree[nxt]==0){
                    q.add(nxt);
                    ans.get(s[cur]).add(s[nxt]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(treeCnt);
        sb.append("\n");
        Collections.sort(roots);
        for (int i = 0; i < roots.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(roots.get(i));
        }
        sb.append("\n");
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        for (String k : keys) {
            List<String> children = ans.get(k);
            Collections.sort(children);

            sb.append(k).append(" ").append(children.size());
            for (String c : children) sb.append(" ").append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
