import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = -1;
        List<Integer>[] tree = new ArrayList[N];
        for(int i=0;i<N;i++) tree[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) root = i;
            else{
                tree[node].add(i);
            }
        }

        int ans = 0;

        int cut = Integer.parseInt(br.readLine());

        if(root == cut) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int child = 0;
            int cur = q.poll();
            //cur의 자식이 버려지는 자식인지 각각 확인
            for (int nxt : tree[cur]) {
                if(nxt == cut) continue;
                child++;
                q.add(nxt);
            }
            if(child == 0){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
