import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] lc;
    static int[] rc;
    static Set<Integer> set;
    static int ans;
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        lc = new int[N+1];
        rc = new int[N+1];
        parent = new int[N+1];

        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lc[a] = b;
            rc[a] = c;
            if(b!=-1) parent[b] = a;
            if(c!=-1) parent[c] = a;

        }
        int cur = 1;
        int dist = 0;
        while(rc[cur] != -1){
            dist++;
            cur = rc[cur];
        }
        System.out.println(2*(N-1)-dist);
    }
}
