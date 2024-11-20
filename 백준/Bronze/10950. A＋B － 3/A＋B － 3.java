import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i=0;i<testCase;i++){
            String[] nums = br.readLine().split(" ");
            int firstNum = Integer.parseInt(nums[0]);
            int secondNum = Integer.parseInt(nums[1]);
            System.out.println(firstNum+secondNum);
        }

    }
}