import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int inputIdx=0;inputIdx<input.length();inputIdx++){
            Character curLetter = input.charAt(inputIdx);
            if(Character.isUpperCase(curLetter)){
                int tmp = curLetter + 13;
                if(tmp>90){
                    tmp -= 26;
                }
                sb.append((char)(tmp));
            } else if (Character.isLowerCase(curLetter)) {
                int tmp = curLetter + 13;
                if(tmp>122){
                    tmp -= 26;
                }
                sb.append((char)(tmp));
            } else {
                sb.append(curLetter);
            }
        }
        System.out.println(sb);
    }
}
