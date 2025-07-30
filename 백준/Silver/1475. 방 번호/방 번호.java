import java.io.BufferedReader;                                                                            
import java.io.IOException;                                                                               
import java.io.InputStreamReader;                                                                         
import java.util.*;                                                                                       
                                                                                                          
public class Main {
    public static void main(String[] args) throws IOException {
        int[] cnt = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                         
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        for(char c:N.toCharArray()){
            cnt[(int)c-'0'] += 1;
        }
        int sixAndNine = (cnt[6]+cnt[9])/2 + (cnt[6]+cnt[9])%2;
        int max = 0;
        for(int i=0;i<9;i++){
            if(i!=6){
                max = Math.max(max,cnt[i]);
            }
        }
        System.out.println(Math.max(max,sixAndNine));
    }
}                                                                                              
                                                                                                          