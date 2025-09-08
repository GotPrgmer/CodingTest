import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> que = new LinkedList<Integer>();
        int last = 0;
        StringBuilder sb = new StringBuilder();

        for (int cmd = 0; cmd < testCase; cmd++) {
            st = new StringTokenizer(br.readLine());
            String commandKind = st.nextToken();
            if (commandKind.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                que.add(last);
            }
            else if (commandKind.equals("pop")) {
                if(que.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(que.poll()).append("\n");
                }
            } else if (commandKind.equals("size")) {
                sb.append(que.size()).append("\n");
            }
            else if (commandKind.equals("empty")) {
                if (que.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if (commandKind.equals("front")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(que.peek()).append("\n");
                }
            }
            else if (commandKind.equals("back")) {
                if (que.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(last).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
