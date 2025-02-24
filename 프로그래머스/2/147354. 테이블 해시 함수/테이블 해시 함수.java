import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {    
        List<Tuple> list = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            list.add(new Tuple(data[i],col));
        }
    
        Collections.sort(list);
        // System.out.println(list);
        int answer = 0;
        for(int j=0;j<list.get(row_begin-1).tuple.length;j++){
                answer += list.get(row_begin-1).tuple[j]%row_begin;
            }
        for(int i=row_begin+1;i<row_end+1;i++){
            int sum = 0;
            for(int j=0;j<list.get(i-1).tuple.length;j++){
                // System.out.println(list.get(i-1).tuple[j]);
                sum += list.get(i-1).tuple[j]%i;
            }
            System.out.println(sum);
            answer = answer ^ sum;
            
        }
        //start
        
        return answer;
    }
    class Tuple implements Comparable<Tuple>{
        int[] tuple;
        int col;
        public Tuple(int[] tuple,int col ){
            this.tuple = tuple;
            this.col = col;
        }
        
        @Override
        public int compareTo(Tuple t){
            if(t.tuple[t.col-1] == this.tuple[this.col-1]){
                return t.tuple[0] - this.tuple[0];
            }
            else{
                return this.tuple[this.col-1] - t.tuple[t.col-1];
            }
        }
        @Override
        public String toString(){
            return Arrays.toString(this.tuple);
        }
        
    }
}