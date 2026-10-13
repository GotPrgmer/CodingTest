class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 두가지 숫자의 합이 target이 되는 한가지 페어를 찾는 것
        // 완전탐색
        // 10^8 통과 가능 but 최적화 가능
        // 투 포인터로 n먼저 스캔해서 target에서 각 숫자 뺀다음
        // 다시 돌리면서 target과 정확한 숫자가 나오면 그걸 정답으로 도출하면 O(N)으로 해결가능
        // n*(n-1) 탐색
        boolean isEnd = false;
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    isEnd = true;
                    break;
                }
            }
            if(isEnd) break;
        }
        return ans;
    }
}