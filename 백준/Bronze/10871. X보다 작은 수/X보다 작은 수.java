import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] numList = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        //m보다 작은 수
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<n;i++){
            int cur = Integer.parseInt(numList[i]);
            if(cur<m){
                answerList.add(cur);
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++){
            System.out.print(answerList.get(i)+" ");
        }
    }
}
