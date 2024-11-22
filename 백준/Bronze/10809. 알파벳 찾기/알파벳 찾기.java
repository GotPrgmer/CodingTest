
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alphabetCnt = new int[26];
        for(int alphabetIdx=0;alphabetIdx<alphabetCnt.length;alphabetIdx++){
            alphabetCnt[alphabetIdx] = -1;
        }
        for(int inputIdx=0;inputIdx<input.length();inputIdx++){
            int tmp = input.charAt(inputIdx) - 97;
            if(alphabetCnt[tmp] == -1){
                alphabetCnt[tmp] = inputIdx;
            }
        }
        for(int alphabetIdx=0;alphabetIdx<alphabetCnt.length;alphabetIdx++){
            int curCnt = alphabetCnt[alphabetIdx];
                System.out.print(curCnt+" ");
        }
    }
}
