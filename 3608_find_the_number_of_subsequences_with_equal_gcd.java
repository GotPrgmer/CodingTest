class Solution {
    static int[] staticNums;
    static int ans;
    static int MAX = 201;

    public int subsequencePairCount(int[] nums) {
        // seq1먼저 구하고
        // seq1이 아니고 seq2에 포함되지 않은 것들을 추려서
        // gcd를 각각 구한다음에 같으면 ++를 한다.

        // 경우의 수를 줄일 수 있냐?
        // -> 어려워보임 어떤 경우가 해당되는지는 끝까지 탐색해봐야하기 때문
        // 하나의 경우의 수에서 속도를 빠르게 할 수 있냐?
        // -> 
        // 하나의 경우는 gcd로 확인을 하기에 충분히 빠름
        // 지금 연산 비용은 NCK(1<=K<N)*NCM(1<=M<=N-K)*gcd연산
        

        staticNums = nums;

        int[][][] dp = new int[2][MAX][MAX];
        dp[0][0][0] = 1;
        int[][] gcdResults = new int[MAX][MAX];

        for(int i=0;i<MAX;i++){
            for(int j=0;j<MAX;j++){
                gcdResults[i][j] = gcd(i,j);
            }
        }
        ans = 0;
        for (int i=0; i < nums.length; i++){
            for(int j=0;j<MAX;j++){
                for(int k=0;k<MAX;k++){
                    dp[1][j][k] = 0;
                }
            }
            for(int j=0;j<MAX;j++){
                for(int k=0;k<MAX;k++){
                    if(dp[0][j][k] == 0) continue;
                    int curGCD1 = j;
                    int curGCD2 = k;
                    int seq1GCD = gcdResults[curGCD1][staticNums[i]];
                    int seq2GCD = gcdResults[curGCD2][staticNums[i]];
                    dp[1][seq1GCD][curGCD2] = (dp[1][seq1GCD][curGCD2]+ dp[0][curGCD1][curGCD2])%(1000000007);
                    dp[1][curGCD1][seq2GCD] = (dp[1][curGCD1][seq2GCD] + dp[0][curGCD1][curGCD2])%(1000000007);
                    dp[1][curGCD1][curGCD2] = (dp[1][curGCD1][curGCD2] + dp[0][curGCD1][curGCD2])%(1000000007);

                }
            }

            for(int j=0;j<MAX;j++){
                for(int k=0;k<MAX;k++){
                    dp[0][j][k] = dp[1][j][k];
                }
            }
        }

        for(int i=1;i<201;i++){
            ans = (ans + dp[0][i][i]) %(1000000007);
        }
        return ans;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}