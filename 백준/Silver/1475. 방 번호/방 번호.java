import java.io.BufferedReader;                                                                            
import java.io.IOException;                                                                               
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
                                                                                                          
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] roomNum = br.readLine().toCharArray();
        int[] cnt = new int[9];
        for (char c : roomNum) {
            if(c=='9'){
                cnt[6] += 1;
            }
            else{
                cnt[c-'0'] += 1;
            }
        }
        int ans = 0;
        for(int i=0;i<9;i++){
            if(i==6){
                ans = Math.max(ans, cnt[i] / 2 + cnt[i] % 2);
            }
            else{
                ans = Math.max(ans, cnt[i]);
            }
        }
        System.out.println(ans);

    }
}