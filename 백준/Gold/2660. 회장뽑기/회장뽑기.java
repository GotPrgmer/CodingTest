import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] graph;
    static int MAX = Integer.MAX_VALUE;
    static int score;
    static List<Integer> candidates;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=i+1;j<N+1;j++){
                graph[i][j] = MAX;
                graph[j][i] = MAX;
            }
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1 && b== -1) break;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        floydWashal();
        StringBuilder sb1 = new StringBuilder();
        sb1.append(score).append(" ").append(candidates.size());
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < candidates.size(); i++) sb2.append(candidates.get(i)).append(" ");
        System.out.println(sb1);
        System.out.println(sb2);
    }
    static void floydWashal(){
        for(int h=1;h<N+1;h++){
            for(int i=1;i<N+1;i++){
                for(int j=i+1;j<N+1;j++){
                    if(graph[i][h] == MAX || graph[h][j] == MAX) continue;
                    if (graph[i][j] > graph[i][h] + graph[h][j]) {
                        graph[i][j] = graph[i][h] + graph[h][j];
                        graph[j][i] = graph[i][h] + graph[h][j];
                    }
                }
            }
        }
        score = MAX;
        candidates = new ArrayList<>();
        for (int i = 1; i < N + 1; i++){
            int tmp = -1;
            for(int j=1;j<N+1;j++){
                tmp = Math.max(graph[i][j], tmp);
            }
            if(score>tmp) {
                candidates.clear();
                candidates.add(i);
                score = tmp;
            }
            else if(score == tmp){
                candidates.add(i);
            }
        }
    }
}