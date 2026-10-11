class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //어떤 인터벌이랑 겹치는지 확인 겹치면 최소 최대 갱신
        // 그리고 output함
        int mergeSt = newInterval[0];
        int mergeEd = newInterval[1];
        int ns = mergeSt;
        int ne = mergeEd;
        if(intervals.length == 0){
            return new int[][]{{mergeSt, mergeEd}};
        }
        Set<Integer> mergeIdx = new HashSet<>();
        // 10^9
        for(int i=0;i<intervals.length;i++){ //10^4
        // 겹치는 경우는 완전 포갬, 왼쪽으로 걸침, 중간에 들어감, 오른쪽으로 걸침 4가지 경우
        // 완전 포갬은 인터벌의 s, e가 있다면 ns <= s, e<= ne
        // 왼쪽 걸침은 ns <= s, s <= ne < e
        // 가운데 들어감은 s < ns < e, s < ne < e
        // 오른쪽 걸침 s < ns < e, ne < e
        int s = intervals[i][0];
        int e = intervals[i][1];

        if(!(ne < s || e < ns)){
            mergeIdx.add(i);
            mergeSt = Math.min(mergeSt, intervals[i][0]);
            mergeEd = Math.max(mergeEd, intervals[i][1]);
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
        return ans;
    }
}
// 겹치는게 있을때 -> 해결
// 겹치는게 없을때 -> 추가되는것을 어디에 배치?
// 