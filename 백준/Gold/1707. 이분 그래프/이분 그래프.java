import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static Queue<Integer> q;
    static int[] check;
    static List<List<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int test=0;test<t;test++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();

            check = new int[node+1];
            //그래프 초기화
            graph = new ArrayList<>();
            for(int vertex=0; vertex < node+1;vertex++){
                graph.add(new ArrayList<>());
            }
            for(int e=0;e<edges;e++){
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                graph.get(first).add(second);
                graph.get(second).add(first);
            }
            //bfs
            boolean ans = true;
            for(int n=1;n<node+1;n++){
                if(check[n]==0 && !bfs(n)){
                    ans = false;
                    break;
                }
            }
            if(ans){
                sb.append("YES");
            }
            else{
                sb.append("NO");
            }
            sb.append("\n");


        }
        System.out.println(sb);
    }

    private static boolean bfs(int start) {
        q.add(start);
        check[start] = 1;

        while(!q.isEmpty()){
            start = q.poll();
            for (int next : graph.get(start)) {
                if(check[next] == check[start]){
                    return false;
                }
                else if(check[next] == 0){
                    check[next] = check[start]*(-1);
                    q.add(next);
                }

            }
        }
        return true;

    }

}
