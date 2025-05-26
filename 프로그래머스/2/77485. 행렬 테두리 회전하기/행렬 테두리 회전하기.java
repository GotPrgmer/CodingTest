import java.util.*;
class Solution {
    int[] d_r = {0,1,0,-1};
    int[] d_c = {1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[] min_array = new int[queries.length];
        int[][] map = new int[rows][columns];
        int num = 1;
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                map[r][c] = num;
                num += 1;
            }
        }
        for(int i=0;i<queries.length;i++){
            int[] querie = queries[i];
            int x1 = querie[0];
            int y1 = querie[1];
            int x2 = querie[2];
            int y2 = querie[3];
            int cnt_max = (x2-x1+1)*2 + (y2-y1-1)*2;
            min_array[i] =move(x1,y1,x2,y2,cnt_max,map);
            // toString(map);
        }
        // Arrays.sort(min_array);
        return min_array;
    }
    public int move(int x1, int y1, int x2, int y2, int cnt_max,int[][] queries){
        int r = x1-1;
        int c = y1-1;
        int d = 0;
        int backup = queries[r][c];
        int min = queries[r][c];
        // System.out.println(min);
        for(int cnt= 1;cnt<=cnt_max+1;cnt++){
            //조건에 부합
            int n_r = r+d_r[d];
            int n_c = c+d_c[d];
            if(isArea(n_r,n_c,x1,y1,x2,y2)){
                int tmp = queries[n_r][n_c];
                min = Math.min(min,tmp);
                // System.out.println(backup);
                queries[n_r][n_c] = backup;
                backup = tmp;
            }
            //조건에 부적합
            else{
                d = (d+1)%4;
                n_r = r+d_r[d];
                n_c = c+d_c[d];
                if(isArea(n_r,n_c,x1,y1,x2,y2)){
                    int tmp = queries[n_r][n_c];
                    min = Math.min(min,tmp);
                    // System.out.println(backup);
                    queries[n_r][n_c] = backup;
                    backup = tmp;
            }
            }
            r = n_r;
            c = n_c;
        }
        return min;
    }
    public boolean isArea(int x, int y,int x1, int y1, int x2, int y2){
        if(x>=x1-1 && x<=x2-1 && y>=y1-1 && y<=y2-1){
            return true;
        }
        else{
            return false;
        }
    }
    public void toString(int[][] map){
        for(int i=0;i<map.length;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}