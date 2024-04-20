package Arrays.Part_1;

public class Maximum_Subarray_Sum {
    //Brute force T.C = O(n^3) and S.C = O(1)
    
    // public int maxSubArray(int[] nums) {
    //     int n = nums.length;
    //     int ans = Integer.MIN_VALUE;
    //     //starting index of subarray
    //     for(int i = 0; i < n; i++){
    //         //ending index of subarray
    //         for(int j = i; j < n; j++){
    //             int sum = 0;
    //             //adding all the elements from i to j
    //             for(int k = i; k <= j; k++){
    //                 sum+= nums[k];
    //             }
    //             if(sum > ans) ans = sum;
    //         }    
    //     }
    //     return ans;
    // }
    
    //Better approach T.C = O(n^2) and S.C = O(1)
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         int ans = Integer.MIN_VALUE;
//         for(int i = 0; i < n; i++){
//             int sum = 0;
//             for(int j = i; j < n; j++){
//                 sum += nums[j];
//                 ans = Math.max(sum, ans);
//             }
//         }
        
//         return ans;
//     }
    
    //Optimal Approach T.C = O(n) and S.C = O(1)
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum > ans) ans = sum;
            if(sum < 0) sum = 0;
        }
        return ans;
    }
    
    
     // Memoization t.c. = O(n) and s.c. = O(n)
    
//     int max = Integer.MIN_VALUE;
//     public int maxSubArray(int[] nums) {
//         if(nums.length == 1)return nums[0];
//         int[]dp = new int[nums.length];
//         Arrays.fill(dp,-1);
//         solve(nums, nums.length-1, dp);
//         return max;
//     }
    
//     public int solve(int[] nums, int n, int[]dp){
//         int maxSoFar = 0;
//         if(n == 0) {
//             maxSoFar = nums[0];
//             max = Math.max(max, maxSoFar);
//             return dp[n] = maxSoFar;
//         }
//         if(dp[n] != -1) return dp[n];
//         maxSoFar = Math.max(nums[n], nums[n] + solve(nums, n-1,dp));
//         max = Math.max(max, maxSoFar);
//         return dp[n] = maxSoFar;
//     }
    
    
    //Tabulation t.c. = O(n) and s.c. = O(n)
    
    // public int maxSubArray(int[] nums){
    //     int[] dp = new int[nums.length];
    //     dp[0] = nums[0];
    //     int max = nums[0];
    //     for(int i = 1; i < nums.length; i++){
    //         dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
    //         max = Math.max(max, dp[i]);
    //     }
    //     return max;
    // }

    public static void main(String[] args){
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        long maxSum = maxSubArray(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}

