import java.util.*;
class Solution {
    static Set<Integer> num_set;
    static boolean[] visited;
    static String nums;
    static int answer;
    public int solution(String numbers) {
        answer = 0;
        visited = new boolean[numbers.length()];
        num_set = new HashSet<>();
        nums = numbers;
        dfs(0,0,numbers.length());
        return answer;
    }
    public void dfs(int num, int idx, int total_length){
        if(!num_set.contains(num) && isPrime(num)){
            System.out.println(num);
            num_set.add(num);
            answer += 1;
        }
        else if(idx==total_length){
            return;
        }
        //현재 숫자 검증
        for(int i=0;i<total_length;i++){
            if(!visited[i]){
               visited[i] = true;
                dfs(Integer.parseInt(String.valueOf(num)+nums.charAt(i)),idx+1,total_length);
                visited[i] = false; 
            }
            
        }
        num_set.add(num);
    }
    
    
    public boolean isPrime(int num){
        int div = 2;
        if(num<2){
            return false;
        }
        while(div<=Math.sqrt(num+1)){
            if(num%div == 0){
                return false;
            }
            div += 1;
        }
        return true;
    }
}