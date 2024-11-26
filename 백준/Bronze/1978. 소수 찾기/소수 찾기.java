import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int biggest = 0;
        for(int idx=0;idx<input.length;idx++){
            biggest = Math.max(biggest, Integer.parseInt(input[idx]));
        }
        List<Boolean> list = new LinkedList<>();
        for(int idx=0;idx<biggest+1;idx++){
            list.add(true);
        }
        list.set(0,false);
        list.set(1, false);
        for(int idx=0;idx<Math.sqrt(biggest)+1;idx++){
            if(list.get(idx)){
                for(int changeIdx=idx*2;changeIdx<biggest+1;changeIdx+=idx){
                    list.set(changeIdx, false);
                }
            }

        }

        int ans = 0;
        for(int cntIdx=0;cntIdx<input.length;cntIdx++){
            if(list.get(Integer.parseInt(input[cntIdx]))){
                ans += 1;
            }
        }
        System.out.println(ans);

    }
}
