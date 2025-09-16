import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[100_001];
        Arrays.fill(visited,-1);
        visited[N] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==K){
                System.out.println(visited[cur]);
                break;
            }
            for(int d=0;d<3;d++){
                int n_num = -1;
                if(d==0){
                    n_num = cur-1;
                }
                else if(d==1){
                    n_num = cur+1;
                }
                else{
                    n_num = cur*2;
                }
                if(n_num<0 || n_num>100000) continue;
                if(visited[n_num] != -1) continue;
                visited[n_num] = visited[cur]+1;
                q.add(n_num);
            }
        }
//        System.out.println(Arrays.toString(visited));
    }
}
