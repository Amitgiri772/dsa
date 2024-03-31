class Solution
{
    private static final int MOD = 1000_000_007;
    
    public int countWays(int n, int m)
    {
        // Code here
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        
        // return getWays(n, m, dp);
        
        return getWaysBottomUp(n, m);
    }
    
    int getWaysBottomUp(int n, int m){
        int[] dp = new int[n+1];
        
        // intialization part
        dp[0] = 1;
        
        // core dp logic
        for(int i = 1; i<= n; i++){
            int horz = i-m>=0? dp[i-m]: 0;
            int vert = dp[i-1];
            
            dp[i] = (horz + vert) % MOD;
        }
        
        return dp[n];
        
    }
    
    
    int getWays(int n, int m, int[] dp){
        if(n == 0)
            return 1;
            
        if(n < 0)
            return 0;
            
        if(dp[n] != -1){
            return dp[n];
        }
            
        int horz = getWays(n-m, m, dp);
        int vert = getWays(n-1, m, dp);
        dp[n] = (horz + vert)% MOD;
        return dp[n];
    }
    
}

// N = 4, M = 3, Output = 3
