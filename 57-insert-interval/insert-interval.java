class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //어떤 인터벌이랑 겹치는지 확인 겹치면 최소 최대 갱신
        // 그리고 output함
        int mergeSt = newInterval[0];
        int mergeEd = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        if(intervals.length == 0){
            return new int[][]{{mergeSt, mergeEd}};
        }
        Set<Integer> mergeIdx = new HashSet<>();
        // 10^4
        int idx = 0;
        boolean isMerged = false;
        boolean isInserted = false;
        int curS = -1;
        int curE = -1;
        
        for(int i=0;i<intervals.length;i++){ //10^4
        int s = intervals[i][0];
        int e = intervals[i][1];
        if(isInserted){
            ans.add(new int[]{s, e});
            continue;
        }

        if(e < mergeSt){
            ans.add(new int[]{s, e});
            idx++;
        }
        else if(mergeEd < s){
            ans.add(new int[]{mergeSt, mergeEd});
            ans.add(new int[]{s, e});

            isInserted = true;
        }
        else {
                isMerged = true;
                mergeSt = Math.min(mergeSt, s);
                mergeEd = Math.max(mergeEd, e);
            }
    }
    if(!isInserted) {
            ans.add(new int[]{mergeSt, mergeEd});
    }
        return ans.toArray(new int[ans.size()][]);
    }
}