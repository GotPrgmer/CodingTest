import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int A = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);
        int num = Integer.parseInt(br.readLine());
        String[] inputNums = br.readLine().split(" ");
        long sum = 0;
        int tmp = 1;
        for(int idx=0;idx<num;idx++){
            sum += Long.parseLong(inputNums[num-1-idx])*tmp;
            tmp *= A;
        }
        System.out.println(change(sum, B));

    }
    static StringBuilder change(long sum,int B){
        StringBuilder sb = new StringBuilder();
        if(sum==0){
            return sb.append("0");
        }
        while(sum!=0){
            sb.insert(0,sum % B+" ");
            sum/=B;
        }
        return sb;
    }
}