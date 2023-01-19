//Max sum subarray
public static int kadaneAlgo(int nums,int n){
    int sum = nums[0];
    int maxSum= nums[0];
    for(int i=1; i<n; i++)
    {
        sum = Math.max(sum + nums[i], nums[i]);
        maxSum= Math.max(sum, maxSum);
    }
    return maxSum
}
public static int kadaneAlgoMin(int nums,int n){
    int sum = nums[0];
    int minSum= nums[0];
    for(int i=1; i<n; i++)
    {
        sum = Math.min(sum + nums[i], nums[i]);
        maxSum= Math.min(sum, maxSum);
    }
    return minSum
}
