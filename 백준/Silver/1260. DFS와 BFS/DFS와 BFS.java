import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    static int node, line, start;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node + 1];
        for(int inputIdx=0;inputIdx<line;inputIdx++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];
        bfs(start);
        System.out.println(sb);
    }

    private static void dfs(int start){
        check[start] = true;
        sb.append(start).append(" ");
        for(int nextNode=1;nextNode<node+1;nextNode++){
            if(!check[nextNode] && arr[start][nextNode] == 1){
                dfs(nextNode);
            }
        }
    }

    private static void bfs(int start){
        q.add(start);
        while(!q.isEmpty()){
            start = q.poll();
            if(check[start]){
                continue;
            }
            sb.append(start).append(" ");
            check[start] = true;
            for(int nextNode=1;nextNode<node+1;nextNode++){
                if(!check[nextNode] && arr[start][nextNode]==1){
                    q.add(nextNode);
                }
        }

        }
    }
}
