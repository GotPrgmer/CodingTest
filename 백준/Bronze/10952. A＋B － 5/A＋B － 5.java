import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while(true){
            s = br.readLine();
            int firstNum = s.charAt(0)-48;
            int secondNum = s.charAt(2) - 48;
            if(firstNum==0 && secondNum==0){
                break;
            }
            sb.append(firstNum + secondNum);
            sb.append("\n");

        }
        System.out.println(sb);
    }
}