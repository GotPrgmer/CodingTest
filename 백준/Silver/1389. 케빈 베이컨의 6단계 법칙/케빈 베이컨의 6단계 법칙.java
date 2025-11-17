import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[][] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i!=j){
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
//        for (int i = 0; i < N + 1; i++) System.out.println(Arrays.toString(graph[i]));

        for(int h=1;h<N+1;h++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(graph[i][h] == Integer.MAX_VALUE || graph[h][j] == Integer.MAX_VALUE) continue;
                    if(i!=j && graph[i][j] > graph[i][h]+graph[h][j]){
                        graph[i][j] = graph[i][h]+graph[h][j];
                    }
                }
            }
        }
        int maxSum = -1;
        int ans = -1;
        for (int i = 1; i < N + 1; i++) {
            int tmp = Arrays.stream(graph[i]).sum();
            if(maxSum == -1){
                maxSum = tmp;
                ans = i;
            }
            else if(maxSum > tmp){
                maxSum = tmp;
                ans = i;
            }
        }
        System.out.println(ans);

    }
}
