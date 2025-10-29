import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->
        {
            if(o1[1]!=o2[1]){
                return Integer.compare(o1[1],o2[1]);
            }
            else{
                return Integer.compare(o1[0],o2[0]);
            }

        });

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.add(new int[]{start,end});
        }
        int s = 0;
        int ans = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(s<=cur[0]){
                ans ++;
                s=cur[1];
            }
        }
        System.out.println(ans);
    }
}
