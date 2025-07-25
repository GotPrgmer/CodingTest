import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> visited;
    static List<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        String[] nList = br.readLine().split(" ");
        visited = new HashSet<>();
        answer = new ArrayList<>();
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);
        int[] nums = new int[nList.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(nList[i]);
        }
        Arrays.sort(nums);
        backtrack(0,"",nums,m);
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }
    public static void backtrack(int cnt, String cur, int[] nums, int m){
        if(cnt == m && !visited.contains(cur)){
            visited.add(cur);
            answer.add(cur);
        }
        else if(cnt != m){
            for(int i=0;i<nums.length;i++){
                    if(cur.isEmpty()){
                        backtrack(cnt+1,String.valueOf(nums[i]),nums,m);
                    }
                    else{
                        backtrack(cnt+1,cur+" "+nums[i],nums,m);
                    }
                }
            }


    }
}
