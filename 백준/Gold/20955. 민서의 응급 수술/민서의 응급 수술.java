import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] parent = new int[N+1];
        int cycle = 0;

        for(int i=1;i<N+1;i++){
            if(parent[i] == 0){
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for (int nxt : graph[cur]) {
                        if(nxt == parent[cur]) continue;
                        //사이클
                        if(parent[nxt] != 0){
//                            System.out.println(nxt);
                            cycle++;
                        }
                        else{
                            parent[nxt] = cur;
                            q.add(nxt);
                        }
                    }
                }
            }
        }

        int rootCnt = 0;

//        System.out.println(Arrays.toString(parent));

        for(int i=1;i<N+1;i++){
            if(parent[i] == 0){
                rootCnt++;
            }
        }
        int ans = cycle/2 + (rootCnt - 1);
        System.out.println(ans);
    }
}

