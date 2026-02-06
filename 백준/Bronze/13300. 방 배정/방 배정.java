import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] boys = new int[7];
        int[] girls = new int[7];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            if(sex ==0){
                girls[grade] += 1;
            }
            else{
                boys[grade] += 1;
            }
        }
        int room = 0;
        for(int i=1;i<=6;i++){
            room += boys[i]/K + ((boys[i]%K!=0)?1:0);
            room += girls[i]/K + ((girls[i]%K!=0)?1:0);
        }
        System.out.println(room);
    }
}
