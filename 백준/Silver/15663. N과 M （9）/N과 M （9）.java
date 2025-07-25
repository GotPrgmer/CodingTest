import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
            static Set<String> result;
    static List<String> answerList;
    public static void main(String[] args) throws IOException {
        result = new HashSet<>();
        answerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        String[] nList = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);
        //n 배열
        int[] nArray = new int[n];
        for(int i=0;i<n;i++){
            nArray[i] = Integer.parseInt(nList[i]);
        }
        Arrays.sort(nArray);

        backtrack(0, m, nArray, "",new boolean[n]);

//        Collections.sort(answerList);
        for(int i=0 ; i<answerList.size();i++){
            if(i==answerList.size()-1){
                System.out.print(answerList.get(i));
            }
            else{
                System.out.println(answerList.get(i));
            }
        }
    }

    public static void backtrack(int cnt, int m, int[] nArray, String array, boolean[] visited){
        if(cnt == m && !result.contains(array)){
            result.add(array);
            answerList.add(array);
        }
        else if(cnt < m){
            for(int i=0;i<nArray.length;i++){
                if(!visited[i]){
                    visited[i] = true;
                    if(array.isEmpty()){
                        backtrack(cnt+1, m, nArray, String.valueOf(nArray[i]), visited);
                    }
                    else{
                        backtrack(cnt+1, m, nArray, array +" "+nArray[i], visited);
                    }
                    visited[i] = false;
                }
            }
        }
    }
}