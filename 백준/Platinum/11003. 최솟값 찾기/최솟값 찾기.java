import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLineInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineInput[0]);
        int L = Integer.parseInt(firstLineInput[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Pair> dq = new ArrayDeque<>();
        int[] ans = new int[N];
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            //첫 L개(맨 처음 슬라이딩 윈도우 만듦)
            if(i<L){
                if(!dq.isEmpty()){
                    while(!dq.isEmpty() && dq.peekLast().v > num){
                        dq.pollLast();
                    }
                }
            }
            else{
                if(dq.peekFirst().i+(L-1)<i){
                    dq.pollFirst();
                }
                if(!dq.isEmpty()){
                    while(!dq.isEmpty() && dq.peekLast().v > num){
                        dq.pollLast();
                    }
                }
            }
            dq.addLast(new Pair(i,num));
            ans[i] = dq.peekFirst().v;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ans.length;i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
class Pair{
    int i;
    int v;
    Pair(int i, int v){
        this.i = i;
        this.v = v;
    }
}