class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //어떤 인터벌이랑 겹치는지 확인 겹치면 최소 최대 갱신
        // 그리고 output함
        int mergeSt = newInterval[0];
        int mergeEd = newInterval[1];
        if(intervals.length == 0){
            return new int[][]{{mergeSt, mergeEd}};
        }
        Set<Integer> mergeIdx = new HashSet<>();
        for(int i=0;i<intervals.length;i++){
            for(int j=intervals[i][0];j<=intervals[i][1];j++){
                if(newInterval[0] <= j && j<=newInterval[1]){
                    // 겹침
                    mergeIdx.add(i);
                    mergeSt = Math.min(mergeSt, intervals[i][0]);
                    mergeEd = Math.max(mergeEd, intervals[i][1]);
                    break;
                }
            }
        }
        int[][] ans = new int[intervals.length-mergeIdx.size()+1][2];
        int ansSize = 0;
        boolean flag = false;
        for(int i=0;i<intervals.length;i++){
            if(mergeIdx.contains(i)){
                if(!flag){
                    ans[ansSize][0] = mergeSt;
                    ans[ansSize][1] = mergeEd;
                    ansSize += 1;
                    flag = true;
                }
                continue;
            }
            ans[ansSize][0] = intervals[i][0];
            ans[ansSize][1] = intervals[i][1];
            ansSize += 1;
        }
        if(!flag){
            ans[ansSize][0] = mergeSt;
            ans[ansSize][1] = mergeEd;
        }
        Arrays.sort(ans, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(mergeSt);
        System.out.println(mergeEd);
        return ans;
    }
}
// 겹치는게 있을때 -> 해결
// 겹치는게 없을때 -> 추가되는것을 어디에 배치?
// 