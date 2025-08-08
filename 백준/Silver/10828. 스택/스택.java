import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int M = 1000005;
    private static int[] data = new int[M];
    private static int pos = 0;

    public static void push(int x){
        data[pos] = x;
        pos++;
    }
    public static int pop(){
        pos -= 1;
        return data[pos];
    }
    public static int top(){
        return data[pos-1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            if(cmd.equals("push")){
                push(Integer.parseInt(input[1]));
            }
            else if(cmd.equals("pop")){
                if(pos>0){
                    System.out.println(pop());
                }
                else{
                    System.out.println(-1);
                }

            }
            else if(cmd.equals("size")){
                System.out.println(pos);
            }
            else if(cmd.equals("empty")){
                if(pos == 0){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(cmd.equals("top")){
                if(pos>0){
                    System.out.println(top());
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }
}