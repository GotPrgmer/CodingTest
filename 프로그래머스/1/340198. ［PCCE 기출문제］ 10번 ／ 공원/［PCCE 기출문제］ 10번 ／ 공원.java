class Solution {
    public int solution(int[] mats, String[][] park) {
        int ans = -1;
        for(int i=0;i<mats.length;i++){
            for(int j =0;j<park.length-mats[i]+1;j++){
                for(int k =0;k<park[0].length-mats[i]+1;k++){
                    if(park[j][k].equals("-1")){
                        int cnt = 0;
                        for(int l=j;l<j+mats[i];l++){
                            for(int m=k;m<k+mats[i];m++){
                                if(park[l][m].equals("-1")){
                                    cnt += 1;
                                }
                                else{
                                    break;
                                }
                            }
                        }
                        if(cnt == mats[i]*mats[i]){
                            ans = Math.max(ans,mats[i]);
                        }
                    }
                }
            }
        }
        return ans;
    }
}