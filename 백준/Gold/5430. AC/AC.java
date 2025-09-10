import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            boolean isLeft = true;
            char[] cmd = br.readLine().toCharArray();
            boolean isFlag = true;
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<Integer> dq = new ArrayDeque<>();

            // 배열 파싱 ( [] 제거 후 split )
            if (n > 0) {
                arr = arr.substring(1, arr.length() - 1);
                for (String s : arr.split(",")) {
                    dq.addLast(Integer.parseInt(s));
                }
            }
            for(int j=0;j<cmd.length;j++){
                if(cmd[j] == 'R'){
                    isLeft = !isLeft;
                }
                else{
                    if(dq.isEmpty()){
                        isFlag = false;
                        break;
                    }
                    else{
                        if(isLeft){
                            dq.pollFirst();
                        }
                        else{
                            dq.pollLast();
                        }

                    }
                }
            }
            if(!isFlag){
                System.out.println("error");
            }
            else{
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                while(!dq.isEmpty()){
                    if(isLeft){
                        sb.append(dq.pollFirst());
                    }
                    else{
                        sb.append(dq.pollLast());
                    }

                    if(!dq.isEmpty()){
                        sb.append(',');
                    }
                }
                sb.append(']');
                System.out.println(sb.toString());
            }
        }
    }
}
