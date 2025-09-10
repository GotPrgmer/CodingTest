import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Deque<Integer> dqLeft = new ArrayDeque<>();
        Deque<Integer> dqRight = new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            dqLeft.addLast(i);
            dqRight.addLast(i);
        }
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            int leftCnt = rotateLeft(dqLeft,num);
            int rightCnt = rotateRight(dqRight,num);
            ans += Math.min(leftCnt,rightCnt);
        }
        System.out.println(ans);
    }
    static int rotateLeft(Deque<Integer> dq, int num){
        int cnt = 0;
        while(!dq.isEmpty() && dq.peekFirst() != num){
            cnt += 1;
            int tmp = dq.pollFirst();
            dq.addLast(tmp);
        }
        dq.poll();
        return cnt;
    }
    static int rotateRight(Deque<Integer> dq, int num){
        int cnt = 0;
        while(!dq.isEmpty() && dq.peekFirst() != num){
            cnt += 1;
            int tmp = dq.pollLast();
            dq.addFirst(tmp);
        }
        dq.poll();
        return cnt;
    }
}
