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
            String[] listProcessing = br.readLine().split("\\[")[1].split("]");
            String[] list = new String[0];
            Deque<Integer> dq = new ArrayDeque<>();
            if(listProcessing.length !=0){
                list = listProcessing[0].split(",");
                dq = new ArrayDeque<>();
            }

            for (String s : list) {
                dq.addLast(Integer.parseInt(s));
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