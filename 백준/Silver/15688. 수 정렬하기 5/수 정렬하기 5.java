import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(sort());
    }
    static String sort(){
        int[] tmp1 = new int[1000000+1];
        int[] tmp2 = new int[1000000+1];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            int num = Math.abs(arr[i]);
            if(arr[i]<0){

                tmp2[num] += 1;
            }
            else{
                tmp1[num] += 1;
            }
        }
        int st = 1000000;
        while(st>0){
            if(tmp2[st] != 0){
                sb.append(-st).append("\n");
                tmp2[st] -= 1;
            }
            else{
                st--;
            }
        }

        while(st<1000001){
            if(tmp1[st] != 0){
                sb.append(st).append("\n");
                tmp1[st] -= 1;
            }
            else{
                st++;
            }
        }
        return sb.toString();
    }
}
