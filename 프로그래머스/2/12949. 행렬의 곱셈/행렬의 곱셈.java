class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //axb bxc라고 하자, a와 b는 서로 곱셈이 가능하다.
        int a = arr1.length;
        int b = arr2.length;
        int c = arr2[0].length;
        int[][] answer = new int[a][c];
            for(int cidx=0;cidx<c;cidx++){
                for(int m=0;m<b;m++){
                    for(int ridx =0;ridx<a;ridx++){
                    answer[ridx][cidx] += arr1[ridx][m]*arr2[m][cidx];

                }
            }
        }
        return answer;
    }
}